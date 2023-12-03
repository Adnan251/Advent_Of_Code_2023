package org.example.Day3;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static List<String> theListOfInputLines;
    public static List<Number> listOfAllNumbers = new ArrayList<>() ;
    public static List<SpecialCharacter> listOfAllSpecialCharacters = new ArrayList<>();
    public static List<String> specialChar = Arrays.asList("*","+","=","@","/","$","%","-","&","#");
    public Task2 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
    }

    public static void findAllNumbersAndCharacters(ArrayList<ArrayList<String>> matrix){
        int rowIndex = 0;

        for (ArrayList<String> row: matrix){
            for(int i = 0; i < row.size(); i++){
                if(specialChar.contains(row.get(i))){
                    SpecialCharacter sc = new SpecialCharacter(new Point(rowIndex, i), row.get(i));
                    listOfAllSpecialCharacters.add(sc);
                }
                else if(!row.get(i).equals(".")){
                    String num = "";
                    int j = 0;
                    while(i + j < row.size() && !row.get(i+j).equals(".") && !specialChar.contains(row.get(i+j))){
                        num = num + row.get(i+j);
                        j++;
                    }
                    num = num.replace(".", "");
                    int n = Integer.parseInt(num);

                    Number numberr = new Number(n, new Point(rowIndex,i), new Point(rowIndex,i+j-1));
                    listOfAllNumbers.add(numberr);
                    i += j-1;
                }

            }
            rowIndex++;
        }
    }

    public static ArrayList<ArrayList<String>> convertToMatrix(){
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for(String s: theListOfInputLines){
            ArrayList<String> al = new ArrayList<>(Arrays.asList(s.split("")));
            result.add(al);
        }
        return result;
    }

    public static int FindTheGearRatiosInMatrix() {
        int result = 0;

        ArrayList<ArrayList<String>> matrix = convertToMatrix();
        findAllNumbersAndCharacters(matrix);

        for (SpecialCharacter sc : listOfAllSpecialCharacters) {
            if (matrix.get(sc.getLocation().getRow()).get(sc.getLocation().getColl()).equals("*")) {
                int counter = 0;
                List<Integer> numbs = new ArrayList<>();

                for (Number number : listOfAllNumbers) {
                    if (!number.getAlreadyFound() && number.isAdjecant(sc.getLocation().getRow(), sc.getLocation().getColl())) {
                        number.setAlreadyFound(Boolean.TRUE);
                        counter++;
                        numbs.add(number.getNum());
                    }
                }

                if (counter == 2) {
                    result += numbs.get(0) * numbs.get(1);
                }
            }
        }

        return result;
    }
}
