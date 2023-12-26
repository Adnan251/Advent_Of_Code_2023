package org.example.Day14;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static List<String> theListOfInputLines;
    List<List<Node>> listOfNodes = new ArrayList<>();

    public Task1(String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        getData();
        tiltNorth();
    }

    private void getData(){
        for(int i = 0; i < theListOfInputLines.size(); i++){
            List<Node> nodesList = new ArrayList<>();
            String[] list = theListOfInputLines.get(i).split("");
            for(int j = 0; j < list.length; j++){
                nodesList.add(new Node(list[j], theListOfInputLines.size()-i));
            }
            listOfNodes.add(nodesList);
        }
    }

    private void tiltNorth(){
        for(int i = 0; i < listOfNodes.size(); i++){
            for(int j = 0; j< listOfNodes.get(i).size(); j++){
                Node currentNode = listOfNodes.get(i).get(j);
                if(currentNode.getType().equals("O")){
                    System.out.print(currentNode.toString());
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
                    System.out.print(currentNode);
                    System.out.println();

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
