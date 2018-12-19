package practices.waterball.adt.nodes;

import dsa.adt.Data;

public class WbBTreeThreadNode {
    public Data data;
    public boolean leftThread = true;
    public boolean rightThread = true;
    public WbBTreeThreadNode left; //predecessor
    public WbBTreeThreadNode right;  //successor

    public WbBTreeThreadNode(Data data) {
        this.data = data;
    }
}
