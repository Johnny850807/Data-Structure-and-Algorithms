package practices.max.adt;

import dsa.adt.LinkedListStack;
import dsa.adt.SingleStack;

public class MaxLinkedListStack extends LinkedListStack{
    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public SingleStack push(int item) {
        return null;
    }

    @Override
    public int pop() {
        return 0;
    }
}
