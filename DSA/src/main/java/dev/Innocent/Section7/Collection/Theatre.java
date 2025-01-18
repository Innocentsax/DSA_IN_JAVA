package dev.Innocent.Section7.Collection;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Theatre {

    class Seat implements Comparable<Seat>{
        private String seatNum;
        private boolean reserved;

        public Seat(char rowChar, int seatNo){
            this.seatNum = "%c%03d".formatted(rowChar, seatNo).toUpperCase();
        }

        @Override
        public String toString() {
            return seatNum;
        }

        @Override
        public int compareTo(Seat o) {
            return seatNum.compareTo(o.seatNum);
        }
    }

    private String theaterName;
    private int seatPerRows;
    private NavigableSet<Seat> seats;

    public Theatre(String theaterName, int rows, int totalSeats) {
        this.theaterName = theaterName;
        this.seatPerRows = totalSeats / rows;

        seats = new TreeSet<>();
        for (int i = 0; i < totalSeats; i++) {
            char rowChar = (char) (i / seatPerRows + (int) 'A');
            int seatInRow = i % seatPerRows + 1;
            seats.add(new Seat(rowChar, seatInRow));
        }
    }

    public void printSeatMap(){
        String separatorLine = "_".repeat(90);
        System.out.printf("%1$s%n%2$s Seat Map%nn%1$s%n", separatorLine, theaterName);
        int index = 0;
        for(Seat s : seats){
            System.out.printf("%-8s%s", s.seatNum + ((s.reserved) ? "(\u25CF)" : ""),
                    ((index++ + 1) % seatPerRows == 0) ? "\n" : "");
        }
        System.out.println(separatorLine);
    }
}
