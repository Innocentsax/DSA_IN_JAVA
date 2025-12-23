package dev.Innocent.Section8.ConcurrencyAndMultithreading.ThreadProblems;

import java.util.Arrays;

record Participant(String name, String searchingFor, Maze maze, int[] startingPosition){
    Participant{
        maze.moveLocation(startingPosition[0], startingPosition[1], name);
    }
}

class ParticipantThread extends Thread{
    public final Participant participant;

    public ParticipantThread(Participant participant) {
        super(participant.name());
        this.participant = participant;
    }

    @Override
    public void run(){
        int[] lastSpot = participant.startingPosition();
        Maze maze = participant.maze();

        while (true){
            int[] newSpot = maze.getNextLocation(lastSpot);
            try{
                Thread.sleep(500);
                if(maze.searchCell(participant.searchingFor(), newSpot, lastSpot)){
                    System.out.printf("%s found %s at %s! %n", participant.name(),
                            participant.searchingFor(), Arrays.toString(newSpot));
                    break;
                }
                synchronized (maze){
                    maze.moveLocation(newSpot[0], newSpot[1], participant.name());
                }
                lastSpot = new int[]{newSpot[0], newSpot[1]};
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                return;
            }
            System.out.println(participant.name() + " searching " + participant.maze());
        }
    }
}

public class MazeRunner {
    public static void main(String[] args) {

    }
}
