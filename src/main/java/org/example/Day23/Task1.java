package org.example.Day23;
import org.example.Miscenalious.FileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static List<String> theListOfInputLines;

    public Task1 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
    }

    public int getTheResult(){
        char[][] matrix = new char[theListOfInputLines.size()][theListOfInputLines.get(0).length()];
        for(int i = 0; i < theListOfInputLines.size(); i++){
            matrix[i] = theListOfInputLines.get(i).toCharArray();
        }
        List<int[]> paths = findLongestPath(matrix);
        return paths.size()-1;
    }

    private static List<int[]> findLongestPath(char[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        List<int[]> maxPath = new ArrayList<>();
        List<int[]> currentPath = new ArrayList<>();

        for (int startCol = 1; startCol < cols - 1; startCol++) {
            if (maze[0][startCol] == '.') {
                dfs(maze, visited, 0, startCol, currentPath, maxPath);
            }
        }

        return maxPath;
    }

    private static void dfs(char[][] maze, boolean[][] visited, int row, int col, List<int[]> currentPath, List<int[]> maxPath) {
        int rows = maze.length;
        int cols = maze[0].length;

        visited[row][col] = true;
        currentPath.add(new int[]{row, col});

        if (row == rows - 1 && col == cols - 2) {
            if (currentPath.size() > maxPath.size()) {
                maxPath.clear();
                maxPath.addAll(new ArrayList<>(currentPath));
            }
            visited[row][col] = false;
            currentPath.remove(currentPath.size() - 1);
            return;
        }

        int[][] directions = getDirections(maze, row, col);
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (isValidMove(maze, visited, newRow, newCol)) {
                dfs(maze, visited, newRow, newCol, currentPath, maxPath);
            }
        }

        visited[row][col] = false;
        currentPath.remove(currentPath.size() - 1);
    }

    private static int[][] getDirections(char[][] maze, int row, int col) {
        char cell = maze[row][col];
        int[][] directions;

        switch (cell) {
            case '>':
                directions = new int[][]{{0, 1}};
                break;
            case '<':
                directions = new int[][]{{0, -1}};
                break;
            case 'v':
                directions = new int[][]{{1, 0}};
                break;
            case '^':
                directions = new int[][]{{-1, 0}};
                break;
            default:
                directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        }

        return directions;
    }

    private static boolean isValidMove(char[][] maze, boolean[][] visited, int row, int col) {
        int rows = maze.length;
        int cols = maze[0].length;
        return row >= 0 && row < rows && col >= 0 && col < cols && maze[row][col] != '#' && !visited[row][col];
    }
}
