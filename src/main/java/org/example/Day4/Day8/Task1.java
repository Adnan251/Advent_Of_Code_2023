package org.example.Day4.Day8;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static List<String> theListOfInputLines;
    public static List<String> instructions = new ArrayList<>();
    public Map<String, Node> mapOfNodes = new HashMap<>();

    public Task1 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        for(String c : theListOfInputLines.get(0).split("")){
            instructions.add(c);
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

    public int findTheResult(){
        fillTheMap();

        Node current = mapOfNodes.get("AAA");
        String next = "";
        int counter = 0;
        for (String s : instructions) {
            if(s.equals("R")){
                next = current.getRight();
            }
            else {
                next = current.getLeft();
            }
            current = mapOfNodes.get(next);
            System.out.println(current.getName());
            counter++;
        }
        if(current.getName().equals("ZZZ")){
            return counter;
        }

        else {
            while(!current.getName().equals("ZZZ")){
                for (String s : instructions) {
                    if(s.equals("R")){
                        next = current.getRight();
                    }
                    else {
                        next = current.getLeft();
                    }
                    current = mapOfNodes.get(next);
                    System.out.println(current.getName());
                    counter++;
                    if(current.getName().equals("ZZZ")){
                        break;
                    }
                }
            }
            return counter;
        }

    }

}
