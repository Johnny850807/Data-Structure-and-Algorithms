package dsa.algorithms;

/**
 * Method prefixed by NR means Non-recursive, by R means Recursive.
 * See default methods NR_Factorization, R_Factorization as examples.
 */
public interface BasicRecursive {

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

    int R_gcd(int a, int b);

    int NR_gcd(int a, int b);

    /**
     * @param n number of heaps
     * @param source move from where
     * @param buffer use where to buffer
     * @param target the place wanna makeSet on
     * @return the steps it takes and print the procedure
     */
    int R_towerOfHanoi(int n, char source, char buffer, char target);

    /**
     * @param nums a list of permuted nums, each row is a permutation
     * @param from beginning of the permutation range
     * @param to end of the permutation range
     * @return list of all possible permuted letters
     */
    void R_generatePermutation(int[] nums, int from, int to);


}