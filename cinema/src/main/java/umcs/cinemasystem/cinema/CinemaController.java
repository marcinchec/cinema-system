package umcs.cinemasystem.cinema;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cinema")
public class CinemaController {

    private CinemaService cinemaService;

    @PostMapping()
    public void add(CinemaDto cinema) {
        cinemaService.add(cinema);
    }
}
