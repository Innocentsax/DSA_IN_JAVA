package dev.Innocent.Section5.KeywordsAndExpression;

public class MethodChallenge {
    public static void main(String[] args) {
        int newScore = calculateHighScorePosition(999);
        displayHighScorePosition("Innocent", newScore);

        newScore = calculateHighScorePosition(499);
        displayHighScorePosition("Innocent", newScore);

        newScore = calculateHighScorePosition(99);
        displayHighScorePosition("Innocent", newScore);

        newScore = calculateHighScorePosition(0);
        displayHighScorePosition("Innocent", newScore);
    }

    private static void displayHighScorePosition(String playName, int position){
        System.out.println(playName + " manage to get into position " + position + " on te high score list");
    }

    private static int calculateHighScorePosition(int score){
        if(score >= 1000){
            return 1;
        } else if (score >= 500 && score < 1000) {
            return 2;
        } else if (score >= 100 && score < 500) {
            return 3;
        }else return 4;
    }
}
