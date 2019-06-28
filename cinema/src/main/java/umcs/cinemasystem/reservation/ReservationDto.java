package umcs.cinemasystem.reservation;

import umcs.cinemasystem.cinema.Cinema;
import umcs.cinemasystem.movie.Movie;
import umcs.cinemasystem.show.Show;

import java.util.List;

public class ReservationDto {
    public Cinema cinema;
    public Movie movie;
    public Show show;
    public TicketType ticketType;
    public List<Seats> seats;
}
