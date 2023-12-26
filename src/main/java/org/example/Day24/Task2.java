package org.example.Day24;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static List<String> theListOfInputLines;
    public List<Ice> thePoints = new ArrayList<>();

    public Task2 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        for(String s: theListOfInputLines){
            thePoints.add(new Ice(s));
        }
    }
}
