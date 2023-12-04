package org.example.Day4;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static List<String> theListOfInputLines;
    public static ArrayList<ArrayList<Integer>> winningNumbers = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> givenNumbers = new ArrayList<>();

    public Task1 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
    }

    public static void processInputLines() {
        for (String inputLine : theListOfInputLines) {
            String[] parts = inputLine.split(":");
            String[] subParts = parts[1].split("\\|");

            ArrayList<Integer> intArr1 = convertToIntegerList(subParts[0]);
            ArrayList<Integer> intArr2 = convertToIntegerList(subParts[1]);

            winningNumbers.add(intArr1);
            givenNumbers.add(intArr2);
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

    public static Integer findWinningNumbers(){
        processInputLines();
        ArrayList<Integer> resList = new ArrayList<>();

        for (int i = 0; i < winningNumbers.size(); i++) {
            int count = 0;

            for (int j = 0; j < givenNumbers.get(i).size(); j++) {
                if(winningNumbers.get(i).contains(givenNumbers.get(i).get(j))){
                  count++;
                }
            }
            resList.add((int)Math.pow(2,count-1));
        }
        Integer result = 0;
        for (Integer i:resList) {
            result += i;
        }
        return result;
    }
}
