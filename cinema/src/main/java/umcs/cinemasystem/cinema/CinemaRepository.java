package umcs.cinemasystem.cinema;

import java.util.List;

public interface CinemaRepository {

    Long save(Cinema cinema);

    List<Cinema> getAll();
}
