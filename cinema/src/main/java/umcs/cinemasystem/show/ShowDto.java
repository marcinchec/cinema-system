package umcs.cinemasystem.show;

import umcs.cinemasystem.cinema.Cinema;
import umcs.cinemasystem.movie.Movie;

import java.time.LocalDateTime;

public class ShowDto {

    public Cinema cinema;
    public Movie movie;
    public LocalDateTime startOfShow;
}
