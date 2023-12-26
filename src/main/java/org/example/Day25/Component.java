package org.example.Day25;

import java.util.ArrayList;
import java.util.List;

public class Component {
    private String name;
    private List<Component> connections;

    public Component(String s){
        this.name = s;
        connections = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Component> getConnections() {
        return connections;
    }

    public void addConnection(Component c){
        connections.add(c);
    }
}
