package org.example.Day16;

import java.util.ArrayList;
import java.util.List;

public class LightSource {
    int x;
    int y;
    int dx;
    int dy;

    public LightSource(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public List<LightSource> getReflected(char c) {
        List<LightSource> result = new ArrayList<LightSource>();
        if (dx == 0 && dy != 0) {
            switch (c) {
                case '-':
                    result.add(new LightSource(x,y,-1,0));
                    result.add(new LightSource(x,y,1,0));
                    break;
                case '/':
                    result.add(new LightSource(x,y,-dy,0));
                    break;
                case '\\':
                    result.add(new LightSource(x,y,dy,0));
                    break;
                case '|':
                    result.add(new LightSource(x,y,dx, dy));
                    break;
            }
        }
        else if (dx != 0 && dy == 0) {
            switch (c) {
                case '|':
                    result.add(new LightSource(x,y,0,-1));
                    result.add(new LightSource(x,y,0,1));
                    break;
                case '/':
                    result.add(new LightSource(x,y,0,-dx));
                    break;
                case '\\':
                    result.add(new LightSource(x,y,0,dx));
                    break;
                case '-':
                    result.add(new LightSource(x,y,dx, dy));
                    break;
            }
        }
        else
            throw new IllegalStateException();
        return result;
    }
}

