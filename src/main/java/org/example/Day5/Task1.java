package org.example.Day5;

import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {
    public static List<String> theListOfInputLines;
    public static List<Long> listOfSeedsRequired = new ArrayList<>();
    public static Map<Long, Long>mapSeetToSoil = new HashMap<>();
    public static Map<Long, Long>mapSoilToFertilizer = new HashMap<>();
    public static Map<Long, Long>mapFertilizerToWater = new HashMap<>();
    public static Map<Long, Long>mapWaterToLight = new HashMap<>();
    public static Map<Long, Long>mapLightToTemperature = new HashMap<>();
    public static Map<Long, Long>mapTemperatureToHumidity = new HashMap<>();
    public static Map<Long, Long>mapHumidityToLocation = new HashMap<>();

    public Task1 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
    }

    public static void getListOfSeedsRequired(){
        String[] split = theListOfInputLines.get(0).split(" ");

        for(int i = 1; i < split.length; i++){
            listOfSeedsRequired.add(Long.parseLong(split[i]));
        }
        System.out.println(listOfSeedsRequired);
    }

    public static Long getAllTheMaps(){
        getListOfSeedsRequired();

        Map<Integer, Map<Long, Long>> mapOfMaps = new HashMap<>();
        mapOfMaps.put(0, mapSeetToSoil);
        mapOfMaps.put(1, mapSoilToFertilizer);
        mapOfMaps.put(2, mapFertilizerToWater);
        mapOfMaps.put(3, mapWaterToLight);
        mapOfMaps.put(4, mapLightToTemperature);
        mapOfMaps.put(5, mapTemperatureToHumidity);
        mapOfMaps.put(6, mapHumidityToLocation);
        int highestSeed =0;

        Integer mapCounter = 0;
        for(int i = 3; i < theListOfInputLines.size(); i++){
            if(theListOfInputLines.get(i).equals("") || theListOfInputLines.get(i).equals(null)){
                fillInTheUnknown(mapOfMaps.get(mapCounter),highestSeed);
                mapCounter++;
                i += 2;

            }

            String[] options = theListOfInputLines.get(i).split(" ");

            for(int j = 0; j < Integer.parseInt(options[2]); j++){
                mapOfMaps.get(mapCounter).put(Long.parseLong(options[1])+j,Long.parseLong(options[0])+j);
                if(mapCounter == 0 && Integer.parseInt(options[1])+j > highestSeed){
                    highestSeed = Integer.parseInt(options[1])+j;
                }
            }

        }
        fillInTheUnknown(mapOfMaps.get(mapCounter),highestSeed);
        List<Long> hights = new ArrayList<>();

        for(int i = 0; i < listOfSeedsRequired.size(); i++ ){
            Long num = mapOfMaps.get(6).get(mapOfMaps.get(5).get(mapOfMaps.get(4).get(mapOfMaps.get(3).get(mapOfMaps.get(2).get(mapOfMaps.get(1).get(mapOfMaps.get(0).get(listOfSeedsRequired.get(i))))))));
            hights.add(num);
        }
        Long min = hights.get(0);
        for (Long i: hights) {
            if(i < min){
                min = i;
            }
        }

        return min;
    }

    public static void fillInTheUnknown(Map<Long, Long> map, Integer num){
        for(long i = 0;i <= num; i++){
            if(!map.containsKey(i)){
                map.put(i, i);
            }
        }

    }

}
