package practices.waterball.adt;

import dsa.adt.DisjointSet;

public class WbDisjointSet implements DisjointSet {
    private int SIZE;
    private final int NULL = SIZE+1; //unreachable number to denote NULL
    private int[] elements;

    public WbDisjointSet() {
        this(100);
    }

    public WbDisjointSet(int SIZE) {
        this.SIZE = SIZE;
        elements = new int[SIZE];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = -1;  //the root has the value (-1)*(#tree nodes)
        }
    }

    @Override   //O(n)
    public DisjointSet union(int item1, int item2) {
        int root1 = find(item1);
        int root2 = find(item2);
        int rankTotal = elements[root1] + elements[root2];
        if (root1 > root2){  //higher rank root has lower number
            elements[root1] = root2;
            elements[root2] = rankTotal;
        }
        else
        {
            elements[root2] = root1;
            elements[root1] = rankTotal;
        }
        return this;
    }

    @Override  //O(1)
    public int find(int item) {
        int root = item;
        while (elements[root] > 0)  //until find root -> element value of (1) root: negative value, (2) non-root: positive parent number
            root = elements[root]; //find ancestor until find root

        int temp;
        while (item != root){  //collapsing through the item to the root
            temp = elements[item];
            elements[item] = root;
            item = temp;
        }
        return root;
    }
}
