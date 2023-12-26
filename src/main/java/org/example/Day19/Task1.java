package org.example.Day19;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task1 {
    public static List<String> theListOfInputLines;
    public HashMap<String, WorkFlow> mapOfWorkflows;
    public List<Part> listOfParts;
    public int result;

    public Task1 (String filePath) throws FileNotFoundException {
        int count = 0;
        this.mapOfWorkflows = new HashMap<>();
        this.listOfParts = new ArrayList<>();
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);

        for (String s:theListOfInputLines) {
            if(s.equals("")){
                count++;
                break;
            }
            String[] split = s.split("\\{");
            mapOfWorkflows.put(split[0], new WorkFlow(split[1].substring(0, split[1].length()-1)));
            count++;
        }
        for(int i = count; i < theListOfInputLines.size(); i++){
            listOfParts.add(new Part(theListOfInputLines.get(i)));
        }

        for (Part p:listOfParts) {
            WorkFlow startFlow = mapOfWorkflows.get("in");
            WorkFlow currentFlow = startFlow;

            while(true){
                String v = currentFlow.checkGoodOrNot(p);
                if(v.equals("A")){;
                    result += p.getSum();
                    break;
                } else if (v.equals("R")) {
                    break;
                }
                currentFlow = mapOfWorkflows.get(v);
            }
        }
    }

    public long getTheResult(){
        return result;
    }

}
