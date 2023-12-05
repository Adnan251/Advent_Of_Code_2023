package org.example.Miscenalious;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<String> SingleLineReader (String fileName) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }

            scanner.close();
        }
        catch (FileNotFoundException e){
            throw new FileNotFoundException("Input File can not be found");
        };
        return lines;
    }

}
