package dsa.adt;

public abstract class Stack implements ADT{
    protected final int MAX_SIZE;

    public Stack(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    public abstract boolean isFull();
    public abstract boolean isEmpty();
    public abstract Stack push(int item);
    public abstract int pop();
}
