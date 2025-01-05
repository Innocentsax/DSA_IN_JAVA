package dev.Innocent.Section7.Collection;

public enum Ranking {
    NONE, ONE_PAIR, TWO_PAIRS, THREE_OF_A_KIND, FULL_HOUSE, FOUR_OF_A_KIND;


    @Override
    public String toString() {
        return this.name().replace('_', ' ');
    }
}
