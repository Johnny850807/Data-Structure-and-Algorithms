package dsa;

import java.util.Random;

public class Utils {

    public static int[] createRandomNumbers(int fromNum, int toNum){
        int[] nums = new int[toNum-fromNum];
        int index = 0;
        for (int i = index; i < nums.length; i ++)
            nums[i] = fromNum + i;

        shuffleArray(nums);
        return nums;
    }

    public static void shuffleArray(int[] ar)
    {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static void reverseArray(int[] array){
        for(int i = 0; i < array.length/2; i++){
            int temp = array[i];
            array[i] = array[array.length -i -1];
            array[array.length -i -1] = temp;
        }
    }
}
