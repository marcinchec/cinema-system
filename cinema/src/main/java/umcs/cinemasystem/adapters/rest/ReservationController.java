package umcs.cinemasystem.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umcs.cinemasystem.reservation.CancellationToken;
import umcs.cinemasystem.reservation.Reservation;
import umcs.cinemasystem.reservation.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping()
    public void reserve(Reservation reservation) {
        this.reservationService.reserve(reservation);
    }

    @DeleteMapping("{id}")
    public void cancel(@PathVariable Long id, CancellationToken token) {
        this.reservationService.cancel(id, token);
    }

    @PutMapping("{id}")
    public void markAsPaid(@PathVariable Long id) {
        this.reservationService.markAsPaid(id);
    }

    @PostMapping("/cashier")
    public void createAlreadyPaid(Reservation reservation) {
        this.reservationService.createAlreadyPaid(reservation);
    }
}
