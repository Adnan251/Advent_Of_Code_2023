package org.example.Day16;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task1 {
    public static List<String> theListOfInputLines;
    public int width;
    public int height;

    public Task1(String filePath) throws FileNotFoundException, FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
    }

    private int countEnergized(LightSource source, char[][] map) {
        int result = 0;
        Energized[][] energizedMap = new Energized[width][height];
        for (int x=0;x<width;x++) {
            for (int y=0;y<height;y++) {
                energizedMap[x][y] = new Energized();
            }
        }
        processLight(source, map, energizedMap);
        for (int x=0;x<width;x++) {
            for (int y=0;y<height;y++) {
                if (!energizedMap[x][y].directions.isEmpty()) {
                    result++;
                }
            }
        }
        return result;
    }

    private void processLight(LightSource source, char[][] map, Energized[][] energizedMap) {

        Stack<LightSource> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            source = stack.pop();
            int x = source.x+source.dx;
            int y = source.y+source.dy;
            source.x = x;
            source.y = y;
            if (x >= width || x < 0 || y >= height || y < 0) continue;
            BeamDirection direction = new BeamDirection(source.dx, source.dy);
            if (!energizedMap[x][y].contains(direction)) {
                energizedMap[x][y].add(direction);
                char c = map[x][y];
                if (c == '.') {
                    LightSource newSource = new LightSource(x, y, source.dx, source.dy);
                    stack.push(newSource);
                }
                else {
                    List<LightSource> newSources = source.getReflected(c);
                    for (LightSource lightSource : newSources) {
                        stack.push(lightSource);
                    }
                }
            }
        }

    }

    private char[][] createMap(List<String> lines) {
        char[][] map = new char[width][height];
        for (int y=0;y<lines.size();y++) {
            String line = lines.get(y);
            for (int x=0;x<line.length();x++) {
                map[x][y] = line.charAt(x);
            }
        }
        return map;
    }

    public int getTheResult() {
        width = theListOfInputLines.get(0).length();
        height = theListOfInputLines.size();

        char[][] map = createMap(theListOfInputLines);
        LightSource source = new LightSource(-1, 0, 1, 0);
        int result = countEnergized(source, map);

        return result;
    }
}
