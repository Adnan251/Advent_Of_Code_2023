package org.example.Day22;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private char axis;
    private int num;
    private List<Integer> zList = new ArrayList<>();
    private List<Integer> xList = new ArrayList<>();
    private List<Integer> yList = new ArrayList<>();

    public Block(String s){
        String[] split = s.split("~");
        String[][] arr = {split[0].split(","), split[1].split(",")};
        if(!arr[0][0].equals(arr[1][0])){
            this.axis = 'x';
            this.num = Integer.parseInt(arr[1][0]) - Integer.parseInt(arr[0][0]);
            this.zList.add(Integer.parseInt(arr[1][2]));
            for(int i = Integer.parseInt(arr[0][0]); i <= Integer.parseInt(arr[1][0]); i++){
                this.xList.add(i);
            }
            this.yList.add(Integer.parseInt(arr[1][1]));
        }
        else if(!arr[0][1].equals(arr[1][1])){
            this.axis = 'y';
            this.num = Integer.parseInt(arr[1][1]) - Integer.parseInt(arr[0][1]);
            this.zList.add(Integer.parseInt(arr[1][2]));
            for(int i = Integer.parseInt(arr[0][1]); i <= Integer.parseInt(arr[1][1]); i++){
                this.yList.add(i);
            }
            this.xList.add(Integer.parseInt(arr[1][0]));
        }
        else if(!arr[0][2].equals(arr[1][2])){
            this.axis = 'z';
            this.num = Integer.parseInt(arr[1][2]) - Integer.parseInt(arr[0][2]);
            this.xList.add(Integer.parseInt(arr[1][0]));
            for(int i = Integer.parseInt(arr[0][2]); i <= Integer.parseInt(arr[1][2]); i++){
                this.zList.add(i);
            }
            this.yList.add(Integer.parseInt(arr[1][1]));
        }
        else {
            this.axis = 'o';
            this.num = 0;
            this.xList.add(Integer.parseInt(arr[1][0]));
            this.zList.add(Integer.parseInt(arr[1][2]));
            this.yList.add(Integer.parseInt(arr[1][1]));
        }
    }

    public char getAxis() {
        return axis;
    }

    public int getNum() {
        return num;
    }

    public List<Integer> getZ() {
        return zList;
    }

    public List<Integer> getX() {
        return xList;
    }

    public List<Integer> getY() {
        return yList;
    }

    public String toString(){
        return this.axis + " => " + this.num + " => " + this.xList.toString() + this.yList.toString() + this.zList.toString() ;
    }
}
