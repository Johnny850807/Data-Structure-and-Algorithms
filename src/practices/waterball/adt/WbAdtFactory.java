package practices.waterball.adt;

import dsa.adt.AdtFactory;
import dsa.adt.ArrayStack;
import dsa.adt.LinkedListStack;
import dsa.adt.MultipleStack;

public class WbAdtFactory implements AdtFactory {

    @Override
    public ArrayStack createArrayStack(int maxSize) {
        return new WbArrayStack(maxSize);
    }

    @Override
    public LinkedListStack createLinkedListStack() {
        return new WbLinkedListStack();
    }

    @Override
    public MultipleStack createDoubleStack(int maxSize) {
        return new WbDoubleStack(maxSize);
    }

    @Override
    public MultipleStack createMultipleStack(int n, int maxSize) {
        return new WbMultipleStack(maxSize);
    }
}
