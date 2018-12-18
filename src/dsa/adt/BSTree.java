package dsa.adt;

import java.util.List;

public interface BSTree {
    BSTree insert(Data item);
    BSTree delete(int id);
    Data search(int id);
    Data findMin();
    List<Data>  postorderTrversal();
    List<Data>  preorderTrversal();
    List<Data>  inorderTrversal();
    boolean isEmpty();
}
