package org.example.Day13;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.*;

public class Task1 {
    public static List<String> theListOfInputLines;
    List<List<String>> listOfPatterns = new ArrayList<>();
    Map<Integer, Boolean> isPassed = new HashMap<>();
    List<Integer> results = new ArrayList<>();

    public Task1(String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        getData();
    }

    public void getData(){
        List<String> newList = new ArrayList<>();
        int i = 0;
        for (String s: theListOfInputLines) {
            if(s.isEmpty()){
                listOfPatterns.add(newList);
                isPassed.put(i, false);
                i++;
                newList = new ArrayList<>();
                continue;
            }
            newList.add(s);
        }
        listOfPatterns.add(newList);
        isPassed.put(i, false);
    }

    public void checkVerticalMirroring() {
        boolean check;
        for (int i = 0; i < listOfPatterns.size(); i++) {
            check = false;
            if (isPassed.get(i)) {
                continue;
            }
            int patternWidth = listOfPatterns.get(i).get(0).length();
            for (int col1 = 0; col1 < patternWidth - 1; col1++) {
                int nonMatchingCount = 0;
                for (int row = 0; row < listOfPatterns.get(i).size(); row++) {
                    int col2 = col1 + 1 + (col1 - row) - (col1 - row);
                    if (col2 >= 0 && col2 < patternWidth && listOfPatterns.get(i).get(row).charAt(col1) != listOfPatterns.get(i).get(row).charAt(col2)) {
                        nonMatchingCount++;
                    }
                }
                if (nonMatchingCount == 0) {
                    isPassed.replace(i, true);
                    results.add(col1 + 1);
                    check = true;
                    break;
                }
            }
            if (check) {
                break;
            }
        }
    }

    public void checkHorizontalMirroring() {
        boolean check;
        for (int i = 0; i < listOfPatterns.size(); i++) {
            check = false;
            if (isPassed.get(i)) {
                continue;
            }
            for (int j = 0; j < listOfPatterns.get(i).size()-1; j++) {
                String currentChecking1 = listOfPatterns.get(i).get(j);
                String currentChecking2 = listOfPatterns.get(i).get(j+1);
                if(currentChecking1.equals(currentChecking2)){
                    int up = j+1;
                    int down = listOfPatterns.get(i).size() - j;

                    if(up > down && listOfPatterns.get(i).get(listOfPatterns.get(i).size()-1).equals(listOfPatterns.get(i).get(j-down))){
                        isPassed.replace(i, true);
                        results.add(100 * j+1);
                    }
                    else if(up < down && listOfPatterns.get(i).get(0).equals(listOfPatterns.get(i).get(j+j))){
                        isPassed.replace(i, true);
                        results.add(100 * j+1);
                    }
                    else if(up == down && listOfPatterns.get(i).get(0).equals(listOfPatterns.get(i).get(listOfPatterns.get(i).size()-1))){
                        isPassed.replace(i, true);
                        results.add(100 * j+1);
                    }
                }
            }
        }
    }


    public int getTheResult(){
        int result = 0;
        checkHorizontalMirroring();
        checkVerticalMirroring();
        System.out.println(isPassed);
        System.out.println(results);
        for(int r : results){
            result += r;
        }
        return result;
    }
}
