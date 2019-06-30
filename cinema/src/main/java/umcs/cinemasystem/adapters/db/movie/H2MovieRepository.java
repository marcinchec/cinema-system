package umcs.cinemasystem.adapters.db.movie;

import org.springframework.stereotype.Repository;
import umcs.cinemasystem.movie.Movie;
import umcs.cinemasystem.movie.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class H2MovieRepository implements MovieRepository {
    private SpringDataMovieRepository repository;

    public H2MovieRepository(SpringDataMovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long save(Movie movie) {
        return this.repository.save(mapMovieToEntity(movie)).getId();
    }

    @Override
    public List<Movie> getAll() {
        return this.repository.findAll()
                .stream()
                .map(this::mapEntityToMovie)
                .collect(Collectors.toList());
    }

    private MovieH2 mapMovieToEntity(Movie movie) {
        return new MovieH2(movie.getTitle(), movie.getType());
    }

    private Movie mapEntityToMovie(MovieH2 movieH2) {
        return new Movie(movieH2.getTitle(), movieH2.getType());
    }
}
