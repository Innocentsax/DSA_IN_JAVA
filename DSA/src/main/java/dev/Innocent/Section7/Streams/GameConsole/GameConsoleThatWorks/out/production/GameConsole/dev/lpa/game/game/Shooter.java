package dev.Innocent.Section7.Streams.GameConsole.GameConsoleThatWorks.out.production.GameConsole.dev.lpa.game.game;

public record Shooter(String name) implements Player {

    boolean findPrize() {

        System.out.println("Prize found, score should be adjusted.");
        return false;
    }

    boolean useWeapon(String weapon) {

        System.out.println("You Shot your " + weapon);
        return false;
    }
}
