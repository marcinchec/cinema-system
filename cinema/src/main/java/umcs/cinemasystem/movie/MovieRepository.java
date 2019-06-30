package umcs.cinemasystem.movie;

import java.util.List;

public interface MovieRepository {
    Long save(Movie movie);

    List<Movie> getAll();
}
