package dev.Innocent.Section8.MathRandomProject.dice;

import java.util.*;

public enum ScoredItem {
    ACES(0, 1),
    TWOS(0, 2),
    THREES(0, 3),
    FOURS (0, 4),
    FIVES(0, 5),
    SIXES(0,6),
    THREE_OF_KIND(0),
    FOUR_OF_KIND(0),
    FULL_HOUSE(25),
    SMALL_STRAIGHT(30),
    LARGE_STRAIGHT(40),
    FIVE_OF_KIND(50);

    private final int defaultScore;
    private int faceValue = 0;

    ScoredItem(int defaultScore) {
        this.defaultScore = defaultScore;
    }
    ScoredItem(int defaultScore, int faceValue) {
        this.defaultScore = defaultScore;
        this.faceValue = faceValue;
    }

    private int frequency(List<Integer> dice, int value) {
        return (int) dice.stream()
                .mapToInt(i->i)
                .filter(i -> i == value)
                .count();
    }

    private int frequency(List<Integer> dice) {
        return frequency(dice, faceValue);
    }

    private Map<Integer, Integer> mapDice(List<Integer> dice) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int d : dice) {
            map.merge(d, 1, Math::addExact );
        }
        return map;
    }
    private int getMax(List<Integer> dice) {

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int d : dice) {
            max = Math.max( map.merge(d, 1, Math::addExact ), max);
        }
        return max;
    }
    private int checkStraight(List<Integer> dice) {

        dice.sort(Comparator.naturalOrder());
        int contiguousCount=1;
        for (int i = 0; i < dice.size() - 1; i++) {
            if (dice.get(i) == dice.get(i+1) - 1) {
                contiguousCount++;
            }
        }
        return contiguousCount;
    }

    private boolean checkFullHouse(List<Integer> dice) {
        Map<Integer, Integer> map = mapDice(dice);

        if (map.size() == 1) {
            // Five of a kind is ok
            return true;
        }
        if (map.size()== 2) {
            for (int val : map.values()) {
                if (val == 1) return false;
            }
            return true;
        }
        return false;
    }

    public int score(List<Integer> dice) {
        int score = switch (this) {
            case ACES, TWOS, THREES, FOURS, FIVES, SIXES ->
                    frequency(dice) * faceValue;
            case THREE_OF_KIND ->
                    getMax(dice) >= 3 ? dice.stream().mapToInt(i->i).sum() : 0;
            case FOUR_OF_KIND ->
                    getMax(dice) >= 4 ? dice.stream().mapToInt(i->i).sum() : 0;
            case FIVE_OF_KIND ->
                    getMax(dice) == 5 ? defaultScore : 0;
            case SMALL_STRAIGHT ->
                    checkStraight(dice) >= 4 ? defaultScore : 0;
            case LARGE_STRAIGHT ->
                    checkStraight(dice) == 5 ? defaultScore : 0;
            case FULL_HOUSE ->
                    checkFullHouse(dice) ? defaultScore: 0;
            default -> defaultScore;
        };
        return score;
    }
}
