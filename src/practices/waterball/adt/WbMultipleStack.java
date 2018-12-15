package practices.waterball.adt;

import dsa.adt.MultipleStack;

public class WbMultipleStack extends MultipleStack {

     WbMultipleStack(int MAX_SIZE) {
        super(MAX_SIZE);
    }

    @Override
    public boolean isFull(int stackNumber) {
        return false;
    }

    @Override
    public boolean isEmpty(int stackNumber) {
        return false;
    }

    @Override
    public MultipleStack push(int stackNumber, int item) {
        return null;
    }

    @Override
    public int pop(int stackNumber) {
        return 0;
    }
}
