package org.example.cinema_seats_manager.Components;

public class Errors {
    static String TicketAlreadyPurchased = "The ticket has been already purchased!";
    static String WrongSeat =  "The number of a row or a column is out of bounds!";

    public static String getTicketAlreadyPurchased() {
        return TicketAlreadyPurchased;
    }
    public static String getWrongSeat() {
        return WrongSeat;
    }
}
