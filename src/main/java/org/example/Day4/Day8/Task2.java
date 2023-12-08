package org.example.Day4.Day8;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static List<String> theListOfInputLines;
    public static List<String> instructions = new ArrayList<>();
    public Map<String, Node> mapOfNodes = new HashMap<>();
    public List<String> listA = new ArrayList<>();


    public Task2 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        for(String c : theListOfInputLines.get(0).split("")){
            instructions.add(c);
        }
    }

    private void findAllA(){
        for(String m : mapOfNodes.keySet()){
            String[] split = m.split("");
            if(split[2].equals("A")){
                listA.add(m);
            }
        }
    }

    public void fillTheMap (){
        Pattern pattern = Pattern.compile("\\b[A-Z]{3}\\b");
        for (int i = 2; i < theListOfInputLines.size(); i++) {
            Matcher matcher = pattern.matcher(theListOfInputLines.get(i));
            int j = 0;
            String[] groups = new String[3];

            while (j < 3 && matcher.find()) {
                groups[j++] = matcher.group();
            }

            mapOfNodes.put(groups[0], new Node(groups[0], groups[1], groups[2]));
        }
    }

    public int findTheResult() {
        fillTheMap();
        findAllA();

        String[] curr = listA.toArray(new String[0]);
        int found = 0;
        int foundMask = 0;
        int steps = 1;

        int i = 0;
        while (found < curr.length) {
            String c = instructions.get(i % instructions.size());
            i++;
            int dir = (c.equals("L")) ? 0 : 1;

            for (int j = 0; j < curr.length; j++) {
                Node node = mapOfNodes.get(curr[j]);
                String neighbor = (dir == 0) ? node.getLeft() : node.getRight();

                if (!neighbor.equals(curr[j])) {
                    curr[j] = neighbor;
                }
            }

            for (int j = 0; j < curr.length; j++) {
                if ((foundMask & (1 << j)) == 0 && curr[j].charAt(2) == 'Z') {
                    foundMask |= 1 << j;
                    found++;
                    steps = lcm(steps, i);
                }
            }
        }

        return steps;
    }




    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

}
