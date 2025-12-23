package dev.Innocent.Section8.ConcurrencyAndMultithreading.ThreadProblems;

record Participant(String name, String searchingFor, Maze maze, int[] startingPosition){
    Participant{
        maze.moveLocation(startingPosition[0], startingPosition[1], name);
    }
}

public class MazeRunner {
}
