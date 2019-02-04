package practices.waterball.algorithms;


import dsa.algorithms.PatternMatching;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;

import static java.lang.Math.min;
import static java.lang.Math.pow;

public class WbPatternMatching implements PatternMatching {
    @Override
    public int naivePatternMatching(String T, String P) {
        int n = T.length(), m = P.length();

        for (int s = 0; s < n - m + 1; s++) {
            if (T.substring(s, s+m).equals(P))
                return s;
        }

        return -1;
    }

    @Override
    public int rabinKarp(String T, String P) {
        int n = T.length(), m = P.length();
        if (n <= m)
            return T.equals(P) ? 0 : -1;

        int[] H = new int[n-m+1];

        //preprocessing θ(m)
        int modulo = 65537;  //prime modulo
        HashMap<Character, Integer> charHashTable = constructCharacterHashTable(P); //O(m)
        int charSize = charHashTable.size();
        int patternHash = computeHashValue(modulo, charSize, P, charHashTable); //O(m)
        H[0] = computeHashValue(modulo, charSize, T.substring(0, m), charHashTable);  //O(m)

        //processing 'avg' O(n + m) // worst case O((n+m-1)m) : all are spurious matches
        for (int s = 0; s < n - m + 1; s ++)
        {
            if (H[s] == patternHash)
                if (T.substring(s, s+m).equals(P)) // check for spurious match
                    return s;
            if (s+1 < H.length) {
                int h = (int) (pow(charSize, m-1)) % modulo;
                H[s+1] = (charSize * (H[s] - h*charHashTable.getOrDefault(T.charAt(s), 0)) + charHashTable.getOrDefault(T.charAt(s+m), 0)) % modulo;
            }
        }

        return -1;
    }

    private int computeHashValue(int modulo, int charSize, String text, HashMap<Character, Integer> charHashTable) {
        char[] subChars = text.toCharArray();
        int val = 0;
        int base = 1;
        for (int i = subChars.length - 1; i >= 0; i--) {
            int hash = charHashTable.getOrDefault(subChars[i], 0);
            val = (val + base*hash) % modulo;
            base = (base * charSize) % modulo;
        }
        return val;
    }

    @Override
    public int automataMatching(String T, String P) {
        int n = T.length(), m = P.length();

        //preprocessing θ(n * charSize)
        HashMap<Character, Integer> charHashTable = constructCharacterHashTable(P);  //θ(m)
        HashMap<SimpleEntry<Integer, Character>, Integer> automata = new HashMap<>();

        //construct the automata
        for (int i = 0; i <= m; i++) {
            for (char c : charHashTable.keySet()) {
                String text = P.substring(0, i).concat(String.valueOf(c));
                int p = longestPrefixLength(text, P);
                automata.put(new SimpleEntry<>(i, c), p);
            }
        }

        //processing θ(n) exactly
        int state = 0;
        for (int i = 0; i < n; i ++){
            state = automata.getOrDefault(new SimpleEntry<>(state, T.charAt(i)), 0);
            if (state == m)
                return i-m+1;
        }

        return -1;
    }

    private int longestPrefixLength(String text, String P){
        int k = min(text.length(), P.length());
        while (k > 0){
            if (P.substring(0, k).equals(text.substring(text.length()-k, text.length())))
                return k;
            k --;
        }
        return 0;
    }

    @Override
    public int knuthMorrisPratt(String T, String P) {
        int n = T.length(), m = P.length();
        int[] A = suffixFunction(P);
        int k = -1;

        for (int i = 0; i < n; i++) {
            while (k >= 0 && P.charAt(k+1) != T.charAt(i))
                k = A[k];
            if (P.charAt(k+1) == T.charAt(i))
                k ++;
            if (k+1 == m)
                return i - m + 1;
        }

        return -1;
    }

    private int[] suffixFunction(String P){
        int m = P.length();
        int[] A = new int[m];
        int i = -1;
        A[0] = -1;

        for (int q = 1; q < m; q++) {
            while (i >= 0 && P.charAt(i + 1) != P.charAt(q))
                i = A[i];
            if (P.charAt(i + 1) == P.charAt(q))
                i ++;
            A[q] = i;
        }
        return A;
    }


    private HashMap<Character, Integer> constructCharacterHashTable(String P){
        HashMap<Character, Integer> charHashTable = new HashMap<>();
        int id = 0;
        for (char c : P.toCharArray())
        {
            if (!charHashTable.containsKey(c))
                charHashTable.put(c, id++);
        }
        return charHashTable;
    }
}
