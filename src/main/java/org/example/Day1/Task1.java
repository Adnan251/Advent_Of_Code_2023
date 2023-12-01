package org.example.Day1;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public static int SumFirstAndLastNumber() throws FileNotFoundException {
        List<String> theList = FileReader.SingleLineReader("src/main/java/org/example/Day1/InputFile.txt");
        System.out.println(theList);
        Integer result = 0;
        List<Integer> listOfNumbers = new ArrayList<>();

        for (String l : theList) {
            Boolean firstfound = Boolean.FALSE;
            Integer curentFirst = 0;
            Integer curentLast = 0;
            for (Character c : l.toCharArray()) {
                if(Character.isDigit(c) && !firstfound){
                    firstfound = Boolean.TRUE;
                    curentFirst = Character.getNumericValue(c);
                    curentLast = curentFirst;
                }
                else if( Character.isDigit(c)){
                    curentLast = Character.getNumericValue(c);
                }
            }
            listOfNumbers.add(10 * curentFirst + curentLast);

        }
        System.out.println(listOfNumbers);
        for (Integer num : listOfNumbers){
            result += num;
        }

        return result;
    }

}
