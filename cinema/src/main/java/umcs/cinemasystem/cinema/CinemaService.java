package umcs.cinemasystem.cinema;


public class CinemaService {

    private CinemaRepository cinemaRepository;

    public void add(CinemaDto cinema) {
        cinemaRepository.put(createCinema(cinema));
    }

    private Cinema createCinema(CinemaDto cinemaDto) {
        return new Cinema(cinemaDto.city, cinemaDto.street);
    }
}
