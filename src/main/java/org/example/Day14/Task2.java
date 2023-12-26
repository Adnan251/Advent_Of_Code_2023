package org.example.Day14;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static List<String> theListOfInputLines;
    List<List<Node>> listOfNodes = new ArrayList<>();

    public Task2(String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        getData();
        int i = 0;
        while(i<1000000000){
            tiltNorth();
            tiltWest();
            tiltSouth();
            tiltEast();
            i++;
        }
    }

    private void getData(){
        for(int i = 0; i < theListOfInputLines.size(); i++){
            List<Node> nodesList = new ArrayList<>();
            String[] list = theListOfInputLines.get(i).split("");
            for(int j = 0; j < list.length; j++){
                nodesList.add(new Node( list[j], theListOfInputLines.size()-i));
            }
            listOfNodes.add(nodesList);
        }
    }

    private void tiltNorth(){
        for(int i = 0; i < listOfNodes.size(); i++){
            for(int j = 0; j< listOfNodes.get(i).size(); j++){
                Node currentNode = listOfNodes.get(i).get(j);
                if(currentNode.getType().equals("O")){
                    int counter = 0;
                    while(counter < i){
                        counter++;
                        if(listOfNodes.get(i-counter).get(j).getType().equals(".")){
                            listOfNodes.get(i-counter).get(j).setType("O");
                            currentNode.setType(".");
                            currentNode = listOfNodes.get(i-counter).get(j);
                        }
                        else{
                            break;
                        }
                    }
                }
            }
        }
    }

    private void tiltWest(){
        for(int i = 0; i < listOfNodes.size(); i++){
            for(int j = 0; j< listOfNodes.get(i).size(); j++){
                Node currentNode = listOfNodes.get(i).get(j);
                if(currentNode.getType().equals("O")){
                    int counter = 0;
                    while(counter < j) {
                        counter++;
                        if (listOfNodes.get(i).get(j - counter).getType().equals(".")) {
                            listOfNodes.get(i).get(j - counter).setType("O");
                            currentNode.setType(".");
                            currentNode = listOfNodes.get(i).get(j - counter);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    private void tiltSouth() {
        for (int i = listOfNodes.size() - 2; i >= 0; i--) {
            for (int j = 0; j < listOfNodes.get(i).size(); j++) {
                Node currentNode = listOfNodes.get(i).get(j);
                if (currentNode.getType().equals("O")) {
                    int counter = 0;
                    while (i + counter < listOfNodes.size() - 1) {
                        counter++;
                        if (listOfNodes.get(i + counter).get(j).getType().equals(".")) {
                            listOfNodes.get(i + counter).get(j).setType("O");
                            currentNode.setType(".");
                            currentNode = listOfNodes.get(i + counter).get(j);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }


    private void tiltEast() {
        for (int i = 0; i < listOfNodes.size(); i++) {
            for (int j = listOfNodes.get(i).size() - 1; j >= 0; j--) {
                Node currentNode = listOfNodes.get(i).get(j);
                if (currentNode.getType().equals("O")) {
                    int counter = 0;
                    while (j + counter < listOfNodes.get(i).size() - 1) {
                        counter++;
                        if (listOfNodes.get(i).get(j + counter).getType().equals(".")) {
                            listOfNodes.get(i).get(j + counter).setType("O");
                            currentNode.setType(".");
                            currentNode = listOfNodes.get(i).get(j + counter);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public int getTheResult(){
        int sum = 0;
        for(List<Node> list: listOfNodes){
            for(Node n : list){
                if(n.getType().equals("O")){
                    sum += n.getWeight();
                }
            }
        }
        return sum;
    }
}
