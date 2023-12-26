package org.example.Day25;

import java.util.*;

public class Graph {
    private Map<String, Component> nodes;

    public Graph(){
        this.nodes = new HashMap<>();
    }

    public void addNode(String name){
        if(!nodes.containsKey(name)){
            nodes.put(name, new Component(name));
        }
    }

    public Map<String, Component> getNodes() {
        return nodes;
    }

    public int size(){
        return nodes.size();
    }

    public void addEdge(String name1, String name2){
        Component node1 = nodes.get(name1);
        Component node2 = nodes.get(name2);
        if (node1 != null && node2 != null) {
            node1.addConnection(node2);
            node2.addConnection(node1);
        }
    }
}
