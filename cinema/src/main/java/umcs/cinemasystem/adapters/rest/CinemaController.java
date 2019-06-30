package umcs.cinemasystem.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcs.cinemasystem.cinema.Cinema;
import umcs.cinemasystem.cinema.CinemaService;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    private CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @PostMapping()
    public void add(Cinema cinema) {
        cinemaService.add(cinema);
    }

    @GetMapping("all")
    public List<Cinema> getAll() {
        return cinemaService.getAll();
    }
}
