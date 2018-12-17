package practices.max.adt;

import dsa.adt.*;

public class MaxAdtFactory implements AdtFactory {
    @Override
    public ArrayStack createArrayStack(int maxSize) {
        return null;
    }

    @Override
    public LinkedListStack createLinkedListStack() {
        return new MaxLinkedListStack();
    }

    @Override
    public MultipleStack createDoubleStack(int maxSize) {
        return null;
    }

    @Override
    public MultipleStack createMultipleStack(int n, int maxSize) {
        return null;
    }

    @Override
    public Queue createCircularArrayQueue(int maxSize) {
        return null;
    }

    @Override
    public Queue createSingleLinkedListQueue() {
        return null;
    }

    @Override
    public Queue createCircularLinkedListQueue() {
        return null;
    }

    @Override
    public LinkedList createLinkedList() {
        return null;
    }
}
