package org.example.Day6;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.List;

public class Task2 {
    public static List<String> theListOfInputLines;

    public Task2 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
    }

    public static int howToWinTheRace(){
        long timeGiven = Long.parseLong(theListOfInputLines.get(0).replaceAll("\\D", ""));
        long distanceGiven = Long.parseLong(theListOfInputLines.get(1).replaceAll("\\D", ""));
        int result = 1;

        int speed = 0;
        long timeLeft = timeGiven;
        int counter = 0;

        for(int j = 0; j < timeGiven; j++){
            long distance = speed * timeLeft;
            if(distance > distanceGiven){
                counter++;
            }
            timeLeft --;
            speed++;

        }

        result *= counter;


        return result;
    }
}
