package dev.Innocent.Section8.MathRandomProject.games;

import java.util.function.Predicate;

public record GameAction(char key, String prompt, Predicate<Integer> action) {
}
