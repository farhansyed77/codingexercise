package com.ce;

/**
 * Created by farhansyed on 11/23/15.
 */

/**
 * Ternary Node with three children
 */
public class Node {

    public int value;

    public Node left;
    public Node middle;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node middle, Node right) {
        this.value = value;
        this.left = left;
        this.middle = middle;
        this.right = right;
    }


    /**
     * Courtesy : http://stackoverflow.com/a/27153988 
     * @return
     */
    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }

    public StringBuilder toString(StringBuilder prefix, Boolean isTail, StringBuilder sb) {
        if (right != null) {
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }

        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(value).append("\n");

        if (middle != null) {
            middle.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }

        if (left != null) {
            left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }

        return sb;
    }
}