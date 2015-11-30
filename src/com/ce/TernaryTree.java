package com.ce;

/**
 * Created by farhansyed on 11/23/15.
 */
public class TernaryTree {

    /**
     Implement the class (or classes) required for a ternary tree. Then implement a function that would add an element
     to this tree, keeping all invariants intact.

     The ternary tree is much like a binary tree but with 3 child nodes for each parent instead of two - with the left
     node being values < parent, the right node values > parent, and the middle node values == parent.  For example, if
     I added the following nodes to the tree in this order:  5, 4, 9, 5, 7, 2, 2 --  the tree would look like this:

           5
          /|\
         4 5 9
        /   /
       2   7
       |
       2
     */

    public static void main(String[] args) {
        TernaryTree tt = new TernaryTree();
        Node root = tt.addNode(null, 5);
        tt.addNode(root, 4);
        tt.addNode(root, 9);
        tt.addNode(root, 5);
        tt.addNode(root, 7);
        tt.addNode(root, 2);
        tt.addNode(root, 2);
        tt.addNode(root, 1);
        tt.addNode(root, 3);
        tt.addNode(root, 8);
        tt.addNode(root, 5);
        tt.addNode(root, 6);

        System.out.println(root.toString());

    }

    public Node addNode(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }

        if (node.getValue() == val) {
            node.setMiddle(addNode(node.getMiddle(), val));
        } else if (node.getValue() > val){
            node.setLeft(addNode(node.getLeft(), val));
        } else {
            node.setRight(addNode(node.getRight(), val));
        }
        return node;
    }

}
