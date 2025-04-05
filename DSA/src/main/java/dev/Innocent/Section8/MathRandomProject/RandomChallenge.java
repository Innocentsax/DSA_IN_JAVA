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
}
