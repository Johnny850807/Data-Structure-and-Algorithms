package dsa.adt;

public interface Deque {
    Deque addHead(int item);
    int deleteHead();
    Deque addTail(int item);
    int deleteTail();
    boolean isEmpty();
    boolean isFull();
}
