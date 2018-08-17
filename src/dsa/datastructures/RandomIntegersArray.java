package dsa.datastructures;

import java.util.Random;

public class RandomIntegersArray extends Array<Integer> {

    public RandomIntegersArray(int from, int to) {
        super(to - from);
        int index = 0;
        for (int i = index; i < array.length; i ++)
            array[i] = from + i;

        shuffleArray(array);
    }

    static void shuffleArray(Object[] ar)
    {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            Object a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
