package org.example.Day8;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.List;

public class Task1 {
    public static List<String> theListOfInputLines;

    public Task1 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
    }
}
