package org.example.Day17;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.List;

public class Task2 {
    public static List<String> theListOfInputLines;

    public Task2 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
    }
}
