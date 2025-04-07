package dev.Innocent.Section8.MathRandomProject.dice;

import dev.Innocent.Section8.MathRandomProject.games.Player;

import java.util.*;

public class DicePlayer implements Player {
    private final String name;
    private final List<Integer> currentDice = new ArrayList<>();
    private final Map<ScoredItem, Integer> scoreCard = new EnumMap<>(ScoredItem.class);

    public DicePlayer(String name) {
        this.name = name;
        for(ScoredItem item : ScoredItem.values()){
            scoreCard.put(item, null);
        }
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "DicePlayer{" +
                "name='" + name + '\'' +
                ", currentDice=" + currentDice +
                ", scoreCard=" + scoreCard +
                '}';
    }

    public void rollDice(){
        int randomCount = 5 - currentDice.size();
        var newDice = new Random()
                .ints(randomCount, 1, 7)
                .sorted()
                .boxed()
                .toList();

        currentDice.addAll(newDice);
        System.out.println("You're dice are " + currentDice);
    }
}
