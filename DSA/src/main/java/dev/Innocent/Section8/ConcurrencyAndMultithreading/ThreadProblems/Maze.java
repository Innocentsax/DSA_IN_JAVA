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
}
