package dev.Innocent.Section8.Stream.StreamTerminal;

import java.util.Random;

public record Seat(char rowMaker, int seatNumber, boolean isReserved) {

    public Seat(char rowMaker, int seatNumber) {
        this(rowMaker, seatNumber, new Random().nextBoolean());
    }
}
