package dev.Innocent.Section7.Streams.GameConsole;

import java.util.function.Predicate;

public sealed interface SealedInterface permits BetterInterface, StringChecker {
    boolean testData(Predicate<String> p, String... String);
}
