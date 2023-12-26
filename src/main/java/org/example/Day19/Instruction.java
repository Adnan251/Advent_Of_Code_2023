package org.example.Day19;

public class Instruction {
    private char name;
    private char symbol;
    private int value;
    private String ifTrue;

    public Instruction(String str){
        if(str.contains(":")){
            String[] s = str.split(":");
            this.name = s[0].substring(0, 1).charAt(0);
            this.symbol = s[0].charAt(1);
            this.value = Integer.parseInt(s[0].substring(2));
            this.ifTrue = s[1];
        }
        else{
            this.name = ' ';
            this.symbol = ' ';
            this.value = 0;
            this.ifTrue = str;
        }

    }

    public String toString(){
        return this.name+this.symbol+this.value+":"+this.ifTrue;
    }

    public String getIfTrue() {
        return ifTrue;
    }

    public boolean checkValue(Part part){
        int value = 0;
        if(this.symbol == '>'){
            value = part.getValue(this.name);
            if(value > this.value){return true;}
        } else if (this.symbol == '<') {
            value = part.getValue(this.name);
            if(value < this.value){return true;}
        }
        return false;
    }

}
