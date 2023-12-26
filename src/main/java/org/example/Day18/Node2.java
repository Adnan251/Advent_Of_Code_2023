package org.example.Day18;

import java.math.BigInteger;

public class Node2 {
    private BigInteger x;
    private BigInteger y;
    private String color;

    public Node2(BigInteger x, BigInteger y, String color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public BigInteger getX() {
        return x;
    }

    public BigInteger getY() {
        return y;
    }

    public String toString(){
        return "(" + this.x + ", " + this.y + ") = " + this.color;
    }

}
