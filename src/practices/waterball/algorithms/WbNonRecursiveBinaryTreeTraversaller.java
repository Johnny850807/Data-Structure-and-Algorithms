package practices.waterball.algorithms;

import dsa.adt.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//TODO
public class WbNonRecursiveBinaryTreeTraversaller {
    public List<Data> inorderTraversal(WbBSTreeNode node) {
        if (node == null)
            return Collections.emptyList();
        List<Data> output = new ArrayList<>();
        Stack<WbBSTreeNode> stack = new Stack<>();
        stack.push(node);

        return output;
    }

    public List<Data> postorderTraversal(WbBSTreeNode node) {
        if (node == null)
            return Collections.emptyList();
        List<Data> output = new ArrayList<>();
        return output;
    }


    public List<Data> preorderTraversal(WbBSTreeNode node) {
        if (node == null)
            return Collections.emptyList();
        List<Data> output = new ArrayList<>();
        return output;
    }
}
