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

    @Override
    public DisjointSet union(int item1, int item2) {
        int set1 = find(item1);
        int set2 = find(item2);
        return unionBySetNumber(set1, set2);
    }

    //O(1)
    private DisjointSet unionBySetNumber(int set1, int set2){
        int rankTotal = elements[set1] + elements[set2];
        if (set1 > set2){  //higher rank root has lower number
            elements[set1] = set2;
            elements[set2] = rankTotal;
        }
        else
        {
            elements[set2] = set1;
            elements[set1] = rankTotal;
        }
        return this;
    }

    @Override  //O(log n) -> bounded by weighted union
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
