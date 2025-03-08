package dev.Innocent.Section7.Streams.GameConsole.GameConsoleThatWorks.out.production.GameConsole.dev.lpa.game.game;

import java.util.function.Predicate;

public record GameAction(char key, String prompt, Predicate<Integer> action) {
}
