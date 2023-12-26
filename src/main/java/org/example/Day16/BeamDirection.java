package org.example.Day16;

public class BeamDirection {
    int dx;
    int dy;

    public BeamDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public String toString(){
        return "(" + dx + ", " + dy + ")";
    }

}
