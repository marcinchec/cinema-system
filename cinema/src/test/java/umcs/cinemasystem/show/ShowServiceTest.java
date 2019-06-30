package umcs.cinemasystem.show;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import umcs.cinemasystem.cinema.Cinema;
import umcs.cinemasystem.cinema.CinemaRepository;
import umcs.cinemasystem.movie.Movie;
import umcs.cinemasystem.movie.MovieRepository;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShowServiceTest {

    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowService showService;

    private Long cinemaId;
    private Long movieId;
    private Long showId;
    private Show show;

    @Before
    public void setUp() {
        Cinema cinema = new Cinema("Lublin", "UMCS");
        cinemaId = cinemaRepository.save(cinema);
        Movie movie = new Movie("Tytul", "typ");
        movieId = movieRepository.save(movie);
        show = new Show(cinemaId, movieId, LocalDateTime.now(), 60, 150.0);
        showId = showRepository.save(show);
    }
    //z jakiegos powodu wyrzuca blad nulla dla pola "static final" w klasie CinemaHall

    @Test
    public void addsShow() {
        showRepository.save(show);
        Show savedShow = showRepository.getById(showId);
        assertThat(savedShow).isEqualTo(show);
    }

    @Test
    public void definesPrice() {
        Double price = show.getBasePrice();

        showService.definePrice(showId, 160.0);
        Show changedShow = showRepository.getById(showId);
        Assert.assertEquals(price, changedShow.getBasePrice());
    }
}
