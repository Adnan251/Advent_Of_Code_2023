package org.example.Day10;

import java.util.List;

public class Pipe {
    private char type;
    private int row;
    private int coll;
    private boolean isPassed;

    public Pipe(char type, int row, int coll){
        this.type = type;
        this.coll = coll;
        this.row = row;
        this.isPassed = false;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColl() {
        return coll;
    }

    public void setColl(int coll) {
        this.coll = coll;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }


    public Pipe getNext(Pipe[][] allPipes){
        Pipe next;
        Pipe option1;
        Pipe option2;
        switch (type){
            case '|':
                option1 = allPipes[this.row-1][coll];
                option2 = allPipes[this.row+1][coll];
                next = (option1.getType() == 'S' || !option1.isPassed()) ? option1 : option2;
                break;
            case '-':
                option1 = allPipes[this.row][coll-1];
                option2 = allPipes[this.row][coll+1];
                next = (option1.getType() == 'S' || !option1.isPassed()) ? option1 : option2;
                break;
            case 'L':
                option1 = allPipes[this.row-1][coll];
                option2 = allPipes[this.row][coll+1];
                next = (option1.getType() == 'S' || !option1.isPassed()) ? option1 : option2;
                break;
            case 'J':
                option1 = allPipes[this.row-1][coll];
                option2 = allPipes[this.row][coll-1];
                next = (option1.getType() == 'S' || !option1.isPassed()) ? option1 : option2;
                break;
            case '7':
                option1 = allPipes[this.row+1][coll];
                option2 = allPipes[this.row][coll-1];
                next = (option2.getType() == 'S' || !option2.isPassed()) ? option2 : option1;
                break;
            case 'F':
                option1 = allPipes[this.row+1][coll];
                option2 = allPipes[this.row][coll+1];
                next = (option1.getType() == 'S' || !option1.isPassed()) ? option1 : option2;
                break;
            case 'S':
                if((allPipes[row-1][coll].getType() == '|' || allPipes[row-1][coll].getType() == 'F' || allPipes[row-1][coll].getType() == '7') && row >= 0 && row < allPipes[0].length && coll >= 0 && coll < allPipes.length){
                    next = allPipes[row-1][coll];
                }
                else if((allPipes[row][coll-1].getType() == '-' || allPipes[row][coll-1].getType() == 'L' || allPipes[row][coll-1].getType() == 'F') && row >= 0 && row < allPipes[0].length && coll >= 0 && coll < allPipes.length){
                    next = allPipes[row][coll-1];
                }
                else if((allPipes[row][coll+1].getType() == '-' || allPipes[row][coll+1].getType() == 'J' || allPipes[row][coll+1].getType() == '7') && row >= 0 && row < allPipes[0].length && coll >= 0 && coll < allPipes.length){
                    next = allPipes[row][coll+1];
                }
                else if((allPipes[row+1][coll].getType() == '|' || allPipes[row+1][coll].getType() == 'L' || allPipes[row+1][coll].getType() == 'J') && row >= 0 && row < allPipes[0].length && coll >= 0 && coll < allPipes.length){
                    next = allPipes[row+1][coll];
                }
                else{
                    next = this;
                }
                break;
            default:
                next = this;
                break;
        }
        return next;
    }

    public String toString(){
        return this.type + " = (" + row +", "+ coll+ ")";
    }
}
