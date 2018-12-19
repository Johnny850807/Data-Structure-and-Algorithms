package dsa.adt;

import java.util.List;

public interface MinHeap {
    MinHeap insert(int item);

    /**
     * @return min element
     */
    int delete();
    int findMin();
    List<Data> postorderTraversal();
    List<Data> preorderTraversal();
    List<Data> inorderTraversal();
    boolean isEmpty();
}
