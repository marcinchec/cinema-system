package umcs.cinemasystem.movie;

import java.util.List;

public interface MovieRepository {
    void save(Movie movie);

    List<Movie> getAll();
}
