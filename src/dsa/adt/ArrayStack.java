package dsa.adt;

public abstract class ArrayStack implements SingleStack{
    protected final int MAX_SIZE;
    protected final int[] elements;

    public ArrayStack(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        this.elements = new int[MAX_SIZE];
    }

    public abstract boolean isFull();
    public abstract boolean isEmpty();
    public abstract ArrayStack push(int item);
    public abstract int pop();
}
