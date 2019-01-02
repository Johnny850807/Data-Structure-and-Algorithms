package practices.waterball.adt;

import dsa.adt.DisjointSet;

public class WbArrayDisjointSet implements DisjointSet {
    private int SIZE;
    private final static int NULL = -1;
    private int[] elements;

    public WbArrayDisjointSet() {
        this(100);
    }

    public WbArrayDisjointSet(int SIZE) {
        this.SIZE = SIZE;
        elements = new int[SIZE];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = NULL;
        }
    }

    @Override   //O(n)
    public DisjointSet union(int set1, int set2) {
        for (int i = 0; i < SIZE; i ++)
            if (elements[i] == set1)
                elements[i] = set2;
        return this;
    }

    @Override  //O(1)
    public int find(int item) {
        return elements[item];
    }

    @Override  //O(1)
    public DisjointSet put(int item, int set) {
        elements[item] = set;
        return this;
    }
}
