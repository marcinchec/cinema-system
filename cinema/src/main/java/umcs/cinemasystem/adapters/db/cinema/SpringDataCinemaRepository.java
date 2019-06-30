package umcs.cinemasystem.adapters.db.cinema;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataCinemaRepository extends JpaRepository<CinemaH2, Long> {
    CinemaH2 save(CinemaH2 cinema);

    List<CinemaH2> findAll();

    Optional<CinemaH2> findById(Long id);
}
