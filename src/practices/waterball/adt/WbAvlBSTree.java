package practices.waterball.adt;

import dsa.adt.BSTree;
import dsa.adt.Data;
import practices.waterball.adt.nodes.WbAVLNode;

import java.util.List;

import static java.lang.Math.max;

public class WbAvlBSTree implements BSTree{
    private WbAVLNode root;

    @Override
    public BSTree insert(Data item) {
        root = insert(root, item);
       return this;
    }

    private WbAVLNode insert(WbAVLNode node, Data item){
        if (node == null)
            return new WbAVLNode(item);

        if (item.id < node.data.id)
            node.left = insert(node.left, item);
        else if (item.id > node.data.id)
            node.right = insert(node.right, item);
        else
            throw new RuntimeException("Duplicated item value is not allowed.");

        node.height = 1 + max(height(node.left),
                height(node.right));

        int balance = getBalance(node);

        // LL
        if (balance > 1 && item.id < node.left.data.id)
            return rightRotate(node);

        // RR
        if (balance < -1 && item.id > node.right.data.id)
            return leftRotate(node);

        // LR
        if (balance > 1 && item.id > node.left.data.id) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balance < -1 && item.id < node.right.data.id) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public int height(WbAVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private WbAVLNode rightRotate(WbAVLNode y) {
        WbAVLNode x = y.left;
        WbAVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private WbAVLNode leftRotate(WbAVLNode x) {
        WbAVLNode y = x.right;
        WbAVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private int getBalance(WbAVLNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    @Override
    public Data search(int id) {
        return searchNode(root, id).data;
    }

    private WbAVLNode searchNode(WbAVLNode node, int id) {
        if (id < node.data.id)
            return searchNode(node.left, id);
        else if (id > node.data.id)
            return searchNode(node.right, id);
        else
            return node;
    }

    @Override
    public Data findMin() {
        return findMinNode().data;
    }

    private WbAVLNode findMinNode(){
        WbAVLNode node = root;
        WbAVLNode previous = null;
        while (node != null){
            previous = node;
            node = node.left;
        }
        return previous;
    }

    @Override
    public List<Data> postorderTraversal() {
        return null;
    }

    @Override
    public List<Data> preorderTraversal() {
        return null;
    }

    @Override
    public List<Data> inorderTraversal() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
}
