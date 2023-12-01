package org.example.Day1;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;

import java.util.*;

public class Task2 {

    public static List<String> ConvertToDigits() throws FileNotFoundException{
        List<String> numList = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        Map<String, String> troubleShoot = new HashMap<>();
        troubleShoot.put("oneight", "oneeight");
        troubleShoot.put("fiveight", "fiveeight");
        troubleShoot.put("nineight", "nineeight");
        troubleShoot.put("threeight", "threeeight");
        troubleShoot.put("sevenine", "sevennine");
        troubleShoot.put("eighthree", "eightthree");
        troubleShoot.put("eightwo", "eighttwo");
        troubleShoot.put("twone", "twoone");


        Map<String, Integer> numMap = new HashMap<>();
        for (int i = 0; i < numList.size(); i++) {
            numMap.put(numList.get(i), i+1);
        }

        List<String> theList = FileReader.SingleLineReader("src/main/java/org/example/Day1/InputFile.txt");
        List<String> resultList =  new ArrayList<>();

        for (String l : theList){
            String word = l;
            for(Map.Entry<String, String> entity : troubleShoot.entrySet()){
                word = word.replace(entity.getKey(), entity.getValue().toString());
            }
            for(Map.Entry<String, Integer> entity : numMap.entrySet()){
                word = word.replace(entity.getKey(), entity.getValue().toString());
            }
            resultList.add(word);
        }
        return resultList;
    }

    public static int SumFirstAndLastNumber() throws FileNotFoundException {
        List<String> theList = ConvertToDigits();
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

        for (Integer num : listOfNumbers){
            result += num;
        }

        return result;
    }

}
