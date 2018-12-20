package practices.waterball.adt;

import dsa.adt.MinBinaryHeap;

import static dsa.Utils.swap;

public class WbMinBinaryHeap implements MinBinaryHeap {
    private int FULL_SIZE = 100;
    private int[] elements = new int[FULL_SIZE]; //index starts from 1
    private int count = 0;

    @Override
    public MinBinaryHeap insert(int item) {
        elements[++count] = item;
        adjustBottomUp(count);
        return this;
    }

    @Override
    public int delete() {
        int min = elements[1];
        elements[1] = elements[count--];
        adjustTopDown(1);
        return min;
    }

    private void adjustBottomUp(int i){
        while (i != 1 && elements[i] < elements[i/2])
        {
            swap(elements, i, i/2);
            i = i/2;
        }
    }

    private void adjustTopDown(int i){
        // i: parent, j: child
        int j = i*2;
        boolean done = false;
        while(j <= count && !done)
        {
            if (j < count &&
                    elements[j+1] < elements[j])
            {
                j = j+1;
            }
            if (elements[i] > elements[j])
            {
                swap(elements, i ,j);
                i = j;
            }
            else
                done = true;
            j *= 2;
        }
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
