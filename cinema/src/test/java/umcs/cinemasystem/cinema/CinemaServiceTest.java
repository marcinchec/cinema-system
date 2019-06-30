package umcs.cinemasystem.cinema;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CinemaServiceTest {

    @Autowired
    private CinemaRepository cinemaRepository;


    @Test
    public void addsCinema() {
        Cinema cinema = new Cinema("Lublin", "umcs");

        cinemaRepository.save(cinema);
        List<Cinema> foundCinema = cinemaRepository.getAll();

        assertThat(cinema.getCity()).isEqualTo(getSearchingCinema(foundCinema, cinema).getCity());
    }

    private Cinema getSearchingCinema(List<Cinema> cinemas, Cinema searched) {
        for (Cinema c : cinemas) {
            if (c.equals(searched))
                return c;
        }
        return null;
    }
}
