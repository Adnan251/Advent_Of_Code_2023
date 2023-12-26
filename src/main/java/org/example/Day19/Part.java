package org.example.Day19;

import java.util.HashMap;

public class Part {
    HashMap<Character, Integer> xMasMap;

    public Part(int x, int m, int a, int s){
        xMasMap = new HashMap<>();
        xMasMap.put('x', x);
        xMasMap.put('m', m);
        xMasMap.put('a', a);
        xMasMap.put('s', s);
    }

    public Part(String str){
        xMasMap = new HashMap<>();
        String[] s = str.substring(1, str.length()-1).split(",");
        xMasMap.put('x', Integer.parseInt(s[0].substring(2)));
        xMasMap.put('m', Integer.parseInt(s[1].substring(2)));
        xMasMap.put('a', Integer.parseInt(s[2].substring(2)));
        xMasMap.put('s', Integer.parseInt(s[3].substring(2)));
    }
    public String toString(){
        return "x="+ xMasMap.get('x') +",m="+xMasMap.get('m')+",a="+xMasMap.get('a')+",s="+xMasMap.get('s');
    }

    public int getValue(char c){
        return xMasMap.get(c);
    }

    public int getSum(){
        int sum = 0;
        for(char c:xMasMap.keySet()){
            sum += xMasMap.get(c);
        }
        return sum;
    }
}
