package dsa.adt;

public interface PriorityQueue {
    PriorityQueue insert(int item);
    int delete();
    boolean isEmpty();
}
