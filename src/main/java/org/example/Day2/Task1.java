package org.example.Day2;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static List<String> theListOfInputLines;
    public static Integer blue =14 ;
    public static Integer red =12 ;
    public static Integer green =13 ;

    public Task1 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
    }

    public static Integer findPossibleGames(){

        List<Integer> possibleGames = new ArrayList<>();
        HashMap<Integer, List<HashMap<String, Integer>>> mapOfInput = new HashMap<>();

        for (String l: theListOfInputLines) {
            Pattern pattern = Pattern.compile("Game (\\d+):");
            Matcher matcher = pattern.matcher(l);
            Integer currentGame = 0;

            if(matcher.find()){
                currentGame = Integer.parseInt(matcher.group(1));
            }
            else{
                break;
            }

            String[] firstSplit = l.split(":");
            String[] secondSplit = firstSplit[1].split(";");
            List<HashMap<String, Integer>> tempList = new ArrayList<>();

            for( String s : secondSplit){
                String[] thirdSplit = s.split(",");
                HashMap<String, Integer> tempMap = new HashMap<>();
                for (String sp: thirdSplit) {
                    sp = sp.trim();
                    String[] finalSplit = sp.split(" ");
                    tempMap.put(finalSplit[1], Integer.parseInt(finalSplit[0]));
                }
                tempList.add(tempMap);
            }
            mapOfInput.put(currentGame, tempList);
        }

        for (Map.Entry<Integer, List<HashMap<String, Integer>>> entry : mapOfInput.entrySet()) {
            Boolean check = Boolean.TRUE;
            for (HashMap<String, Integer> hm: entry.getValue()) {
                for (Map.Entry<String, Integer> thingy: hm.entrySet()){
                    if(thingy.getKey().equals("blue") && thingy.getValue() > blue ){
                        check = Boolean.FALSE;
                        break;
                    }
                    else if (thingy.getKey().equals("red") && thingy.getValue() > red) {
                        check = Boolean.FALSE;
                        break;
                    }
                    else if (thingy.getKey().equals("green") && thingy.getValue() > green) {
                        check = Boolean.FALSE;
                        break;
                    }
                }
                if(!check){
                    break;
                }
            }
            if(check){
                possibleGames.add(entry.getKey());
            }
        }
        int result = 0;
        for (Integer num: possibleGames) {
            result += num;
        }

        return result;
    }
}
