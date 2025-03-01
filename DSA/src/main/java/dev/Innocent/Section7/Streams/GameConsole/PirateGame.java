package dev.Innocent.Section7.Streams.GameConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PirateGame extends Game<Pirate>{

    private static final List<List<String>> levelMap;
    //---------------------------------------------------------------------
    static {
        levelMap = new ArrayList<>();
        System.out.println("Loading Data...");
        loadData();

        if(levelMap.size() == 0){
            throw new RuntimeException("Could not load data, try later");
        }
        System.out.println("Finished Loading Data");
    }
    //-----------------------------------------------------------------------

    public PirateGame(String gameName) {
        super(gameName);
    }

    @Override
    public Pirate createNewPlayer(String name) {
        return new Pirate(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        return Map.of();
    }
}
