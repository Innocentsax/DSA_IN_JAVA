package dev.Innocent.Section8.MathRandomProject.dice;

import dev.Innocent.Section8.MathRandomProject.games.Game;
import dev.Innocent.Section8.MathRandomProject.games.GameAction;

import java.util.LinkedHashMap;
import java.util.Map;

public class DiceGame extends Game<DicePlayer> {

    public DiceGame(String gameName) {
        super(gameName);
    }

    @Override
    public DicePlayer createNewPlayer(String name) {
        return new DicePlayer(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        Map<Character, GameAction> map = new LinkedHashMap<>();
        map.putAll(getStandardActions());
        return map;
    }
}
