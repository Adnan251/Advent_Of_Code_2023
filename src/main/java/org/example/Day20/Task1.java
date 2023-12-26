package org.example.Day20;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static List<String> theListOfInputLines;
    public List<Node> listOfNodes;

    public Task1 (String filePath) throws FileNotFoundException {
        this.listOfNodes = new ArrayList<>();
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        for(String s : theListOfInputLines){
            listOfNodes.add(new Node(s));
        }
        for(Node n : listOfNodes){
            System.out.println(n.toString());
        }
    }
}
