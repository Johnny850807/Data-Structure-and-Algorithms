import dsa.Utils;
import practices.waterball.algorithms.WbSorter;
import dsa.algorithms.Sorter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class SortersTest {
    private static final int NUMBER_FROM = -50;
    private static final int NUMBER_TO = 50;
    private static final int NUMBER_SIZE = NUMBER_TO - NUMBER_FROM;

    private static final int[] massiveSortedNums = new int[NUMBER_SIZE];
    private int[] randomNumbers;

    private Sorter sorter = new WbSorter();  // replace this with your own sorter

    @BeforeClass
    public static void beforeClass(){
        for (int i = 0; i < NUMBER_SIZE; i ++)
            massiveSortedNums[i] = NUMBER_FROM + i;
    }

    @Before
    public void setup(){
        randomNumbers = Utils.createRandomNumbers(NUMBER_FROM, NUMBER_TO);
        System.out.println("Before sorted: " + Arrays.toString(randomNumbers));
    }

    @Test
    public void testBubbleSort(){
        sorter.bubbleSort(randomNumbers);
        System.out.println("After bubble sort: " +  Arrays.toString(randomNumbers));
        Assert.assertArrayEquals(massiveSortedNums, randomNumbers);
    }

    @Test
    public void testInsertionSort(){
        sorter.insertionSort(randomNumbers);
        System.out.println("After insertionSort sort: " +  Arrays.toString(randomNumbers));
        Assert.assertArrayEquals(massiveSortedNums, randomNumbers);
    }

    @Test
    public void testMergeSort(){
        sorter.mergeSort(randomNumbers);
        System.out.println("After mergeSort sort: " +  Arrays.toString(randomNumbers));
        Assert.assertArrayEquals(massiveSortedNums, randomNumbers);
    }

    @Test
    public void testQuickSort(){
        sorter.quickSort(randomNumbers);
        System.out.println("After quickSort sort: " +  Arrays.toString(randomNumbers));
        Assert.assertArrayEquals(massiveSortedNums, randomNumbers);
    }

    @Test
    public void testRadixSort(){
        sorter.radixSort(randomNumbers);
        System.out.println("After radixSort sort: " +  Arrays.toString(randomNumbers));
        Assert.assertArrayEquals(massiveSortedNums, randomNumbers);
    }

}