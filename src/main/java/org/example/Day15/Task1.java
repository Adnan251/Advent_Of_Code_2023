package org.example.Day15;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static List<String> theListOfInputLines;

    public Task1(String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);

        String line = theListOfInputLines.get(0);
        List<String> list = Arrays.asList(line.split(","));
        theListOfInputLines = list;
        System.out.println(theListOfInputLines);
    }

    public int getTheResult(){
        int sum = 0;
        for(String check : theListOfInputLines){
            int x = 0;
            char[] chars = check.toCharArray();

            for(char c : chars){
                x += (int) c;
                x *= 17;
                x %= 256;
            }
            sum += x;
        }
        return sum;
    }
}
