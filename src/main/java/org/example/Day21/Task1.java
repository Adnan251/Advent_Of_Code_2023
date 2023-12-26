package org.example.Day21;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static List<String> theListOfInputLines;
    public List<List<Node>> matrix = new ArrayList<>();
    public List<List<Node>> tempMatrix;

    public Task1 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        for(int i = 0; i < theListOfInputLines.size(); i++){
            char[] chars = theListOfInputLines.get(i).toCharArray();
            List<Node> list = new ArrayList<>();
            for(int j = 0; j < chars.length; j++){
                list.add(new Node(i, j, chars[j]));
            }
            matrix.add(list);
        }
        this.tempMatrix = deepCopy(matrix);
    }

    private List<List<Node>> deepCopy(List<List<Node>> original) {
        List<List<Node>> copy = new ArrayList<>();
        for (List<Node> row : original) {
            List<Node> rowCopy = new ArrayList<>();
            for (Node node : row) {
                rowCopy.add(new Node(node.getX(), node.getY(), node.getSymbol()));
            }
            copy.add(rowCopy);
        }
        return copy;
    }

    private void makeAStep(){
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.get(i).size(); j++){
                if(matrix.get(i).get(j).getSymbol() == 'S'){
                    updateThingy(matrix.get(i).get(j));
                }
            }
        }
    }

    private void updateThingy(Node node){
        int[] rowD = {1, 0, -1, 0};
        int[] colD = {0, 1, 0, -1};

        for(int i = 0; i < 4; i++){
            if(node.getX()+rowD[i] < 0 || node.getX()+rowD[i] >= tempMatrix.size() || node.getY()+colD[i] < 0 || node.getY()+colD[i] >= tempMatrix.get(0).size() ){
                continue;
            }

            if(tempMatrix.get(node.getX()+rowD[i]).get(node.getY()+colD[i]).getSymbol() == '.'){
                tempMatrix.get(node.getX()+rowD[i]).get(node.getY()+colD[i]).setSymbol('S');
            }
        }
        tempMatrix.get(node.getX()).get(node.getY()).setSymbol('.');
    }

    public int getTheResult(){
        int count = 0;
        for(int i = 0; i < 64; i++){
            makeAStep();
            matrix = deepCopy(tempMatrix);
        }

        for(int i = 0; i < matrix.size(); i++){
            System.out.println();
            for(int j = 0; j < matrix.get(i).size(); j++){
                System.out.print(matrix.get(i).get(j).getSymbol());
                if(matrix.get(i).get(j).getSymbol() == 'S'){
                    count++;
                }
            }
        }

        return count;
    }

}
