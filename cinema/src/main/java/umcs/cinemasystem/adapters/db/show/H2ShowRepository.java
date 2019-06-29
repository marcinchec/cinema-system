package umcs.cinemasystem.adapters.db.show;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import umcs.cinemasystem.adapters.db.cinema.CinemaH2;
import umcs.cinemasystem.adapters.db.cinema.SpringDataCinemaRepository;
import umcs.cinemasystem.adapters.db.movie.MovieH2;
import umcs.cinemasystem.adapters.db.movie.SpringDataMovieRepository;
import umcs.cinemasystem.show.Show;
import umcs.cinemasystem.show.ShowRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Repository
public class H2ShowRepository implements ShowRepository {

    private SpringDataShowRepository repository;
    private SpringDataCinemaRepository cinemaRepository;
    private SpringDataMovieRepository movieRepository;

    @Autowired
    public H2ShowRepository(SpringDataShowRepository repository, SpringDataCinemaRepository cinemaRepository, SpringDataMovieRepository movieRepository) {
        this.repository = repository;
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public void save(Show show) {
        this.repository.save(mapShowToEntity(show));
    }

    @Override
    public void update(Show show, Long id) {
        this.repository.save(updateEntity(show, id));
    }

    @Override
    public Show getById(Long id) {
        ShowH2 showH2 = this.repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapEntityToShow(showH2);
    }


    @Override
    public CinemaHall getFreeSeats(Long showId) {
        ShowH2 showH2 = repository.findById(showId).orElseThrow(EntityNotFoundException::new);
        return showH2.getCinemaHall();
    }

    public ShowH2 mapShowToEntity(Show show) {
        CinemaH2 cinema = cinemaRepository.findById(show.getCinemaId()).orElseThrow(EntityNotFoundException::new);
        MovieH2 movie = movieRepository.findById(show.getMovieId()).orElseThrow(EntityNotFoundException::new);
        Calendar calendar = new Calendar(show.getStartOfShow(), show.getStartOfShow().plusMinutes(show.getDurationInMinutes()));
        return new ShowH2(cinema, movie, new CinemaHall(), calendar, show.getBasePrice());
    }

    public Show mapEntityToShow(ShowH2 showH2) {
        Long cinemaId = showH2.getCinemaH2().getId();
        Long movieId = showH2.getMovieH2().getId();
        LocalDateTime startOfShow = showH2.getCalendar().getStart();
        LocalDateTime endOfShow = showH2.getCalendar().getEnd();
        Integer minutes = Math.toIntExact(ChronoUnit.MINUTES.between(startOfShow, endOfShow));
        Double basePrice = showH2.getBasePrice();
        return new Show(cinemaId, movieId, startOfShow, minutes, basePrice);
    }

    private ShowH2 updateEntity(Show show, Long id) {
        ShowH2 showH2 = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        showH2.setBasePrice(show.getBasePrice());
        return showH2;
    }
}
