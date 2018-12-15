package dsa.adt;

public abstract class LinkedListStack implements SingleStack{
    public abstract boolean isFull();
    public abstract boolean isEmpty();
    public abstract LinkedListStack push(int item);
    public abstract int pop();
}
