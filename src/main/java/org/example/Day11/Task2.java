package org.example.Day11;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.*;

public class Task2 {
    public List<String> theListOfInputLines;
    public List<List<String>> mainMatrix = new ArrayList<>();
    public Map<Integer, Integer> mapColumns = new HashMap<>();
    public int multiplier;

    public Task2 (String filePath,int multiplier) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        this.multiplier = multiplier;
        generateMatrix();
    }

    private void generateMatrix(){
        for(int i = 0; i < theListOfInputLines.size(); i++){
            List<String> list = Arrays.asList(theListOfInputLines.get(i).split(""));
            mainMatrix.add(list);

            if(!list.contains("#")){
                int c = 1;
                while (c < multiplier){
                    mainMatrix.add(list);
                    c++;
                }
            }

            for(int j = 0; j < list.size(); j++){
                if(list.get(j).equals(".") && list.contains("#")){
                    if(mapColumns.containsKey(j)){
                        mapColumns.replace(j, mapColumns.get(j)+1);
                    }
                    else{
                        mapColumns.put(j,1);
                    }
                } else if (list.get(j).equals(".") && !list.contains("#")) {
                    if(mapColumns.containsKey(j)){
                        mapColumns.replace(j, mapColumns.get(j)+multiplier);
                    }
                    else{
                        mapColumns.put(j,multiplier);
                    }
                }
            }
        }
        List<List<String>> newMatrix = new ArrayList<>();

        for(int i = 0; i < mainMatrix.size(); i++){
            List<String> newList = new ArrayList<>(mainMatrix.get(i));
            int x = 0;
            for (Map.Entry<Integer, Integer> entry : mapColumns.entrySet()) {
                int columnIndex = entry.getKey();
                int count = entry.getValue();

                if (count == mainMatrix.size()) {
                    int c = 1;
                    while(c < multiplier) {
                        newList.add(columnIndex + x, ".");
                        x++;
                        c++;
                    }
                }
            }

            newMatrix.add(newList);
        }
        mainMatrix = newMatrix;
        System.out.println(mainMatrix);
    }

    public int getTheResult(){
        List<Node> resultList = new ArrayList<>();
        int counter = 0;
        int sum = 0;
        for(int i = 0; i < mainMatrix.size(); i++){
            for (int j = 0; j < mainMatrix.get(i).size(); j++){
                if(mainMatrix.get(i).get(j).equals("#")){
                    resultList.add(new Node(counter+1, i, j));
                    counter++;
                }
            }
        }
        counter = 0;
        for(Node r : resultList){
            for(int i = counter+1; i < resultList.size(); i++){
                sum += r.getDistance(resultList.get(i));
            }
            counter++;
        }

        return sum;
    }
}
