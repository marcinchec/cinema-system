package umcs.cinemasystem.show;

import umcs.cinemasystem.adapters.db.show.CinemaHall;

public interface ShowRepository {

    Long save(Show show);

    void update(Show show, Long id);

    Show getById(Long id);

    CinemaHall getFreeSeats(Long showId);
}
