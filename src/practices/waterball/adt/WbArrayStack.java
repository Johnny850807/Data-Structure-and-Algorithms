package practices.waterball.adt;

import dsa.adt.Stack;

public class WbArrayStack extends Stack{
    private int top = -1;
    private int[] elements = new int[MAX_SIZE];

    public WbArrayStack(int MAX_SIZE) {
        super(MAX_SIZE);
    }

    @Override
    public boolean isFull() {
        return top+1 == MAX_SIZE;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public Stack push(int item) {
        if (isFull())
            throw new RuntimeException("Full");
        elements[++top] = item;
        return this;
    }

    @Override
    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Empty");
        return elements[top--];
    }

}
