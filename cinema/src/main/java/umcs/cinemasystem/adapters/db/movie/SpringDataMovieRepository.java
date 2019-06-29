package umcs.cinemasystem.adapters.db.movie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataMovieRepository extends JpaRepository<MovieH2, Long> {
    MovieH2 save(MovieH2 movieH2);

    List<MovieH2> findAll();

    Optional<MovieH2> findById(Long id);
}
