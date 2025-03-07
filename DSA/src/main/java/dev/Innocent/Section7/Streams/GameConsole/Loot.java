package dev.Innocent.Section7.Streams.GameConsole;

public enum Loot {
    SILVER_COIN(5),
    GOLD_COIN(10),
    GOLD_RING(125),
    PEARL_NECKLACE(250),
    GOLD_BAR(500);

    private final int worth;

    Loot(int worth) {
        this.worth = worth;
    }

    public int getWorth() {
        return worth;
    }
}
