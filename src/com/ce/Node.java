package com.ce;

/**
 * Created by farhansyed on 11/23/15.
 */

/**
 * Ternary Node with three children
 */
public class Node {

    private int value;

    private Node left;
    private Node middle;
    private Node right;

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
        if (this.right != null) {
            this.right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }

        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(this.value).append("\n");

        if (this.middle != null) {
            this.middle.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }

        if (this.left != null) {
            this.left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }

        return sb;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getMiddle() {
        return this.middle;
    }

    public void setMiddle(Node middle) {
        this.middle = middle;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}