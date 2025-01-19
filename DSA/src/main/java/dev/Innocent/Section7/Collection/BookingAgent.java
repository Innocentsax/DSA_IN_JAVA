package dev.Innocent.Section7.Collection;

public class BookingAgent {
    public static void main(String[] args) {
        int rows = 10;
        int totalSeats = 100;
        Theatre rodgersNYC = new Theatre("Richard Rodgers", rows, totalSeats);
        rodgersNYC.printSeatMap();

        bookSeat(rodgersNYC, 'A', 3);
        bookSeat(rodgersNYC, 'A', 3);

        bookSeat(rodgersNYC, 'B', 1);
        bookSeat(rodgersNYC, 'M', 11);

    }

    private static void bookSeat(Theatre theatre, char row, int seatNo){
        String seat = theatre.reserveSeat(row, seatNo);
        if(seat != null){
            System.out.println("Congratulation! Your reserved seat is " + seat);
            theatre.printSeatMap();
        }else {
            System.out.println("Sorry! Unable to reserve " + row + seatNo);
        }
    }
}
