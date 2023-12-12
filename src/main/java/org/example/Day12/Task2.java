package org.example.Day12;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static List<String> theListOfInputLines;
    long result = 0;

    public Task2(String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
    }

    public long getTheResult() {
        for (String line : theListOfInputLines) {
            String[] parts = line.split(" ");
            String map = parts[0];
            for( int i = 0; i < 4; i++){
                map += "?" + parts[0];
            }
            String a = parts[1];
            for( int i = 0; i < 4; i++){
                a += "," + parts[1];
            }
            String[] amountsStr = a.split(",");
            int[] amounts = new int[amountsStr.length];
            for (int i = 0; i < amountsStr.length; i++) {
                amounts[i] = Integer.parseInt(amountsStr[i]);
            }
            result += countArrangements(map, amounts);
        }
        return result;
    }


    private long countArrangements(String map, int[] amounts) {
        return countArrangements(map, amounts, new HashMap<>(), 0, 0, 0);
    }

    private long countArrangements(String map, int[] amounts, Map<String, Long> blockMap, int i, int j, int cur) {
        String key = i + "," + j + "," + cur;
        if (blockMap.containsKey(key)) {
            return blockMap.get(key);
        }

        if (i == map.length()) {
            return (j == amounts.length && cur == 0) || (j == amounts.length - 1 && amounts[j] == cur) ? 1 : 0;
        }

        long total = 0;
        char c = map.charAt(i);

        if ((c == '.' || c == '?') && cur == 0) {
            total += countArrangements(map, amounts, blockMap, i + 1, j, 0);
        } else if ((c == '.' || c == '?') && cur > 0 && j < amounts.length && amounts[j] == cur) {
            total += countArrangements(map, amounts, blockMap, i + 1, j + 1, 0);
        }

        if (c == '#' || c == '?') {
            total += countArrangements(map, amounts, blockMap, i + 1, j, cur + 1);
        }

        blockMap.put(key, total);
        return total;
    }

}
