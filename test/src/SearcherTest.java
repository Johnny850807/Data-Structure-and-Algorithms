import dsa.algorithms.Searcher;
import org.junit.Before;
import org.junit.Test;
import practices.waterball.algorithms.WbSearcher;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class SearcherTest {
    private static final int NUM = 10;
    private int[] array = new int[NUM];
    private Searcher searcher = new WbSearcher();  //replace it with yours

    @Before
    public void setupNumbers(){
        for (int i = 0; i < NUM; i ++)
            array[i] = i;
    }

    @Test
    public void testSearch(){
        assertSearching((data)-> searcher.linearSearch(array, data));
        assertSearching((data)-> searcher.NR_binarySearch(array, data));
        assertSearching((data)-> searcher.R_binarySearch(array, data, 0, array.length-1));
    }

    private void assertSearching(Function<Integer, Integer> searching){
        for (int i = 0; i < NUM; i ++)
            assertEquals(i, searching.apply(array[i]).intValue());

        //fail search should return -1
        assertEquals(-1, searching.apply(-1).intValue());
    }
}
