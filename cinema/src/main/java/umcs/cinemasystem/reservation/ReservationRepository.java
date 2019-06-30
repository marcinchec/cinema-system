package umcs.cinemasystem.reservation;

public interface ReservationRepository {

    CancellationToken save(Reservation reservation);

    CancellationToken getTokenById(Long id);

    void updateByStatus(Long id, ReservationStatus status);

    Long getId(String name, String surname);

    Reservation getById(Long id);
}
