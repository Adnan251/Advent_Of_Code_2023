package org.example.Day18;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static List<String> theListOfInputLines;
    public List<Node2> listOfNodes;
    public BigInteger borderNodes = BigInteger.ZERO;

    public Task2 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        this.listOfNodes = new ArrayList<>();
        listOfNodes.add(new Node2(BigInteger.ZERO, BigInteger.ZERO, "#ffffff"));
        for(String l : theListOfInputLines){
            String[] split = l.split(" ");
            BigInteger meters = new BigInteger(split[2].substring(2, split[2].length()-2), 16);
            System.out.println(meters);
            String dirrction = split[2].substring(split[2].length()-2, split[2].length()-1);
            System.out.println(dirrction);
            Node2 node = listOfNodes.get(listOfNodes.size()-1);
            if(dirrction.equals("0")){
                listOfNodes.add(new Node2(node.getX().add(meters), node.getY(), split[2].substring(1, split[2].length() - 1)));
                borderNodes = borderNodes.add(meters);
            }
            else if(dirrction.equals("2")){
                listOfNodes.add(new Node2(node.getX().subtract(meters), node.getY(), split[2].substring(1, split[2].length() - 1)));
                borderNodes = borderNodes.add(meters);
            }
            else if(dirrction.equals("3")){
                listOfNodes.add(new Node2(node.getX(), node.getY().subtract(meters), split[2].substring(1, split[2].length()-1)));
                borderNodes = borderNodes.add(meters);
            }
            else if(dirrction.equals("1")){
                listOfNodes.add(new Node2(node.getX(), node.getY().add(meters), split[2].substring(1, split[2].length()-1)));
                borderNodes = borderNodes.add(meters);
            }
        }
        for(Node2 n: listOfNodes){
            System.out.println(n.toString());
        }
    }


    public BigInteger getTheResult(){
        BigInteger result;
        BigInteger area = BigInteger.ZERO;

        for(int i = 0; i < listOfNodes.size()-1; i++){
            Node2 p = listOfNodes.get(i);
            Node2 nextP = listOfNodes.get(i+1);

            area = area.add((p.getX().multiply(nextP.getY())).subtract(nextP.getX().multiply(p.getY())));
        }
        area = area.abs().divide(BigInteger.TWO);

        result = (area.subtract(borderNodes.divide(BigInteger.TWO).add(BigInteger.ONE))).add(borderNodes.add(BigInteger.TWO));

        return result;
    }


}
