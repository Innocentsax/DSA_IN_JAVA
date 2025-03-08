package dev.Innocent.Section7.Streams.GameConsole.GameConsoleThatWorks.out.production.GameConsole.dev.lpa.game.game;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ShooterGame extends Game<Shooter> {

    public ShooterGame(String gameName) {
        super(gameName);
    }

    @Override
    public Shooter createNewPlayer(String name) {
        return new Shooter(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {

        var map = new LinkedHashMap<>(Map.of(
                'F',
                new GameAction('F', "Find Prize", this::findPrize),
                'S',
                new GameAction('S', "Use your gun", this::useWeapon)
        ));
        map.putAll(getStandardActions());
        return map;
    }

    public boolean findPrize(int playerIndex) {
        return getPlayer(playerIndex).findPrize();
    }

    public boolean useWeapon(int playerIndex) {
        return getPlayer(playerIndex).useWeapon("pistol");
    }
}
