package umcs.cinemasystem.adapters.db.show;

import umcs.cinemasystem.adapters.db.cinema.CinemaH2;
import umcs.cinemasystem.adapters.db.movie.MovieH2;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ShowH2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;
    @OneToOne
    private CinemaH2 cinemaH2;
    @OneToOne
    private MovieH2 movieH2;
    @OneToOne(cascade = CascadeType.ALL)
    private CinemaHall cinemaHall;
    @Embedded
    private Calendar calendar;
    private Double basePrice;

    public ShowH2() {
    }

    public ShowH2(CinemaH2 cinemaH2, MovieH2 movieH2, CinemaHall cinemaHall, Calendar calendar, Double basePrice) {
        this.cinemaH2 = cinemaH2;
        this.movieH2 = movieH2;
        this.cinemaHall = cinemaHall;
        this.calendar = calendar;
        this.basePrice = basePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CinemaH2 getCinemaH2() {
        return cinemaH2;
    }

    public void setCinemaH2(CinemaH2 cinemaH2) {
        this.cinemaH2 = cinemaH2;
    }

    public MovieH2 getMovieH2() {
        return movieH2;
    }

    public void setMovieH2(MovieH2 movieH2) {
        this.movieH2 = movieH2;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowH2 showH2 = (ShowH2) o;
        return id.equals(showH2.id) &&
                cinemaH2.equals(showH2.cinemaH2) &&
                movieH2.equals(showH2.movieH2) &&
                cinemaHall.equals(showH2.cinemaHall) &&
                calendar.equals(showH2.calendar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cinemaH2, movieH2, cinemaHall, calendar);
    }
}
