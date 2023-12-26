package org.example.Day21;

public class Node {
    private int X;
    private int Y;
    private char symbol;

    public Node(int x, int y, char symbol){
        this.X = x;
        this.Y = y;
        this.symbol = symbol;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
