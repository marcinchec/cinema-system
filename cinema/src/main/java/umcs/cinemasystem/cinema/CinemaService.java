package umcs.cinemasystem.cinema;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    private CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public void add(Cinema cinema) {
        cinemaRepository.save(cinema);
    }

    public List<Cinema> getAll() {
        return cinemaRepository.getAll();
    }
}
