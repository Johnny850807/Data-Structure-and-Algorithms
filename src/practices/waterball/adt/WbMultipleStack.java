package practices.waterball.adt;

import dsa.adt.MultipleStack;

/**
 * For size 13 multiple 3-stack
 *    0     1     2     3     4     5     6     7     8     9    10    11    12
 *   top0                   top1                     top2
 * bottom0->               bottom1->               bottom2->
 */
public class WbMultipleStack extends MultipleStack {
    private final int[] tops;
    private final int[] bottoms;

    WbMultipleStack(int stackCount, int MAX_SIZE) {
        super(stackCount, MAX_SIZE);
        this.tops = new int[MAX_SIZE];
        this.bottoms = new int[MAX_SIZE];

        int stackSize = MAX_SIZE / stackCount;
        for (int n = 0; n < stackCount; n ++)
            tops[n] = bottoms[n] = n*stackSize;
    }

    @Override
    public boolean isFull(int stackNumber) {
        return tops[stackNumber] >= MAX_SIZE ||
                tops[stackNumber] == bottoms[stackNumber+1];
    }

    @Override
    public boolean isEmpty(int stackNumber) {
        return tops[stackNumber] == bottoms[stackNumber];
    }

    @Override
    public MultipleStack push(int stackNumber, int item) {
        if (isFull(stackNumber))
            throw new RuntimeException("Full");
        elements[tops[stackNumber]++] = item;
        return this;
    }

    @Override
    public int pop(int stackNumber) {
        if (isEmpty(stackNumber))
            throw new RuntimeException("Empty");
        return elements[--tops[stackNumber]];
    }
}
