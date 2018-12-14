import dsa.Utils;
import practices.waterball.sorter.InsertionSort;
import dsa.algorithms.sorters.Sorter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.rmi.CORBA.Util;
import java.util.Arrays;

public class SortersTest {
    private static final int NUMBER_FROM = -50;
    private static final int NUMBER_TO = 50;
    private static final int NUMBER_SIZE = NUMBER_TO - NUMBER_FROM;

    private static final int[] massiveSortedNums = new int[NUMBER_SIZE];
    private static final int[] randomNumbers = Utils.createRandomNumbers(NUMBER_FROM, NUMBER_TO);

    private Sorter sorter = new InsertionSort();

    @BeforeClass
    public static void beforeClass(){
        for (int i = 0; i < NUMBER_SIZE; i ++)
            massiveSortedNums[i] = NUMBER_FROM + i;
    }

    @Before
    public void setup(){
        System.out.println("Before sorted: " + Arrays.toString(randomNumbers));
    }

    @Test
    public void testSorter(){
        sorter.sort(randomNumbers);
        System.out.println("After sorted: " +  Arrays.toString(randomNumbers));
        Assert.assertArrayEquals(massiveSortedNums, randomNumbers);
    }
}