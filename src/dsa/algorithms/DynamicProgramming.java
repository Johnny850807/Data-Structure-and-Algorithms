package dsa.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public interface DynamicProgramming {

    /**
     * @param w total w
     * @param vs each item's value
     * @param ws each item's w
     */
    KnapSackAnswer R_01knapsack(int w, int[] vs, int[] ws);

    public static class KnapSackAnswer{
        public int maximalValue;
        public HashSet<Integer> takenItems;
        public KnapSackAnswer(int maximalValue, HashSet<Integer> takenItems) {
            this.maximalValue = maximalValue;
            this.takenItems = takenItems;
        }
    }

    int[] longestCommonSubsequence(int[] s1, int[] s2);

    int[] longestCommonString(int[] s1);

    int[] longestIncreasingSequence(int[] s1);

    /**
     * @param matrices matrix's representation e.g. A x B would give you {"A", "B"}
     * @param p length of matrices, if A is a mxn matrix, and its the first matrix whose index is 0, then p[0] = m, p[1] = n
     */
    MatrixChainAnswer matrixChainMultiplication(String[] matrices, int[] p);

    public static class MatrixChainAnswer{
        public int numberOfMultiplications;
        public String matrixChain; // e.g. (A((B(CD))E))

        public MatrixChainAnswer(int numberOfMultiplications, String matrixChain) {
            this.numberOfMultiplications = numberOfMultiplications;
            this.matrixChain = matrixChain;
        }
    }

    public MinimumEditDistance minimumEditDistance(StringBuilder A, StringBuilder b);

    public static class MinimumEditDistance{
        public LinkedList<Edition> editions = new LinkedList<>();
        public static class Edition{
            public enum Type{
                REMOVE, INSERT, REPLACE, NONE
            }
            public Type type;
            public String message;

            public Edition(Type type, String message) {
                this.type = type;
                this.message = message;
            }

            @Override
            public String toString() {
                switch (type) {
                    case INSERT:
                        return "←";
                    case REMOVE:
                        return "↑";
                    case NONE:
                        return "⇖";
                    case REPLACE:
                        return "↖";
                    default:
                        throw new Error();
                }
            }
        }
        public int length(){return editions.size();}

        @Override
        public String toString() {
            StringBuilder strb = new StringBuilder();
            for (int i = 0; i < editions.size(); i++) {
                Edition edition = editions.get(i);
                strb.append(i).append(": ").append(edition.type).append(" ").append(edition.message).append("\n");
            }
            return strb.toString().trim();
        }
    }
}
