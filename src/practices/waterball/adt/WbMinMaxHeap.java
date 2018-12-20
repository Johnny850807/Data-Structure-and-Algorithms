package practices.waterball.adt;

import dsa.adt.MinMaxHeap;

import static java.lang.Math.log;

public class WbMinMaxHeap extends MinMaxHeap {
    private final int MAX_SIZE = 100;
    private int n = 0;
    private int[] h = new int[MAX_SIZE];
    @Override
    public void insert(int item) {
        h[++n] = item;

        if (n != 1)  //not root
        {
            int p = n /2;  //parent
            int parent = h[p];
            if (getLevel(p) % 2 == 1) //parent in min level
            {
                if (item < parent)
                {
                    h[n] = h[p]; //swap between parent and child
                    bubbleUpMin(p, item);
                }
                else
                    bubbleUpMax(n, item);
            }
            else //parent in max level
            {
                if (item > parent)
                {
                    h[n] = h[p]; //swap between parent and child
                    bubbleUpMax(p, item);
                }
                else
                    bubbleUpMin(n, item);
            }
        }
    }

    private void bubbleUpMin(int i, int x) {
        int gp = i/4;
        while(gp != 0)
        {
            if (h[x] < h[gp])
            {
                h[i] = h[gp];
                i = gp;
                gp /= 4;
            }
            else
                gp = 0;  //done
        }
        h[i] = x;
    }

    private void bubbleUpMax(int i, int x) {
        int gp = i/4;
        while(gp != 0)
        {
            if (h[x] > h[gp])
            {
                h[i] = h[gp];
                i = gp;
                gp /= 4;
            }
            else
                gp = 0;  //done
        }
        h[i] = x;
    }

    private int getLevel(int nodeNumber){
        return (int) Math.ceil(log(nodeNumber+1));
    }

    @Override
    public int deleteMin() {
        int min = h[1];
        int x = h[n--];
        int k;
        h[1] = x;  //insert it into the root

        //Three cases
        if(n == 1)  //only root itself
            return min;
        if (n >= 4)  //the root has descendants
        {
            k = findMinIndexExceptRoot(); //find min at descendants
            if (k == 2 || k == 3) //min node is the root's child
            {
                if (x <= h[k])
                    h[1] = x;
                else  //swap
                {
                    h[1] = h[k];
                    h[k] = x;
                }
            }
            else //min node is the root's descendant
            {
                int p = k/2;
                if (x <= h[k])
                    h[1] = x;
                else  //swap
                {
                    h[1] = h[k];
                    if (h[p] < x)
                    {
                        h[p] = x;
                        x = h[1] = h[p];

                    }
                }
            }

        }
        return min;
    }

    private int findMinIndexExceptRoot(){
        int min = h[2];
        int minIndex = 2;
        for (int i = 3; i <= n; i ++)
        {
            if (h[i] < h[minIndex])
            {
                min = h[i];
                minIndex = i;
            }
        }
        return min;
    }

    @Override
    public int deleteMax() {
        return 0;
    }

    @Override
    public int min() {
        return 0;
    }

    @Override
    public int max() {
        return 0;
    }
}
