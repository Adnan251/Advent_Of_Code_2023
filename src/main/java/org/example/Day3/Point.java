package org.example.Day3;

public class Point {
    private int row;
    private int coll;

    public Point(int row, int coll) {
        this.row = row;
        this.coll = coll;
    }

    public int getRow() {
        return row;
    }

    public int getColl() {
        return coll;
    }

    public String toString(){
        return "("+this.getRow() + " " +this.getColl()+")";
    }
}
