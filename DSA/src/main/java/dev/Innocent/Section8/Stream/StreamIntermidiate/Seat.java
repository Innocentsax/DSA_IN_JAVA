package dev.Innocent.Section8.Stream.StreamIntermidiate;

public record Seat(char rowMaker, int seatNumber, double price) {
    public Seat(char rowMaker, int seatNumber) {
        this(rowMaker, seatNumber,
                rowMaker > 'C' && (seatNumber <= 2 || seatNumber >= 9) ? 50 : 75);
    }

    @Override
    public String toString() {
        return "%c%03d %.0f".formatted(rowMaker, seatNumber, price);
    }
}
