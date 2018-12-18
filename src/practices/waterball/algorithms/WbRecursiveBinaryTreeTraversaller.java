package practices.waterball.algorithms;

import dsa.adt.BSTree;
import dsa.adt.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WbRecursiveBinaryTreeTraversaller {

    public List<Data> inorderTraversal(WbBSTreeNode node) {
        if (node == null)
            return Collections.emptyList();
        List<Data> output = new ArrayList<>();
        output.addAll(inorderTraversal(node.left));
        output.add(node.data);
        output.addAll(inorderTraversal(node.right));
        return output;
    }

    public List<Data> postorderTraversal(WbBSTreeNode node) {
        if (node == null)
            return Collections.emptyList();
        List<Data> output = new ArrayList<>();
        output.addAll(inorderTraversal(node.left));
        output.addAll(inorderTraversal(node.right));
        output.add(node.data);
        return output;
    }


    public List<Data> preorderTraversal(WbBSTreeNode node) {
        if (node == null)
            return Collections.emptyList();
        List<Data> output = new ArrayList<>();
        output.add(node.data);
        output.addAll(inorderTraversal(node.left));
        output.addAll(inorderTraversal(node.right));
        return output;
    }
}
