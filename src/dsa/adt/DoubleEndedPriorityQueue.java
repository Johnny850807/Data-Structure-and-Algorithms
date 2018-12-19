package dsa.adt;

public interface DoubleEndedPriorityQueue {
    void insert(int item);
    int deleteMin();
    int deleteMax();
    int min();
    int max();
}
