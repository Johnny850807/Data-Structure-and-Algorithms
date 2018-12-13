package dsa.algorithms;

/**
 * Method prefixed by NR means Non-recursive, by R means Recursive.
 * See default methods NR_Factorization, R_Factorization as examples.
 */
public interface Recursives{

    default int NR_Factorization(int n){
        for (int i = n-1; i > 0; i --)
            n *= i;
        return n;
    }

    default int R_Factorization(int n){
        return n == 0 ? 1 : n*R_Factorization(n-1);
    }

    int NR_Fibonacci(int n);

    int R_Fibonacci(int n);

    int NR_binomialCoefficient(int n, int r);

    int R_binomialCoefficient(int n, int r);


    public static void main(String[] args) {
    }
}