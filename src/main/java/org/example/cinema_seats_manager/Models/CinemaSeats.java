package org.example.cinema_seats_manager.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class CinemaSeats {

    @JsonProperty("rows")
    private int numRows;
    @JsonProperty("columns")
    private int numCols;
    @JsonProperty("seats")
    private ArrayList<Seat> availableSeats;

    public CinemaSeats(int row, int column) {
        numRows = row;
        numCols = column;
        availableSeats = new ArrayList<>();
        for (row = 1; row < 10; row++) {
            for (column = 1; column < 10; column++) {
                Seat seat = new Seat();
                seat.setRow(row);
                seat.setColumn(column);
                setSeatPrice(seat);
                availableSeats.add(seat);

            }
        }
    }

    private  void setSeatPrice(Seat seat) {
        if (seat.getRow() < 5){
            seat.setPrice(10);
        } else {
            seat.setPrice(8);
        }

    }

    public ArrayList<Seat> getAvailableSeats() {
        return availableSeats;
    }

}
