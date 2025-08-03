package org.example.cinema_seats_manager.Controllers;

import org.example.cinema_seats_manager.Components.Errors;
import org.example.cinema_seats_manager.Models.Seat;
import org.example.cinema_seats_manager.Services.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class SeatsController {


    @Autowired
    SeatsService seatsService;


    @GetMapping("/seats")
    public ResponseEntity<?> seats()  {

        return ResponseEntity.ok(seatsService.getCinemaSeats());
    }

    @PostMapping(value = "/purchase", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> purchase(@RequestBody Seat seatBody) {
        int row = seatBody.getRow();
        int column = seatBody.getColumn();
        //  System.out.println("is seat available" + seatsService.isSeatFree(seatsService.getCinemaSeats(),row, column));
        Optional<Seat> seat = seatsService.purchaseSeat(row, column);
        if(row < 1 || column < 1 || row > 9 || column > 9) {
            throw new IllegalArgumentException(Errors.getWrongSeat());
        }
        if (seat.isEmpty()){
            throw new IllegalArgumentException(Errors.getTicketAlreadyPurchased());
        }


        return ResponseEntity.ok().body(seat.get());
    }


}
