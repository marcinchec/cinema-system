package umcs.cinemasystem.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umcs.cinemasystem.adapters.db.show.Seats;
import umcs.cinemasystem.show.Show;
import umcs.cinemasystem.show.ShowService;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    private ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }


    @PostMapping
    public void add(Show show) {
        this.showService.add(show);
    }

    @PutMapping("{id}")
    public void definePrice(@PathVariable Long id, Double price) {
        this.showService.definePrice(id, price);
    }

    @GetMapping("{showId}")
    public List<Seats> showFreeSeats(@PathVariable Long showId) {
        return this.showService.showFreeSeats(showId);
    }
}
