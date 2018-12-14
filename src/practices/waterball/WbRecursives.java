package practices.waterball;

import dsa.algorithms.Recursives;


public class WbRecursives implements Recursives{

    @Override
    public int NR_Fibonacci(int n) {
        int a = 0, b = 1, c = 0;
        if (n == 0)
            return a;
        if (n == 1)
            return b;
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
            return exponent(2, n)-1; //general solution
        }
    }

    @Override
    public void R_permutation(int[] nums, int from, int to) {
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
                R_permutation(nums, from+1, to);
                swap(nums, from, i);
            }
        }
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

    @Override
    public int R_01knapsack(int n, int w) {

        return 0;
    }
}
