package org.example.Day4.Day8;

public class Node {
    private String name;
    private String left;
    private String right;

    public Node (String name, String left, String right){
        this.left = left;
        this.name = name;
        this.right = right;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }
}
