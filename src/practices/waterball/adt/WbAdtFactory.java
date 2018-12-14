package practices.waterball.adt;

import dsa.adt.ADT;
import dsa.adt.AdtFactory;
import dsa.adt.Stack;

public class WbAdtFactory implements AdtFactory {
    @Override
    public Stack createStack(int maxSize) {
        return new WbStack(maxSize);
    }
}
