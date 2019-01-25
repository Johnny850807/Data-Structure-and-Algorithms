package dsa.adt;


/**
 * Weight Rule Union / Collapsing Find
 */
public interface DisjointSet {
    /**
     * Union the set1 into set2
     */
    DisjointSet union(int set1, int set2);

    /**
     * Find which number of set the item belongs to
     * @return the set number
     */
    int find(int item);

}
