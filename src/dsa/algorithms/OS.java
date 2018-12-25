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
         * @return the safe sequence in the order of the process's index, return null if there does not exist any safe sequence
         */
        int[] safetyAlgorithm(int n, int m, int[] available, int[][] max, int[][] allocation, int[][] need);


        /**
         * @param n num of processes
         * @param m num of resources
         * @param available a vector of numbers of available resources of each type
         * @param max n x m matrix defines maximum demand of each process
         * @param allocation n x m matrix defines the number of resources of each type currently allocated to each process
         * @param need n x m matrix indicates the remaining resource need of each process
         * @param request n x m matrix indicated each the number of resources instances of each type demanded by each process
         * @return RequestGrantState
         */
        RequestGrantState resourceRequestAlgorithm(int n, int m, int[] available, int[][] max, int[][] allocation, int[][] need, int[][] request);

        public static class RequestGrantState{
            public boolean granted;
            public int mustWaitProcess;
            public boolean available;

            public RequestGrantState(boolean granted, int mustWaitProcess, boolean available) {
                this.granted = granted;
                this.mustWaitProcess = mustWaitProcess;
                this.available = available;
            }

            public static RequestGrantState mustWait(int process){
                return new RequestGrantState(false, process, true);
            }
            public static RequestGrantState safeGranted(){
                return new RequestGrantState(true, -1, true);
            }
            public static RequestGrantState nonAvailable(){
                return new RequestGrantState(false, -1, false);
            }
            public static RequestGrantState unsafeNotGranted(){
                return new RequestGrantState(false, -1, true);
            }
        }
    }

    public interface DiningMonitor {
        void pick(int i) throws InterruptedException;
        void putDown(int i) throws InterruptedException;
    }
}
