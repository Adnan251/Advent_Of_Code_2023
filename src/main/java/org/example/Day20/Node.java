package org.example.Day20;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private char type;
    private String name;
    private List<String> outputNodes;
    private byte signalStrenght = 0;


    public Node(String str){
        this.outputNodes = new ArrayList<>();
        String[] s = str.split(" -> ");
        String[] list = s[1].split(", ");

        if(s[0].charAt(0) == '%'){
            this.type = '%';
            this.name = s[0].substring(1);
        }
        else if(s[0].charAt(0) == '&'){
            this.type = '&';
            this.name = s[0].substring(1);
        }
        else{
            this.type = ' ';
            this.name = s[0];
        }
        for(String l : list){
            this.outputNodes.add(l);

        }
    }

    public String toString(){
        return this.type + this.name + " -> " + outputNodes.toString();
    }
}
