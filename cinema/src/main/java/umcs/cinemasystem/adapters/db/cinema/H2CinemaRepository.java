package umcs.cinemasystem.adapters.db.cinema;

import org.springframework.stereotype.Repository;
import umcs.cinemasystem.cinema.Cinema;
import umcs.cinemasystem.cinema.CinemaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class H2CinemaRepository implements CinemaRepository {

    private SpringDataCinemaRepository repository;

    public H2CinemaRepository(SpringDataCinemaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Cinema cinema) {
        this.repository.save(mapCinemaToEntity(cinema));
    }

    @Override
    public List<Cinema> getAll() {
        return this.repository.findAll()
                .stream()
                .map(this::mapEntityToCinema)
                .collect(Collectors.toList());
    }

    private CinemaH2 mapCinemaToEntity(Cinema cinema) {
        return new CinemaH2(cinema.getCity(), cinema.getStreet());
    }

    private Cinema mapEntityToCinema(CinemaH2 cinemaH2) {
        return new Cinema(cinemaH2.getCity(), cinemaH2.getStreet());
    }
}
