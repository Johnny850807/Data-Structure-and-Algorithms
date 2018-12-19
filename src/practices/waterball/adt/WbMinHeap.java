package practices.waterball.adt;

import dsa.adt.Data;
import dsa.adt.MinHeap;

import java.util.List;

public class WbMinHeap implements MinHeap{
    private int FULL_SIZE = 100;
    private int[] elements = new int[FULL_SIZE]; //index starts from 1
    private int count = 0;

    @Override
    public MinHeap insert(int item) {
        elements[++count] = item;
        adjustBottomUp();
        return null;
    }

    @Override
    public int delete() {
        int min = elements[1];
        adjustBottomUp();
        return min;
    }

    private void adjustBottomUp(){

    }

    private void adjustTopDown(){

    }

    @Override
    public int findMin() {
        return elements[1];
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
        return false;
    }
}
