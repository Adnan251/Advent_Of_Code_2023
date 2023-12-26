package org.example.Day18;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static List<String> theListOfInputLines;
    public List<Node> listOfNodes;
    public int borderNodes = 0;

    public Task1 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        this.listOfNodes = new ArrayList<>();
        listOfNodes.add(new Node(0, 0, "#ffffff"));
        for(String l : theListOfInputLines){
            String[] split = l.split(" ");
            Node node = listOfNodes.get(listOfNodes.size()-1);
            if(split[0].equals("R")){
                listOfNodes.add(new Node(node.getX()+Integer.parseInt(split[1]), node.getY(), split[2].substring(1, split[2].length()-1)));
                borderNodes += Integer.parseInt(split[1]);
            }
            else if(split[0].equals("L")){
                listOfNodes.add(new Node(node.getX()-Integer.parseInt(split[1]), node.getY(), split[2].substring(1, split[2].length()-1)));
                borderNodes += Integer.parseInt(split[1]);
            }
            else if(split[0].equals("U")){
                listOfNodes.add(new Node(node.getX(), node.getY()-Integer.parseInt(split[1]), split[2].substring(1, split[2].length()-1)));
                borderNodes += Integer.parseInt(split[1]);
            }
            else if(split[0].equals("D")){
                listOfNodes.add(new Node(node.getX(), node.getY()+Integer.parseInt(split[1]), split[2].substring(1, split[2].length()-1)));
                borderNodes += Integer.parseInt(split[1]);
            }
        }
    }


    public int getTheResult(){
        int result;
        int area = 0;

        for(int i = 0; i < listOfNodes.size()-1; i++){
            Node p = listOfNodes.get(i);
            Node nextP = listOfNodes.get(i+1);

            area += (p.getX() * nextP.getY()) - (nextP.getX() * p.getY());
        }
        area = Math.abs(area) / 2;

        result = (area - borderNodes/2 +1) + borderNodes;

        return result;
    }


}
