package org.example.Day10;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.List;

public class Task1 {
    public static List<String> theListOfInputLines;
    public static Pipe[][] matrixOfInput;
    public static int startX;
    public static int startY;

    public Task1 (String filePath) throws FileNotFoundException {
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
        Pipe startPipe = matrixOfInput[startX][startY];
        Pipe nextpipe = startPipe.getNext(matrixOfInput);
        int counter = 0;

        while (nextpipe.getType()!='S') {
            System.out.println(nextpipe.toString());
            nextpipe.setPassed(true);
            nextpipe = nextpipe.getNext(matrixOfInput);
            counter++;
        }
        counter += 1;
        return counter/2;
    }
}
