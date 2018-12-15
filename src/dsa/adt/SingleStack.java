package dsa.adt;

public interface SingleStack {
    boolean isFull();

    boolean isEmpty();

    SingleStack push(int item);

    int pop();
}
