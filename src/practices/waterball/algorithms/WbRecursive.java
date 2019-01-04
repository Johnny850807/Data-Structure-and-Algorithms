package practices.waterball.algorithms;

import dsa.algorithms.BasicRecursive;

import java.util.ArrayList;
import java.util.HashSet;


public class WbRecursive implements BasicRecursive {

    @Override
    public int NR_Fibonacci(int n) {
        int a = 0, b = 1, c = 0;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        for (int i = 2; i <= n ; i ++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    @Override
    public int R_Fibonacci(int n) {
        return n < 2 ? n : R_Fibonacci(n-1) + R_Fibonacci(n-2);
    }

    @Override
    public int NR_binomialCoefficient(int n, int r) {
        int nominator = n;
        int base = Math.max(r, n-r);
        int another = Math.min(r, n-r);
        for (int i = n-1; i > base; i --)
            nominator *= i;

        return nominator / NR_Factorization(another);
    }

    @Override
    public int R_binomialCoefficient(int n, int r) {
        if (n < r)
            return 0;
        return (r == n || r == 0) ? 1 : R_binomialCoefficient(n-1, r) + R_binomialCoefficient(n-1, r-1);
    }

    @Override
    public int R_gcd(int a, int b) {
        int num1 = Math.max(a, b);
        int num2 = Math.min(a, b);

        int r = num1 % num2;
        if (r == 0)
            return num2;
        return R_gcd(num2, r);
    }

    @Override
    public int NR_gcd(int a, int b) {
        int num1 = Math.max(a, b);
        int num2 = Math.min(a, b);
        int r = num1 % num2;

        while(r != 0)
        {
            r = num1 % num2;
            num1 = num2;
            num2 = r;
        }
        return num1;
    }

    private int exponent(int b, int n){
        return b == 0 ? 0:
                n == 0 ? 1: b*exponent(b, n-1);
    }

    @Override
    public int R_towerOfHanoi(int n, char source, char temporary, char target) {
        if (n == 1)
        {
            System.out.println("Move the sheet from " + source + " to " + target);
            return 1;
        }
        else
        {
            R_towerOfHanoi(n-1, source, target, temporary);
            R_towerOfHanoi(1, source, temporary, target);
            R_towerOfHanoi(n-1, temporary, source, target);
            return exponent(2, n)-1; //general solution of step count
        }
    }

    @Override
    public void R_generatePermutation(int[] nums, int from, int to) {
        if (from == to)
        {
            for (int i = 0; i <= to; i ++)
                System.out.print(nums[i]);
            System.out.println();
        }
        else
        {
            for (int i = from; i <= to; i ++)
            {
                swap(nums, from, i);
                R_generatePermutation(nums, from+1, to);
                swap(nums, from, i);
            }
        }
    }

    @Override
    public HashSet<HashSet<Integer>> powerSet(HashSet<Integer> set) {
        return powerSet(new ArrayList<>(set), new HashSet<HashSet<Integer>>(), new boolean[set.size()], 0);
    }

    private HashSet<HashSet<Integer>> powerSet(ArrayList<Integer> nums, HashSet<HashSet<Integer>> powerSet, boolean[] member, int k){
        if (k >= nums.size())
        {
            HashSet<Integer> subset = new HashSet<>();
            for (int i = 0; i < member.length; i++) {
                if (member[i])
                    subset.add(nums.get(i));
            }
            powerSet.add(subset);
        }
        else
        {
            member[k] = true;
            powerSet(nums, powerSet, member, k+1);
            member[k] = false;
            powerSet(nums, powerSet, member, k+1);
        }
        return powerSet;
    }

    private void printArray(int[] array){
        for (int i = 0; i < array.length; i ++)
            System.out.print(array[i]);
        System.out.println();
    }

    private void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
