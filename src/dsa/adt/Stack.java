package dsa.adt;

public interface Stack {
    boolean isFull();

    boolean isEmpty();

    Stack push(int item);

    int pop();
}
