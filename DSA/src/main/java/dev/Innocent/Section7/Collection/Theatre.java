package dev.Innocent.Section7.Collection;

import java.util.*;

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
        System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n", separatorLine, theaterName);
        int index = 0;
        for(Seat s : seats){
            System.out.printf("%-8s%s", s.seatNum + ((s.reserved) ? "(\u25CF)" : ""),
                    ((index++ + 1) % seatPerRows == 0) ? "\n" : "");
        }
        System.out.println(separatorLine);
    }

    public String reserveSeat(char row, int seat){
        Seat requestSeat = new Seat(row, seat);
        Seat requested = seats.floor(requestSeat);

        if(requested == null || !requested.seatNum.equals(requestSeat.seatNum)){
            System.out.print("--> No such seat: " + requestSeat);
            System.out.printf(": Seat must be between %s and %s%n",
                    seats.first().seatNum, seats.last().seatNum);
        }else{
            if(!requested.reserved){
                requested.reserved = true;
                return requested.seatNum;
            }else{
                System.out.println("Seat's already reserved");
            }
        }
        return null;
    }

    private boolean validate(int count, char first, char last, int min, int max){
        boolean result = (min > 0 || seatPerRows >= count || (max - min + 1) >= count);
        result = result && seats.contains(new Seat(first, min));
        if(!result){
            System.out.printf("Invalid! %1$d seats between " +
                    "%2$c[%3$d-%4$d]-%5$c[%3$d-%4$d] Try again", count, first, min, max, last);
            System.out.printf(": Seat must be between %s and %s%n",
                    seats.first().seatNum, seats.last().seatNum);
        }
        return result;
    }

    public Set<Seat> reserveSeats(int count, char minRow, char maxRow, int minSeat, int maxSeat){
        char lastValid = seats.last().seatNum.charAt(0);
        maxRow = (maxRow < lastValid) ? maxRow : lastValid;
    }
}
