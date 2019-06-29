package umcs.cinemasystem.adapters.db.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataReservationRepository extends JpaRepository<ReservationH2, Long> {
}
