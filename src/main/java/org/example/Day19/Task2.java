package org.example.Day19;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task2 {
    public static List<String> theListOfInputLines;
    public HashMap<String, WorkFlow> mapOfWorkflows;
    public List<Part> listOfParts;
    public int result = 0;

    public Task2 (String filePath) throws FileNotFoundException {
        this.mapOfWorkflows = new HashMap<>();
        this.listOfParts = new ArrayList<>();
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);

        for (String s:theListOfInputLines) {
            if(s.equals("")){
                break;
            }
            String[] split = s.split("\\{");
            mapOfWorkflows.put(split[0], new WorkFlow(split[1].substring(0, split[1].length()-1)));
        }

        WorkFlow startFlow = mapOfWorkflows.get("in");
        WorkFlow currentFlow = startFlow;
        for (int i = 1; i <= 4000; i++) {
            for(int j = 1; j <= 4000; j++){
                for(int k = 1; k <= 4000; k++){
                    for(int l = 1; l <= 4000; l++){
                        Part p = new Part(i,j,k,l);
                        System.out.println("x="+i+", m="+j+", a="+k+", s="+l);
                        while(true){
                            String v = currentFlow.checkGoodOrNot(p);
                            if(v.equals("A")){
                                result++;
                                break;
                            } else if (v.equals("R")) {
                                break;
                            }
                            currentFlow = mapOfWorkflows.get(v);
                        }
                    }
                }
            }
        }
    }

    public long getTheResult(){
        return result;
    }

}
