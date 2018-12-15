package practices.waterball.adt;

import dsa.adt.ArrayStack;

public class WbArrayStack extends ArrayStack {
    private int top = -1;

    WbArrayStack(int MAX_SIZE) {
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
    public ArrayStack push(int item) {
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
