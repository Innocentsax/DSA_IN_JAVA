package dev.Innocent.Section7.Collection;

public class PlayingCard {
    private String suit;
    private String face;
    private int internalHash;

    public PlayingCard(String suit, String face) {
        this.suit = suit;
        this.face = face;
        this.internalHash = (suit.equals("Heart")) ? 11 : 12;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }

    @Override
    public int hashCode() {
        return internalHash;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("--> Checking Playing Card equality");
        return true;
    }
}
