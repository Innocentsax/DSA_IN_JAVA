package dev.Innocent.Section7.Streams.GameConsole.GameConsoleThatWorks.out.production.GameConsole.dev.lpa.game.game;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Game<T extends Player> {

    private final String gameName;
    private final List<T> players = new ArrayList<>();
    private Map<Character, GameAction> standardActions = null;

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public Map<Character, GameAction> getStandardActions() {

        if (standardActions == null) {
            standardActions = new LinkedHashMap<>(Map.of(
                    'I',
                    new GameAction('I', "Print Player Info",
                            i -> this.printPlayer(i)),
                    'Q',
                    new GameAction('Q', "Quit Game",
                            this::quitGame)
            ));
        }
        return standardActions;
    }

    public abstract T createNewPlayer(String name);
    public abstract Map<Character, GameAction> getGameActions(int playerIndex);

    final int addPlayer(String name) {

        T player = createNewPlayer(name);
        if (player != null) {
            players.add(player);
            return players.size() - 1;
        }
        return -1;
    }

    protected final T getPlayer(int playerIndex) {
        return players.get(playerIndex);
    }

    public boolean executeGameAction(int player, GameAction action) {
        return action.action().test(player);
    }

    public boolean printPlayer(int playerIndex) {

        Player player = players.get(playerIndex);
        System.out.println(player);
        return false;
    }

    public boolean quitGame(int playerIndex) {

        Player player = players.get(playerIndex);
        System.out.println("Sorry to see you go, " + player.name());
        return true;
    }
}