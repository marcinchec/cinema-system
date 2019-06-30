package umcs.cinemasystem.reservation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import umcs.cinemasystem.adapters.db.show.Seats;
import umcs.cinemasystem.cinema.Cinema;
import umcs.cinemasystem.cinema.CinemaRepository;
import umcs.cinemasystem.movie.Movie;
import umcs.cinemasystem.movie.MovieRepository;
import umcs.cinemasystem.show.Show;
import umcs.cinemasystem.show.ShowRepository;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReservationServiceTest {

    @Autowired
    private ReservationService service;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private MovieRepository movieRepository;
    private Long cinemaId;
    private Long movieId;
    private Long showId;
    private Reservation reservation;

    @Before
    public void setUp() {
        Cinema cinema = new Cinema("Lublin", "UMCS");
        cinemaId = cinemaRepository.save(cinema);
        Movie movie = new Movie("Tytul", "typ");
        movieId = movieRepository.save(movie);
        Show show = new Show(cinemaId, movieId, LocalDateTime.now(), 60, 150.0);
        showId = showRepository.save(show);
        reservation = new Reservation();
        reservation.setShowId(showId);
        reservation.setName("jan");
        reservation.setSurname("jan");
        reservation.setStatus(ReservationStatus.WAITING_FOR_PAY);
        reservation.setTicketType(TicketType.NORMAL);
        reservation.setSeats(Arrays.asList(new Seats(10, 11)));
    }

    //z jakiegos powodu wyrzuca blad nulla dla pola "static final" w klasie CinemaHall

    @Test(expected = CancellationTokenException.class)
    public void throwsExceptionIfWrongToken() {
        service.reserve(reservation);
        Long id = reservationRepository.getId(reservation.getName(), reservation.getSurname());
        service.cancel(id, CancellationToken.of("sadasdasd"));
    }

    @Test
    public void reserves() {
        service.reserve(reservation);
        Long id = reservationRepository.getId(reservation.getName(), reservation.getSurname());
        Reservation savedReservation = reservationRepository.getById(id);

        assertThat(savedReservation.getStatus()).isEqualByComparingTo(ReservationStatus.WAITING_FOR_PAY);
    }

    @Test
    public void cancelsReservation() {
        CancellationToken token = reservationRepository.save(reservation);
        Long id = reservationRepository.getId(reservation.getName(), reservation.getSurname());

        service.cancel(id, token);

        Reservation reservationCancelled = reservationRepository.getById(id);
        assertThat(reservationCancelled.getStatus()).isEqualByComparingTo(ReservationStatus.CANCELLED);
    }
}
