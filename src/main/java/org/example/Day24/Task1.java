package org.example.Day24;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task1 {
    public static List<String> theListOfInputLines;
    public List<Ice> thePoints = new ArrayList<>();
    public long start = 200000000000000L;
    public long end = 400000000000000L;

    public Task1 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        for(String s: theListOfInputLines){
            thePoints.add(new Ice(s));
        }
    }

    public boolean checkIfInArea(double[] point){
        if (point[0] >= start && point[0] <= end &&  point[1] >= start && point[1] <= end) {
            return true;
        }
        return false;
    }

    public int getTheResult(){
        int result = 0;

        for(int i = 0; i < thePoints.size(); i++){
            long[] pointA = {thePoints.get(i).getX(), thePoints.get(i).getY()};
            int[] velocityA = {thePoints.get(i).getVelocityX(), thePoints.get(i).getVelocityY()};

            for(int j = i+1; j < thePoints.size(); j++){
                long[] pointB = {thePoints.get(j).getX(), thePoints.get(j).getY()};
                int[] velocityB = {thePoints.get(j).getVelocityX(), thePoints.get(j).getVelocityY()};

                if(velocityA[0] * velocityB[1] - velocityA[1] * velocityB[0] == 0) {
                    continue;
                }
                double t = (((double) pointA[1] - (double)pointB[1]) * (double)velocityB[0] - ((double)pointA[0] - (double)pointB[0]) * (double)velocityB[1]) / ((double)velocityA[0] * (double)velocityB[1] - (double)velocityA[1] * (double)velocityB[0]);

                if(t > 0 ) {
                    double[] intersects = {(double) pointA[0] + (double) velocityA[0] * t, (double) pointA[1] + (double) velocityA[1] * t};

                    if (checkIfInArea(intersects) ) {
                        if((intersects[0]-thePoints.get(i).getX())*thePoints.get(i).getVelocityX() >= 0 && (intersects[1] - thePoints.get(i).getY())*thePoints.get(i).getVelocityY() >= 0
                            && (intersects[0]-thePoints.get(j).getX())*thePoints.get(j).getVelocityX() >= 0 && (intersects[1] - thePoints.get(j).getY())*thePoints.get(j).getVelocityY() >= 0) {
                            System.out.println("--------------------------------------- ");
                            System.out.println(t);
                            System.out.println("(" + intersects[0] + ", " + intersects[1] + ")");
                            System.out.println(thePoints.get(i).toString());
                            System.out.println(thePoints.get(j).toString());
                            result++;
                        }
                    }
                }
            }
        }

        return result;
    }

}
