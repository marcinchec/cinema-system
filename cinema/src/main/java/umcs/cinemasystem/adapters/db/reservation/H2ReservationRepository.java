package umcs.cinemasystem.adapters.db.reservation;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import umcs.cinemasystem.adapters.db.show.SpringDataShowRepository;
import umcs.cinemasystem.reservation.CancellationToken;
import umcs.cinemasystem.reservation.Reservation;
import umcs.cinemasystem.reservation.ReservationRepository;
import umcs.cinemasystem.reservation.ReservationStatus;

import javax.persistence.EntityNotFoundException;

import static umcs.cinemasystem.reservation.CancellationToken.of;

@Repository
public class H2ReservationRepository implements ReservationRepository {

    private SpringDataReservationRepository repository;
    private SpringDataShowRepository showRepository;

    @Autowired
    public H2ReservationRepository(SpringDataReservationRepository repository, SpringDataShowRepository showRepository) {
        this.repository = repository;
        this.showRepository = showRepository;
    }

    @Override
    public CancellationToken save(Reservation reservation) {
        ReservationH2 reservationH2 = this.repository.save(mapReservationToEntity(reservation));
        return mapToken(reservationH2.getToken());
    }

    @Override
    public CancellationToken getTokenById(Long id) {
        String token = this.repository.findById(id).orElseThrow(EntityNotFoundException::new).getToken().getToken();
        return of(token);
    }

    @Override
    public void updateByStatus(Long id, ReservationStatus status) {
        ReservationH2 reservation = this.repository.findById(id).orElseThrow(EntityNotFoundException::new);
        reservation.setStatus(status);
        this.repository.save(reservation);
    }

    private ReservationH2 mapReservationToEntity(Reservation reservation) {
        ReservationH2 reservationH2 = new ReservationH2();
        reservationH2.setName(reservation.getName());
        reservationH2.setSurname(reservation.getSurname());
        reservationH2.setEmail(reservation.getEmail());
        reservationH2.setSeats(reservation.getSeats());
        reservationH2.setShow(showRepository.findById(reservation.getShowId()).get());
        reservationH2.setStatus(reservation.getStatus());
        reservationH2.setTicketType(reservation.getTicketType());
        reservationH2.setToken(mapTokenToH2(RandomString.make(10)));
        return reservationH2;
    }

    private Reservation mapEntityToReservation(ReservationH2 reservationH2) {
        Reservation reservation = new Reservation();
        reservation.setName(reservationH2.getName());
        reservation.setSurname(reservationH2.getSurname());
        reservation.setEmail(reservationH2.getEmail());
        reservation.setSeats(reservationH2.getSeats());
        reservation.setShowId(reservationH2.getShow().getId());
        reservation.setTicketType(reservationH2.getTicketType());
        reservation.setStatus(reservationH2.getStatus());
        return reservation;
    }

    private CancellationToken mapToken(CancellationTokenH2 cancellationTokenH2) {
        return of(cancellationTokenH2.getToken());
    }

    private CancellationTokenH2 mapTokenToH2(String cancellationToken) {
        return new CancellationTokenH2(cancellationToken);
    }

}
