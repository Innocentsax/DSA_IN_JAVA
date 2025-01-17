package dev.Innocent.Section7.Collection;

import java.util.NavigableSet;

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

    public Theatre(String theaterName, int seatPerRows) {
        this.theaterName = theaterName;
        this.seatPerRows = seatPerRows;
    }
}
