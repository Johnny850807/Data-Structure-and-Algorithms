package practices.waterball;

import dsa.algorithms.Recursives;

public class MyRecursives implements Recursives{

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
}
