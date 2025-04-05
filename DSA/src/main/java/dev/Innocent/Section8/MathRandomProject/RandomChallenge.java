package dev.Innocent.Section8.MathRandomProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomChallenge {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> currentDice = new ArrayList<>();

        int rolls = 0;
        do{
            rollDice(currentDice);
            currentDice.clear();
        } while (++rolls < 5);
    }

    private static void rollDice(List<Integer> currentDice){
        int randomCount = 5 - currentDice.size();
        var newDice = random.ints(randomCount, 1, 7)
                .sorted()
                .boxed()
                .toList();
        currentDice.addAll(newDice);

        System.out.println("You're dice are: " + currentDice);
    }

    private static boolean pickLosers(List<Integer> currentDice){
        String prompt = """
                Press Enter to Score.
                Type "ALL" to re-roll all the dice.
                List numbers (separated by space) to re-roll selected dice.
                """;
        System.out.print(prompt + "--> ");
        String userInput = scanner.nextLine();
        if(userInput.isBlank()){
            return true;
        }
        try {
            removeDice(currentDice, userInput.split(" "));
        }catch (Exception e){
            e.printStackTrace(System.out);
            System.out.println("Bad input, Try again");
        }
        return false;
    }

    private static void removeDice(List<Integer> currentDice, String[] selected){
        if(selected.length == 1 && selected[0].contains("ALL")){
            currentDice.clear();
        }else {
            for(String removed : selected){
                currentDice.remove(Integer.valueOf(removed));
            }
            System.out.println("Keeping " + currentDice);
        }
    }
}
