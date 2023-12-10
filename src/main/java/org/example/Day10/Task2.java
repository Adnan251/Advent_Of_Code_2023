package org.example.Day10;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static List<String> theListOfInputLines;
    public static Pipe[][] matrixOfInput;
    public static int startX;
    public static int startY;

    public Task2 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        getData();
    }

    private static void getData(){
        int r = theListOfInputLines.size();
        int c = theListOfInputLines.get(0).split("").length;
        matrixOfInput = new Pipe[r][c];

        for(int i = 0; i < theListOfInputLines.size(); i++){
            char[] s = theListOfInputLines.get(i).toCharArray();
            for(int j = 0; j < s.length; j++){
                if(s[j] == 'S'){
                    startX = i;
                    startY = j;
                    matrixOfInput[i][j] = new Pipe(s[j], i, j);
                    matrixOfInput[i][j].setPassed(true);
                    continue;
                }
                matrixOfInput[i][j] = new Pipe(s[j], i, j);
            }
        }
    }

    public static int getTheResult(){
        List<int[]> loopPoints = new ArrayList<>();
        Pipe startPipe = matrixOfInput[startX][startY];
        Pipe nextpipe = startPipe.getNext(matrixOfInput);
        loopPoints.add(new int[]{startPipe.getRow(), startPipe.getColl()});
        int counter = 0;

        while (nextpipe.getType()!='S') {
            nextpipe.setPassed(true);
            loopPoints.add(new int[]{nextpipe.getRow(), nextpipe.getColl()});
            nextpipe = nextpipe.getNext(matrixOfInput);
            counter++;
        }
        counter += 1;

        //Shoelace formula
        if (loopPoints.size()-1 < 3) {
            return 0;
        }

        int area = 0;

        for(int i = 0; i < loopPoints.size()-1; i++){
            int[] p = loopPoints.get(i);
            int[] nextP = loopPoints.get(i+1);

            area += (p[0] * nextP[1]) - (nextP[0] * p[1]);
        }

        int[] lastP = loopPoints.get(loopPoints.size()-1);
        int[] firstP = loopPoints.get(0);

        area += (lastP[0] * firstP[1]) - (firstP[0] * lastP[1]);
        area = Math.abs(area) / 2;

        //Pick's theorem
        return  area - counter/2 + 1;
    }
}

