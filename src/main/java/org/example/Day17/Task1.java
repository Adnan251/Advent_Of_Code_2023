package org.example.Day17;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Task1 {
    public static List<String> theListOfInputLines;
    Graph graph;

    public Task1(String filePath) throws IOException {
        theListOfInputLines = FileReader.SingleLineReader(filePath);

        int counter = 0;
        int[][] mat = new int[theListOfInputLines.size()][theListOfInputLines.get(0).length()];
        for (int i = 0; i < theListOfInputLines.size(); i++) {
            int[] arr = new int[theListOfInputLines.get(i).length()];
            for (int j = 0; j < theListOfInputLines.get(i).length(); j++) {
                int val = (int) theListOfInputLines.get(i).charAt(j) - 48;
                arr[j] = val;
                counter++;
            }
            mat[i] = arr;
        }
        graph = new Graph(counter);

        buildGraph(mat);
    }

    private void buildGraph(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int source = i * cols + j;

                if (j < cols - 1) {
                    int destination = i * cols + (j + 1);
                    graph.addEdge(source, destination, mat[i][j + 1]);
                }

                if (i < rows - 1) {
                    int destination = (i + 1) * cols + j;
                    graph.addEdge(source, destination, mat[i + 1][j]);
                }
            }
        }
    }

    public int getTheResult(){
        int result = 0;

        ModifiedDijkstra dijkstra = new ModifiedDijkstra(graph, 0);
        int[] distances = dijkstra.findShortestPath();

        int destination = theListOfInputLines.size() * theListOfInputLines.get(0).length() - 1;
        LinkedList<Edge> path = dijkstra.getPath(0, destination);

        for(Edge e : path){
            result += e.getWeight();
        }

        return result;
    }

}
