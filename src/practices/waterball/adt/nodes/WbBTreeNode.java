package practices.waterball.adt.nodes;

import dsa.adt.Data;

public class WbBTreeNode {
    public Data data;
    public WbBTreeNode left; //predecessor
    public WbBTreeNode right;  //successor
}
