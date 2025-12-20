package dev.Innocent.Section8.ConcurrencyAndMultithreading.ThreadProblems;

import java.util.Arrays;

public class Maze {
    public static final int  MAZE_SIZE = 4;
    private final String[][] cells = new String[MAZE_SIZE][MAZE_SIZE];

    public Maze(){
        for(var row : cells){
            Arrays.fill(row, "");
        }
    }

    public int[] getNextLocation(int[] lastSpot){
        int[] nextSpot = new int[2];
        nextSpot[1] = (lastSpot[1] == Maze.MAZE_SIZE - 1) ? 0 : lastSpot[1] + 1;
        nextSpot[0] = lastSpot[0];
        if(nextSpot[1] == 0){
            nextSpot[0] = (lastSpot[0] == Maze.MAZE_SIZE - 1) ? 0 : lastSpot[0] + 1;
        }
        return nextSpot;
    }
}
