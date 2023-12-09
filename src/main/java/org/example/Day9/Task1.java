package org.example.Day9;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static List<String> theListOfInputLines;
    public static List<List<Integer>> listOfReadings = new ArrayList<>();

    public Task1 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        getTheReadings();
    }

    private void getTheReadings(){
        for (String e: theListOfInputLines) {
            List<Integer> l = new ArrayList<>();
            String[] s = e.split(" ");
            for (String st: s ) {
                l.add(Integer.parseInt(st));
            }
            listOfReadings.add(l);
        }
    }

    public Integer getTheResult(){
        Integer result = 0;
        List<Integer> resList = new ArrayList<>();

        for (List<Integer> li : listOfReadings){
            List<List<Integer>> innerLists = new ArrayList<>();
            innerLists.add(li);
            int num = 0;
            while(true){
                List<Integer> diferances = new ArrayList<>();

                for(int i = 0; i < innerLists.get(num).size()-1; i++){
                    diferances.add(innerLists.get(num).get(i+1)-innerLists.get(num).get(i));
                }

                if(allNumbersZero(diferances)){
                    List<Integer> zeroList = new ArrayList<>();
                    for(int i = 0; i <= diferances.size(); i++){
                        zeroList.add(0);
                    }
                    zeroList.add(0);
                    innerLists.add(zeroList);
                    break;
                }
                innerLists.add(diferances);
                num++;
            }

            for(int j = innerLists.size()-1; j > 0; j--){
                int n = innerLists.get(j).get(innerLists.get(j-1).size()-1) + innerLists.get(j-1).get(innerLists.get(j-1).size()-1);
                innerLists.get(j-1).add(n);
            }

            result += innerLists.get(0).get(innerLists.get(0).size()-1);
        }
        return result;
    }

    public boolean allNumbersZero(List<Integer> list) {
        List<Integer> li = new ArrayList<>();
        for (Integer l : list) {
            if (l != 0) {
                return false;
            }
            li.add(0);
        }
        return true;
    }

}
