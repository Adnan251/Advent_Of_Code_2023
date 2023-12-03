package org.example.Day3;

public class Number {
    private Integer num;
    private Point startPoint;
    private Point endPoint;
    private Boolean alreadyFound = Boolean.FALSE;

    public Number(Integer num, Point startPoint, Point endPoint) {
        this.num = num;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Integer getNum() {
        return num;
    }

    public Boolean getAlreadyFound() {
        return alreadyFound;
    }

    public void setAlreadyFound(Boolean alreadyFound) {
        this.alreadyFound = alreadyFound;
    }

    public boolean isAdjecant(int row, int coll) {
        if (startPoint.getRow() == row - 1 || startPoint.getRow() == row + 1) {
            if (startPoint.getColl() == coll - 2 || startPoint.getColl() == coll - 1 || startPoint.getColl() == coll || startPoint.getColl() == coll + 1) {
                return true;
            } else if (endPoint.getColl() == coll - 1 || endPoint.getColl() == coll + 1) {
                return true;
            }
        } else if (startPoint.getRow() == row) {
            if (endPoint.getColl() == coll - 1 || startPoint.getColl() == coll + 1) {
                return true;
            }
        } else if (endPoint.getRow() == row - 1 || endPoint.getRow() == row + 1) {
            if (endPoint.getColl() == coll - 1 || endPoint.getColl() == coll + 1) {
                return true;
            }
        }

        return false;
    }


    public String toString(){
        return "Number: " + this.num + " " + startPoint.toString() + " " + endPoint.toString();
    }
}
