import dsa.Utils;
import dsa.algorithms.Searcher;
import org.junit.Before;
import org.junit.Test;
import practices.waterball.algorithms.WbSearcher;

import java.awt.font.NumericShaper;
import java.util.function.Function;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SearcherTest {
    private static final int NUM = 1001;
    private int[] sortedArray = new int[NUM];
    private int[] randomArray;
    private Searcher searcher = new WbSearcher();  //replace it with yours

    @Before
    public void setupNumbers(){
        for (int i = 0; i < NUM; i ++)
            sortedArray[i] = i;
        randomArray = IntStream.range(0, NUM).toArray();  //0~1000
        Utils.shuffleArray(randomArray);
    }

    @Test
    public void testSearch(){
        assertSearching((data)-> searcher.linearSearch(sortedArray, data));
        assertSearching((data)-> searcher.NR_binarySearch(sortedArray, data));
        assertSearching((data)-> searcher.R_binarySearch(sortedArray, data, 0, sortedArray.length-1));
    }

    private void assertSearching(Function<Integer, Integer> searching){
        for (int i = 0; i < NUM; i ++)
            assertEquals(i, searching.apply(sortedArray[i]).intValue());

        //fail search should return -1
        assertEquals(-1, searching.apply(-1).intValue());
    }

    @Test
    public void testSelection(){
        int expected500thMin = 499;
        assertEquals(expected500thMin, searcher.selectionMin(randomArray, 500));
    }

    @Test
    public void testFindMinMax(){
        Searcher.MinMax minMax = searcher.findMinMax(sortedArray);
        assertEquals(0, minMax.min);
        assertEquals(NUM-1, minMax.max);
    }

    @Test
    public void testFindMajority(){
        final int MAJORITY = 999999;
        int[] nums = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            if (i < NUM/2)
                nums[i] = i;
            else
                nums[i] = MAJORITY;
        }
        Utils.shuffleArray(nums);
        int majority = searcher.findMajority(nums);
        assertEquals(majority, majority);
        assertEquals(-1, searcher.findMajority(sortedArray));
    }
}
