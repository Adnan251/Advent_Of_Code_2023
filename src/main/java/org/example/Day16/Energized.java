package org.example.Day16;

import java.util.HashSet;
import java.util.Set;

public class Energized {
    public Set<String> directions = new HashSet<String>();

    public void add(BeamDirection direction) {
        directions.add(direction.toString());
    }

    public boolean contains(BeamDirection direction) {
        return directions.contains(direction.toString());
    }
}
