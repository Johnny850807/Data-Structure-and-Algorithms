import practices.waterball.sorter.InsertionSort;
import dsa.algorithms.sorters.Sorter;
import dsa.datastructures.RandomIntegersArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class SortersTest {
    private static final int NUMBER_FROM = -50;
    private static final int NUMBER_TO = 50;
    private static final int NUMBER_SIZE = NUMBER_TO - NUMBER_FROM;

    private static final Integer[] massiveSortedNums = new Integer[NUMBER_SIZE];
    private RandomIntegersArray dsa = new RandomIntegersArray(NUMBER_FROM, NUMBER_TO);

    private Sorter sorter = new InsertionSort();

    @BeforeClass
    public static void beforeClass(){
        for (int i = 0; i < NUMBER_SIZE; i ++)
            massiveSortedNums[i] = NUMBER_FROM + i;
    }

    @Before
    public void setup(){
        System.out.println("Before sorted: " + dsa);
    }

    @Test
    public void testSorter(){
        sorter.sort(dsa);
        System.out.println("After sorted: " + dsa);
        Assert.assertTrue(Arrays.deepEquals(massiveSortedNums, dsa.getArray()));
    }
}