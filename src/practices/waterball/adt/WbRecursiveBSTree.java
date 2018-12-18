package practices.waterball.adt;

import dsa.adt.BSTree;
import dsa.adt.Data;
import dsa.adt.LinkedList;
import practices.waterball.algorithms.WbBSTreeNode;
import practices.waterball.algorithms.WbRecursiveBinaryTreeTraversaller;

import java.util.List;

public class WbRecursiveBSTree implements BSTree {
    private WbBSTreeNode root;

    @Override
    public BSTree insert(Data item) {
        return null;
    }

    @Override
    public BSTree delete(int id) {
        return null;
    }

    @Override
    public Data search(int id) {
        return null;
    }

    @Override
    public Data findMin() {
        return null;
    }

    @Override
    public List<Data> postorderTraversal() {
        return new WbRecursiveBinaryTreeTraversaller().postorderTraversal(root);
    }

    @Override
    public List<Data> preorderTraversal() {
        return new WbRecursiveBinaryTreeTraversaller().preorderTraversal(root);
    }

    @Override
    public List<Data> inorderTraversal() {
        return new WbRecursiveBinaryTreeTraversaller().inorderTraversal(root);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
}
