package umcs.cinemasystem.show;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umcs.cinemasystem.adapters.db.show.CinemaHall;
import umcs.cinemasystem.adapters.db.show.Seats;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    private ShowRepository showRepository;

    @Autowired
    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public void add(Show show) {
        this.showRepository.save(show);
    }

    public void definePrice(Long id, Double price) {
        Show show = this.showRepository.getById(id);
        show.setBasePrice(price);
        this.showRepository.update(show, id);
    }

    public List<Seats> showFreeSeats(Long showId) {
        CinemaHall cinemaHall = showRepository.getFreeSeats(showId);
        List<Seats> freeSeats = new ArrayList<>();
        for (int i = 0; i < CinemaHall.getMaxRows(); i++) {
            for (int j = 0; j < CinemaHall.getMaxSeatsInRow(); j++) {
                freeSeats.add(new Seats(i, j));
            }
        }
        freeSeats.removeAll(cinemaHall.getReservedSeats());
        return freeSeats;
    }
}
