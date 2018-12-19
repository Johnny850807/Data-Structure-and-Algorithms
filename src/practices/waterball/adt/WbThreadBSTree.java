package practices.waterball.adt;

import dsa.adt.BSTree;
import dsa.adt.Data;
import jdk.nashorn.internal.scripts.JO;
import practices.waterball.adt.nodes.WbBTreeThreadNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WbThreadBSTree implements BSTree {
    private WbBTreeThreadNode root;

    @Override
    public BSTree insert(Data item) {
        root = insert(root, item);
        return this;
    }

    public WbBTreeThreadNode insert(WbBTreeThreadNode parent, Data item){
        WbBTreeThreadNode node = new WbBTreeThreadNode(item);
        if (parent == null)
            return node;
        if (item.id < parent.data.id)
        {
            parent.leftThread = false;
            if (parent.left == null)
                insertLeft(parent, node);
            else
                parent.left = insert(parent.left, item);
        }
        else if (item.id > parent.data.id)
        {
            parent.rightThread = false;
            if (parent.right == null)
                insertRight(parent, node);
            else
                parent.right = insert(parent.right, item);
        }

        throw new RuntimeException("Item's id " + item.id + " duplicated.");
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
        if (root == null)
            return Collections.emptyList();
        return null;
    }

    public WbBTreeThreadNode inorderPredecessor(WbBTreeThreadNode node){
        if (!node.rightThread)
            return node.right;
        WbBTreeThreadNode t = node.right;
        while(!t.leftThread)
            t = t.left;
        return t;
    }

    public WbBTreeThreadNode inorderSuccessor(WbBTreeThreadNode node){
        if (!node.leftThread)
            return node.left;
        WbBTreeThreadNode t = node.left;
        while(!t.rightThread)
            t = t.right;
        return t;
    }

    @Override
    public List<Data> preorderTraversal() {
        if (root == null)
            return Collections.emptyList();
        return null;
    }

    @Override
    public List<Data> inorderTraversal() {
        if (root == null)
            return Collections.emptyList();
        LinkedList<Data> list = new LinkedList<>();
        WbBTreeThreadNode predecessorEnd = inorderPredecessor(root);

        while(predecessorEnd != root)
        {
            list.addFirst(predecessorEnd.data);
            predecessorEnd = inorderPredecessor(predecessorEnd);
        }

        list.addLast(root.data);

        WbBTreeThreadNode successor = inorderSuccessor(root);
        while(successor != root)
        {
            list.addLast(successor.data);
            successor = inorderSuccessor(successor);
        }
        return list;
    }

    public void insertRight(WbBTreeThreadNode parent, WbBTreeThreadNode child){
        child.rightThread = parent.rightThread;
        child.right = parent.right;
        parent.rightThread = false;
        child.leftThread = true;
        parent.right = child;
        child.left = parent;

        if (!child.rightThread)
            inorderSuccessor(child).left = child;
    }

    public void insertLeft(WbBTreeThreadNode parent, WbBTreeThreadNode child){
        child.leftThread = parent.leftThread;
        child.left = parent.left;
        parent.leftThread = false;
        child.rightThread = true;
        parent.left = child;
        child.right = parent;

        if (!child.leftThread)
            inorderPredecessor(child).right = child;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
}
