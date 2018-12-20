package dsa.adt;

import java.util.List;

public interface BSTree {
    BSTree insert(Data item);
    Data search(int id);
    Data findMin();
    List<Data> postorderTraversal();
    List<Data> preorderTraversal();
    List<Data> inorderTraversal();
    boolean isEmpty();
}
