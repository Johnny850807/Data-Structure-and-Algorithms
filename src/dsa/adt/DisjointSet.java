package dsa.adt;


/**
 * Weight Rule Union / Collapsing Find
 */
public interface DisjointSet {
    /**
     * Union the set1 into set2
     */
    DisjointSet union(int item1, int item2);

    /**
     * Find which number of set the item belongs to
     * @return the set number
     */
    int find(int item);

}
