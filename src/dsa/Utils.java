package dsa;

import java.util.*;

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

    public static String tableToString(int[] row, int fieldSize){
        return tableToString(new int[][]{row}, fieldSize);
    }

    public static String tableToString(long[] row, int fieldSize){
        int[] r = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            r[i] = (int) row[i];
        }
        return tableToString(new int[][]{r}, fieldSize);
    }

    public static String tableToString(int[][] table, int fieldSize){
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] aTable : table) {
            for (int j = 0; j < table[0].length; j++)
                stringBuilder.append(String.format("%" + fieldSize + "s",
                        aTable[j] == Integer.MAX_VALUE ? "∞" : aTable[j]));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static String tableToString(long[][] table, int fieldSize){
        StringBuilder stringBuilder = new StringBuilder();
        for (long[] aTable : table) {
            for (int j = 0; j < table[0].length; j++)
                stringBuilder.append(String.format("%" + fieldSize + "s",
                        aTable[j] == Integer.MAX_VALUE ? "∞" : aTable[j]));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static String tableToString(HashSet<Integer>[][] table, int fieldSize){
        StringBuilder stringBuilder = new StringBuilder();
        for (HashSet<Integer>[] aTable : table) {
            for (int j = 0; j < table[0].length; j++)
                stringBuilder.append(String.format("%" + fieldSize + "s", setToString(aTable[j])));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static String setToString(Set<Integer> set){
        StringBuilder stringBuilder = new StringBuilder();
        if (set.isEmpty())
            return "∅";
        stringBuilder.append("{");
        for (int num : set) {
            stringBuilder.append(num).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("}");
        return stringBuilder.toString();

    }
    public static String tableToString(int[][] table){
        return tableToString(table, 4);
    }

    public static String listToString(List list){
        StringBuilder stringBuilder = new StringBuilder();
        for (Object o : list) {
            stringBuilder.append(o).append(" ");
        }
        return stringBuilder.toString().trim();
    }
    public static boolean arrayLessOrEqual(int[] arr1, int[] arr2){
        for (int i = 0; i < arr1.length; i ++)
            if (arr1[i] > arr2[i])
                return false;
        return true;
    }

    public static int[] arrayPlus(int[] arr1, int[] arr2){
        int[] s = new int[arr1.length];
        for (int i = 0; i < arr1.length; i ++)
            s[i] = arr1[i] + arr2[i];
        return s;
    }

    public static int[] arraySub(int[] arr1, int[] arr2){
        int[] s = new int[arr1.length];
        for (int i = 0; i < arr1.length; i ++)
            s[i] = arr1[i] - arr2[i];
        return s;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        /*array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];*/
    }

    public static int[] intListToArray(List<Integer> integerList){
        int[] arr = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            arr[i] = integerList.get(i);
        }
        return arr;
    }

    public static int[] padddingZero(int[] array, int index, int length){
        int[] p = new int[array.length+length];
        for (int i = 0; i < length; i ++)
            p[i] = 0;
        for (int i = length; i < p.length; i ++)
            p[i] = array[i-length];
        return p;
    }

    public static class PrioritySet<T> {
        private TreeSet<T> treeSet;

        public PrioritySet(Comparator<T> comparator) {
            this.treeSet = new TreeSet<>(comparator);
        }

        public T extractMin(){
            return treeSet.pollFirst();
        }

        public boolean contains(T t){
            return treeSet.contains(t);
        }

        public void updateKey(T t){
            treeSet.remove(t);
            treeSet.add(t);
        }
        public boolean isEmpty(){
            return treeSet.isEmpty();
        }
        public void add(T t){
            treeSet.add(t);
        }
    }
}
