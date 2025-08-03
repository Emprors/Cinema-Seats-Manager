package org.example.cinema_seats_manager.Services;

import org.example.cinema_seats_manager.Models.CinemaSeats;
import org.example.cinema_seats_manager.Models.Seat;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatsService {

    CinemaSeats cinemaSeats;



    public SeatsService(){
        this.cinemaSeats = new CinemaSeats(9,9);

    }

    public CinemaSeats getCinemaSeats() {
        return cinemaSeats;
    }

    public Optional<Seat> purchaseSeat(int row, int column){

        for (Seat seat : cinemaSeats.getAvailableSeats()) {

            if (seat.getRow() == row && seat.getColumn() == column) {
                if (isSeatFree(seat)) {
                    cinemaSeats.getAvailableSeats().remove(seat);
                    System.out.println((long) cinemaSeats.getAvailableSeats().size());
                    return Optional.of(seat);
                }
            }
        }

        return Optional.empty();
    }

    public  boolean isSeatAvailable(int row, int column){
        Seat seat = new Seat(row, column);
        return cinemaSeats.getAvailableSeats().contains(seat);
    }

    public boolean isSeatFree( Seat seat) {
        return cinemaSeats.getAvailableSeats().contains(seat);

    }
}
