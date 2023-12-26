package org.example.Day18;

public class Node {
    private int x;
    private int y;
    private String color;

    public Node(int x, int y, String color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString(){
        return "(" + this.x + ", " + this.y + ") = " + this.color;
    }

}
