package org.example.Day17;

import java.util.LinkedList;

public class Graph {

    int vertices;
    LinkedList<Edge>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<Edge>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList[source].add(edge);
    }

    public int V() {
        return this.vertices;
    }

    public LinkedList<Edge> edges(int vertex) {
        return adjacencyList[vertex];
    }

    public void printGraph() {
        for (int i = 0; i <vertices ; i++) {
            LinkedList<Edge> list = adjacencyList[i];
            for (Edge edge : list) {
                System.out.println("vertex-" + i + " is connected to " +
                        edge.getOther(i) + " with weight " + edge.getWeight());
            }
        }
    }
}
