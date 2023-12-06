package org.example.Day6;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static List<String> theListOfInputLines;

    public Task1 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
    }

    public static List<Integer> getTimeListAndDistanceList(String input){
        List<Integer> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            int num = Integer.parseInt(matcher.group());
            list.add(num);
        }

        return list;
    }

    public static int howToWinTheRace(){
        List<Integer> listOfTimes = getTimeListAndDistanceList(theListOfInputLines.get(0));
        List<Integer> listOfDistance = getTimeListAndDistanceList(theListOfInputLines.get(1));
        int result = 1;

        for(int i = 0; i < listOfTimes.size(); i++){
            int speed = 0;
            int timeLeft = listOfTimes.get(i);
            int counter = 0;

            for(int j = 0; j < listOfTimes.get(i); j++){
                int distance = speed * timeLeft;
                if(distance > listOfDistance.get(i)){
                    counter++;
                    System.out.print(speed);
                }
                timeLeft --;
                speed++;

            }
            System.out.println("");
            result *= counter;

        }
        return result;
    }

}
