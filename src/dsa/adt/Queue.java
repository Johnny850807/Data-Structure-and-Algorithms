package dsa.adt;

public abstract class Queue implements ADT {
    public abstract Queue add(int item);
    public abstract int delete();
    public abstract boolean isEmpty();
    public abstract boolean isFull();
}
