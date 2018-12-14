package practices.waterball.adt;

import dsa.adt.AdtFactory;
import dsa.adt.Stack;

public class WbAdtFactory implements AdtFactory {

    @Override
    public Stack createArrayStack(int maxSize) {
        return new WbArrayStack(maxSize);
    }

    @Override
    public Stack createLinkedListStack() {
        return new WbLinkedListStack();
    }
}
