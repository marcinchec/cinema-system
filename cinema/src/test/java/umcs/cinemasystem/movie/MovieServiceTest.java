package umcs.cinemasystem.movie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MovieServiceTest {

    @Autowired
    private MovieRepository movieRepository;


    @Test
    public void addsMovie() {
        Movie movie = new Movie("Tytul", "Typ");

        movieRepository.save(movie);
        List<Movie> foundMovies = movieRepository.getAll();

        assertThat(movie.getTitle()).isEqualTo(getSearchingCinema(foundMovies, movie).getTitle());
    }

    private Movie getSearchingCinema(List<Movie> movies, Movie searched) {
        for (Movie m : movies) {
            if (m.equals(searched))
                return m;
        }
        return null;
    }
}
