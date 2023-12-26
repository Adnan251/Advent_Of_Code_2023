package org.example.Day17;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;

public class ModifiedDijkstra {
    private int[] distances;
    private int[] previous;
    private LinkedList<Integer> visited;

    private Graph graph;
    private int source;

    public ModifiedDijkstra(Graph graph, int source) {
        this.graph = graph;
        this.source = source;

        int V = graph.V();
        this.distances = new int[V];
        this.visited = new LinkedList<>();
        this.previous = new int[V];
    }

    public int[] findShortestPath() {
        for (int i = 0; i < graph.V(); i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        distances[source] = 0;

        while (visited.size() != graph.V()) {
            int vertex = getShortestDistanceVertex();
            LinkedList<Edge> edges = graph.edges(vertex);

            for (Edge e: edges) {
                int newDistance = distances[vertex] + e.getWeight();
                if (newDistance < distances[e.getOther(vertex)]) {
                    distances[e.getOther(vertex)] = newDistance;
                    previous[e.getOther(vertex)] = vertex;
                }
            }
            visited.add(vertex);
        }

        return distances;
    }

    private int getShortestDistanceVertex() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] < min && !visited.contains(i)) {
                min = i;
            }
        }
        return min;
    }

    public LinkedList<Edge> getPath(int source, int destination) {
        LinkedList<Edge> path = new LinkedList<>();
        while (destination != source) {
            int prev = this.previous[destination];
            path.add(new Edge(prev, destination, distances[destination] - distances[prev]));
            destination = prev;
        }

        Collections.reverse(path);
        return path;
    }
}
