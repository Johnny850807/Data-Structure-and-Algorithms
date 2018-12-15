package practices.waterball.adt;

import dsa.adt.MultipleStack;

/**
 * For the max size 10 double stack
 * -1 [ 0  1  2  3  4  5  6  7  8  9 10 ] 11
 *  ↑                                     ↑
 * top0                                  top1
 */
public class WbDoubleStack extends MultipleStack {
    private int top0;
    private int top1;
     WbDoubleStack(int MAX_SIZE) {
        super(2, MAX_SIZE);
        top0 = -1;
        top1 = MAX_SIZE;
    }

    @Override
    public boolean isFull(int stackNumber) {
         if (stackNumber == 0)
         {
             return top0 + 1 == top1;
         }
         else if (stackNumber == 1)
         {
            return top1 - 1 == top0;
         }
         throw new RuntimeException("No stack of #" + stackNumber);
    }

    @Override
    public boolean isEmpty(int stackNumber) {
        if (stackNumber == 0)
        {
            return top0 == -1;
        }
        else if (stackNumber == 1)
        {
            return top1 == MAX_SIZE;
        }
        throw new RuntimeException("No stack of #" + stackNumber);
    }

    @Override
    public MultipleStack push(int stackNumber, int item) {
        if (isFull(stackNumber))
            throw new RuntimeException("Full");

        if (stackNumber == 0)
        {
            elements[++top0] = item;
            return this;
        }
        else if (stackNumber == 1)
        {
            elements[--top1] = item;
            return this;
        }

        throw new RuntimeException("No stack of #" + stackNumber);
    }

    @Override
    public int pop(int stackNumber) {
        if (isEmpty(stackNumber))
            throw new RuntimeException("Empty");

        if (stackNumber == 0)
        {
            return elements[top0--];
        }
        else if (stackNumber == 1)
        {
            return elements[top1++];
        }
        throw new RuntimeException("No stack of #" + stackNumber);
    }
}
