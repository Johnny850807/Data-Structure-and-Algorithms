package dsa.adt;

public abstract class ArrayQueue extends Queue {
    protected final int MAX_SIZE;
    protected final int[] elements;

    public ArrayQueue(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        this.elements = new int[MAX_SIZE];
    }
}
