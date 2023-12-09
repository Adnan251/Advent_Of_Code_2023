package org.example.Day8;

public class Node {
    private String name;
    private String left;
    private String right;

    public Node(String name, String left, String right){
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String toString(){
        return this.name + " = " + "(" + this.left + ", " + this.right + ")";
    }
}
