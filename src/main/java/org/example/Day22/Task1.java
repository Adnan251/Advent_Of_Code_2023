package org.example.Day22;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task1 {
    public static List<String> theListOfInputLines;
    public static HashMap<Integer, Block> mapy = new HashMap<>();
    List<List<Block>> stack = new ArrayList<>();

    public Task1 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        for(String s : theListOfInputLines){
            Block b = new Block(s);
            int n = b.getZ().get(0);
            mapy.put(n, b);
        }
        System.out.println(mapy);
    }

}
