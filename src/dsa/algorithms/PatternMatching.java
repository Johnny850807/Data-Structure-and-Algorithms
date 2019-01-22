package dsa.algorithms;

/**
 * Parameters: T the matched string, P: the pattern string, return the index where P begins in T (return -1 if P does not exist in T)
 */
public interface PatternMatching {
    public int naivePatternMatching(String T, String P);
    public int rabinKarp(String T, String P);
    public int automataMatching(String T, String P);
    public int knuthMorrisPratt(String T, String P);
}
