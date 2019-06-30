package umcs.cinemasystem.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcs.cinemasystem.movie.Movie;
import umcs.cinemasystem.movie.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public void add(Movie movie) {
        this.movieService.add(movie);
    }

    @GetMapping("all")
    public List<Movie> getAll() {
        return this.movieService.getAll();
    }
}
