import dsa.algorithms.PatternMatching;
import org.junit.Assert;
import org.junit.Test;
import practices.waterball.algorithms.WbPatternMatching;

import static org.junit.Assert.assertEquals;

public class PatternMatchingTest {
    private PatternMatching patternMatching = new WbPatternMatching();  //replace with yours

    @Test
    public void test() {
        testEachAlgorithm("ABCD", "ABC", 0);
        testEachAlgorithm("APPLE", "PP", 1);
        testEachAlgorithm("APPLE BANANA ORANGE", "NA OR", 10);
        testEachAlgorithm("BAAAAAAAAAAAAAAAAAAA", "A", 1);
        testEachAlgorithm("AAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", -1);
        testEachAlgorithm("AP _ P LE", " ", 2);
        testEachAlgorithm("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "BCDEFGHIJKLMNOPQRSTUVWXY", 1);
        testEachAlgorithm("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "Z", 25);
        testEachAlgorithm("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "(>_<)", -1);
        testEachAlgorithm("", "(>_<)", -1);
        testEachAlgorithm("Both implementations (>_<)", "(>_<)", 21);
    }

    public void testEachAlgorithm(String T, String P, int expectedIndex) {
        assertEquals(expectedIndex, patternMatching.naivePatternMatching(T, P));
        assertEquals(expectedIndex, patternMatching.rabinKarp(T, P));
        assertEquals(expectedIndex, patternMatching.automataMatching(T, P));
        //assertEquals(expectedIndex, patternMatching.knuthMorrisPratt(T, P));*/
    }
}
