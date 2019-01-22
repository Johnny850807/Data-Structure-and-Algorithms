package practices.waterball.algorithms;


import dsa.algorithms.PatternMatching;

import java.util.HashMap;
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

        //preprocessing O(m)
        int modulo = 65537;  //prime modulo
        HashMap<Character, Integer> charHashTable = constructCharacterHashTable(T + P); //O(m)
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
                H[s+1] = (charSize * (H[s] - h*charHashTable.get(T.charAt(s))) + charHashTable.get(T.charAt(s+m))) % modulo;
            }
        }

        return -1;
    }

    private HashMap<Character, Integer> constructCharacterHashTable(String T){
        HashMap<Character, Integer> charHashTable = new HashMap<>();
        int id = 0;
        for (char c : T.toCharArray())
        {
            if (!charHashTable.containsKey(c))
                charHashTable.put(c, id++);
        }
        return charHashTable;
    }

    private int computeHashValue(int modulo, int charSize, String text, HashMap<Character, Integer> charHashTable) {
        char[] subChars = text.toCharArray();
        int val = 0;
        int base = 1;
        for (int i = subChars.length - 1; i >= 0; i--) {
            val = (val + base * charHashTable.get(subChars[i])) % modulo;
            base = (base * charSize) % modulo;
        }
        return val;
    }


    @Override
    public int automataMatching(String T, String P) {
        int n = T.length(), m = P.length();
        return -1;
    }

    @Override
    public int knuthMorrisPratt(String T, String P) {
        int n = T.length(), m = P.length();
        return -1;
    }
}
