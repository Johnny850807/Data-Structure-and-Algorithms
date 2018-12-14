package practices.waterball.adt;

import dsa.adt.Stack;

public class WbStack extends Stack{
    public WbStack(int MAX_SIZE) {
        super(MAX_SIZE);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Stack push(int item) {
        return null;
    }

    @Override
    public int pop() {
        return 0;
    }

}
