package org.example.Day15;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.*;

public class Task2 {
    public static List<String> theListOfInputLines;
    public List<HashMap<String, Integer>> listOfBoxes = new ArrayList<>();


    public Task2(String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);

        String line = theListOfInputLines.get(0);
        List<String> list = Arrays.asList(line.split(","));
        theListOfInputLines = list;
        System.out.println(theListOfInputLines);
        int i = 0;
        while(i < 256){
            listOfBoxes.add(new LinkedHashMap<>());
            i++;
        }
    }

    private int hashCalculator(String stringy){
        int x = 0;
        char[] chars = stringy.toCharArray();

        for(char c : chars){
            x += (int) c;
            x *= 17;
            x %= 256;
        }
        return x;
    }

    public int getTheResult(){
        int sum = 0;
        for(String s: theListOfInputLines){
            if(s.contains("=")){
                String[] arrayOfParts = s.split("=");
                int index = hashCalculator(arrayOfParts[0]);
                if(listOfBoxes.get(index).containsKey(arrayOfParts[0])){
                    listOfBoxes.get(index).replace(arrayOfParts[0],Integer.parseInt(arrayOfParts[1]));
                }
                else{
                    listOfBoxes.get(index).put(arrayOfParts[0],Integer.parseInt(arrayOfParts[1]));
                }
            }
            else if(s.contains("-")){
                String[] arrayOfParts = s.split("-");
                int index = hashCalculator(arrayOfParts[0]);
                if(listOfBoxes.get(index).containsKey(arrayOfParts[0])){
                    listOfBoxes.get(index).remove(arrayOfParts[0]);
                }
            }
        }
        int i = 1;
        System.out.println(listOfBoxes);
        for(HashMap<String,Integer> map : listOfBoxes){
            if(!map.isEmpty()){
                int j = 1;
                for(String key:map.keySet()){
                    sum += i * j * map.get(key);
                    j++;
                }
            }
            i++;
        }

        return sum;
    }

}
