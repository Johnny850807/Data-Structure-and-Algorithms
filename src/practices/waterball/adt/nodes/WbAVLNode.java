package practices.waterball.adt.nodes;

import dsa.adt.Data;

public class WbAVLNode {
    public WbAVLNode left;
    public WbAVLNode right;
    public int height;
    public Data data;

    public WbAVLNode(Data data) {
        this.data = data;
    }
}
