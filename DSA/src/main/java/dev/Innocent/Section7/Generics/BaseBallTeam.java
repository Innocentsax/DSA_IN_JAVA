package dev.Innocent.Section7.Generics;

import java.util.ArrayList;
import java.util.List;

record BaseBallPlayer(String name, String position){}

public class BaseBallTeam {
    private String teamName;
    private List<BaseBallPlayer> teamMember = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTries = 0;

    public BaseBallTeam(String name) {
        this.teamName = name;
    }

    public void addTeamMember(BaseBallPlayer player){
        if(!teamMember.contains(player)){
            teamMember.add(player);
        }
    }

    public void listTeamMember(){
        System.out.println(teamName + " Roaster");
        System.out.println(teamMember);
    }

    public int ranking(){
        return (totalLosses * 2) + totalTries + 1;
    }

    public String setScore(int ourScores, int theirScores){
        String message = "lost to";
        if(ourScores > theirScores){
            totalWins++;
            message = "beat";
        } else if (theirScores == ourScores) {
            totalTries++;
            message = "tied";
        }else {
            totalLosses++;
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }

    public static void main(String[] args) {
        BaseBallTeam kk = new BaseBallTeam("Eka");
        BaseBallTeam gg = new BaseBallTeam("pp");
        BaseBallTeam mm = new BaseBallTeam("mm");
        BaseBallTeam qq = new BaseBallTeam("qq");
        scoreResult(kk, 5, gg, 3);
    }

    public static void scoreResult(BaseBallTeam team1, int score1,
                                   BaseBallTeam team2, int score2){
        String message = team1.setScore(score1, score2);
        team2.setScore(score2, score1);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
