package org.example.Day25;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static List<String> theListOfInputLines;
    public Graph graph = new Graph();

    public Task1 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);

        for(String s : theListOfInputLines){
            s = s.replaceAll(":", "");
            String[] split = s.split(" ");
            for(int i = 0; i < split.length; i++){
                if(i == 0){
                    graph.addNode(split[i]);
                }
                graph.addNode(split[i]);
            }
            for(int i = 1; i < split.length; i++){
                graph.addEdge(split[0], split[i]);
            }
        }

        for (Component node : graph.getNodes().values()) {
            System.out.print(node.getName() + " => ");
            for (Component neighbor : node.getConnections()) {
                System.out.print(neighbor.getName() + " ");
            }
            System.out.println();
        }
    }
}
