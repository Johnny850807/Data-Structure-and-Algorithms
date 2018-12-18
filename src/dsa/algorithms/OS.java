package dsa.algorithms;

public interface OS {

    public interface Banker{
        /**
         * @param n num of processes
         * @param m num of resources
         * @param available a vector of numbers of available resources of each type
         * @param max n x m matrix defines maximum demand of each process
         * @param allocation n x m matrix defines the number of resources of each type currently allocated to each process
         * @param need n x m matrix indicates the remaining resource need of each process
         * @return whether the system is in a safe state
         */
        boolean safetyAlgorithm(int n, int m, int[] available, int[][] max, int[][] allocation, int[][] need);


        /**
         * @param n num of processes
         * @param m num of resources
         * @param available a vector of numbers of available resources of each type
         * @param max n x m matrix defines maximum demand of each process
         * @param allocation n x m matrix defines the number of resources of each type currently allocated to each process
         * @param need n x m matrix indicates the remaining resource need of each process
         * @param request n x m matrix indicated each the number of resources instances of each type demanded by each process
         * @return whether the request can be safely granted
         */
        boolean resourceRequestAlgorithm(int n, int m, int[] available, int[][] max, int[][] allocation, int[][] need, int[][] request);

    }
}
