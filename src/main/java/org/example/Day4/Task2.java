package org.example.Day4;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static List<String> theListOfInputLines;
    public static ArrayList<ArrayList<Integer>> winningNumbers = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> givenNumbers = new ArrayList<>();
    public static Map<Integer, Integer>mapOfTickets = new HashMap<>();

    public Task2 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
    }

    public static void processInputLines() {
        int count = 0;
        for (String inputLine : theListOfInputLines) {
            String[] parts = inputLine.split(":");
            String[] subParts = parts[1].split("\\|");

            ArrayList<Integer> intArr1 = convertToIntegerList(subParts[0]);
            ArrayList<Integer> intArr2 = convertToIntegerList(subParts[1]);

            mapOfTickets.put(count, 1);
            winningNumbers.add(intArr1);
            givenNumbers.add(intArr2);
            count++;
        }
    }

    private static ArrayList<Integer> convertToIntegerList(String numbersString) {
        String[] numberArray = numbersString.trim().split("\\s+");
        ArrayList<Integer> result = new ArrayList<>();

        for (String s : numberArray) {
            try {
                result.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }

        return result;
    }

    public static Integer findNumberOfTickets(){
        processInputLines();

        for(int i = 0; i < winningNumbers.size(); i++){
            int numOfMatchesFound = 0;

            for(int j = 0; j < givenNumbers.get(i).size(); j++){
                if(winningNumbers.get(i).contains(givenNumbers.get(i).get(j))){
                    numOfMatchesFound++;
                }
            }
            for (int k = 1; k <= numOfMatchesFound; k++) {
                mapOfTickets.put(i+k, mapOfTickets.get(i+k) + mapOfTickets.get(i));
            }
            System.out.println(mapOfTickets);
        }

        int count = 0;
        for(int l= 0; l < mapOfTickets.size(); l++){
            count += mapOfTickets.get(l);
        }

        return count;
    }
}
