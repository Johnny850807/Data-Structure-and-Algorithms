package dsa.adt;

public abstract class MultipleStack implements ADT{
    protected final int MAX_SIZE;
    protected final int[] elements;

    public MultipleStack(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        this.elements = new int[MAX_SIZE];
    }

    public abstract boolean isFull(int stackNumber);
    public abstract boolean isEmpty(int stackNumber);
    public abstract MultipleStack push(int stackNumber, int item);
    public abstract int pop(int stackNumber);
}
