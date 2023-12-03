package org.example.Day3;

public class SpecialCharacter {
    private Point location;
    private String chara;

    public SpecialCharacter(Point location, String ch) {
        this.location = location;
        this.chara = ch;
    }

    public String getChara() {
        return chara;
    }
    public Point getLocation() {
        return location;
    }

    public String toString(){
        return "Character " + location.toString();
    }
}
