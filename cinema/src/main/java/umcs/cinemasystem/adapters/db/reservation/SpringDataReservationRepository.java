package umcs.cinemasystem.adapters.db.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringDataReservationRepository extends JpaRepository<ReservationH2, Long> {
    @Query("select r.id from ReservationH2 r where r.name = :name and r.surname = :surname")
    Long getId(@Param("name") String name, @Param("surname") String surname);
}
