package umcs.cinemasystem.adapters.db.show;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataShowRepository extends JpaRepository<ShowH2, Long> {
    ShowH2 save(ShowH2 showH2);

    Optional<ShowH2> findById(Long id);

}
