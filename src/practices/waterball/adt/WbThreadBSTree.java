package practices.waterball.adt;

import dsa.adt.BSTree;
import dsa.adt.Data;
import practices.waterball.adt.nodes.WbBTreeThreadNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WbThreadBSTree implements BSTree {
    private WbBTreeThreadNode root;

    @Override
    public BSTree insert(Data item) {
        if (root == null)
        {
            root = new WbBTreeThreadNode(item);

            // set the thread predecessor and successor of the root is itself
            // this is necessary for ensuring the leftmost and the rightmost inorder element pointing to root
            // see inorderSuccessor() and inorderPredecessor
            root.left = root.right = root;
        }
        else
            root = insert(root, item);
        return this;
    }

    public WbBTreeThreadNode insert(WbBTreeThreadNode parent, Data item){
        WbBTreeThreadNode node = new WbBTreeThreadNode(item);
        if (item.id < parent.data.id)
        {
            if (parent.leftThread)
                insertLeft(parent, node);
            else
                parent.left = insert(parent.left, item);
        }
        else if (item.id > parent.data.id)
        {
            if (parent.rightThread)
                insertRight(parent, node);
            else
                parent.right = insert(parent.right, item);
        }
        else
            throw new RuntimeException("Item's id " + item.id + " duplicated.");

        return parent;
    }


    @Override
    public Data search(int id) {
        return searchNode(root, id).data;
    }

    public WbBTreeThreadNode searchNode(WbBTreeThreadNode node, int id) {
        if (node.data.id == id)
            return node;
        if (id < node.data.id)
        {
            if (node.leftThread)
                throw new RuntimeException("Not found id: " + id);
            else
                return searchNode(node.left, id);
        }
        else
        {
            if (node.rightThread)
                throw new RuntimeException("Not found id: " + id);
            else
                return searchNode(node.right, id);
        }
    }

    @Override
    public Data findMin() {
        return findMin(root);
    }

    public Data findMin(WbBTreeThreadNode node){
        WbBTreeThreadNode previous = node;
        WbBTreeThreadNode next = node.left;
        while(next != root)
        {
            previous = next;
            next = next.left;
        }
        return previous.data;
    }

    public Data findMax(WbBTreeThreadNode node){
        WbBTreeThreadNode previous = node;
        WbBTreeThreadNode next = node.right;
        while(next != root)
        {
            previous = next;
            next = next.right;
        }
        return previous.data;
    }

    @Override
    public List<Data> postorderTraversal() {
        return postorderTraversal(root);
    }

    public List<Data> postorderTraversal(WbBTreeThreadNode node){
        if (node == null)
            return Collections.emptyList();
        ArrayList<Data> list = new ArrayList<>();
        if (!node.leftThread)
            list.addAll(postorderTraversal(node.left));
        if (!node.rightThread)
            list.addAll(postorderTraversal(node.right));
        list.add(node.data);
        return list;
    }

    @Override
    public List<Data> preorderTraversal() {
        if (root == null)
            return Collections.emptyList();
        return preorderTraversal(root);
    }

    public List<Data> preorderTraversal(WbBTreeThreadNode node) {
        if (node == null)
            return Collections.emptyList();
        ArrayList<Data> list = new ArrayList<>();
        list.add(node.data);
        if (!node.leftThread)
            list.addAll(preorderTraversal(node.left));
        if (!node.rightThread)
            list.addAll(preorderTraversal(node.right));
        return list;
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

    public WbBTreeThreadNode inorderSuccessor(WbBTreeThreadNode node){
        if (node.rightThread)
            return node.right;
        WbBTreeThreadNode t = node.right;
        while(!t.leftThread)
            t = t.left;
        return t;
    }

    public WbBTreeThreadNode inorderPredecessor(WbBTreeThreadNode node){
        if (node.leftThread)
            return node.left;
        WbBTreeThreadNode t = node.left;
        while(!t.rightThread)
            t = t.right;
        return t;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
}
