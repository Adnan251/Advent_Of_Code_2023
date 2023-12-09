package org.example.Day8;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static List<String> theListOfInputLines;
    Map<String, Node> mapOfNode = new HashMap<>();
    List<Character> listOfSteps = new ArrayList<>();
    List<String> listOfA = new ArrayList<>();
    int count = 1;

    public Task2 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        getSteps();
        generateNodes();
    }

    private void getSteps(){
        char[] steps = theListOfInputLines.get(0).toCharArray();
        for(Character s : steps ){
            listOfSteps.add(s);
        }
    }

    private void generateNodes() {
        Pattern pattern = Pattern.compile("\\b[A-Z]{3}\\b");
        Pattern patternA = Pattern.compile(".*A$");
        for (int i = 2; i < theListOfInputLines.size(); i++) {
            String[] arr = new String[3];
            int j = 0;

            Matcher matcher = pattern.matcher(theListOfInputLines.get(i));
            while (matcher.find() && j < 3) {
                arr[j] = matcher.group();
                j++;
            }
            Matcher matcherer = patternA.matcher(arr[0]);
            if(matcherer.matches()){
                listOfA.add(arr[0]);
            }
            mapOfNode.put(arr[0], new Node(arr[0], arr[1], arr[2]));
        }
        System.out.println(listOfA);
    }


    public int findTheResult(){


        return count;
    }

    private Node thingy(Node currentNode){
        for (char c: listOfSteps) {
            currentNode = (c == 'L') ? mapOfNode.get(currentNode.getLeft()) : mapOfNode.get(currentNode.getRight());
            count++;
        }
        return currentNode;
    }
}
