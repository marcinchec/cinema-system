package umcs.cinemasystem.cinema;

import java.util.List;

public interface CinemaRepository {

    void save(Cinema cinema);

    List<Cinema> getAll();
}
