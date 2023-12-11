package org.example.Day11;

public class Node {
    private int name;
    private int[] coordinates;

    public Node(int c, int row, int col){
        this.name = c;
        this.coordinates = new int[]{row, col};
    }

    public int getName() {
        return name;
    }

    public void setName(int character) {
        this.name = character;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public int getDistance(Node node){
        int[] a = node.getCoordinates();
        int rowDis = this.coordinates[0] - a[0];
        int colDis = this.coordinates[1] - a[1];

        return Math.abs(rowDis)+Math.abs(colDis);
    }
}
