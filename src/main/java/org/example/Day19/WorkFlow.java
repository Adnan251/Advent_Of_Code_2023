package org.example.Day19;

import java.util.ArrayList;
import java.util.List;

public class WorkFlow {
    private List<Instruction> instructions = new ArrayList<>();

    public WorkFlow(String str){
        String[] options = str.split(",");
        for(String s: options){
           instructions.add(new Instruction(s));
        }
    }

    public String toString(){
        String result = "";
        for(Instruction i : instructions){
            result += i.toString()+" ";
        }
        return result;
    }

    public String checkGoodOrNot(Part part){
        for(Instruction i : instructions){
            if(i.checkValue(part)){
                return i.getIfTrue();
            }
        }
        return instructions.get(instructions.size()-1).getIfTrue();
    }

}
