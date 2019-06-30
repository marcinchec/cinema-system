package umcs.cinemasystem.show;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Show {

    private Long cinemaId;
    private Long movieId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startOfShow;
    private Integer durationInMinutes;
    private Double basePrice;

    public Show(Long cinemaId, Long movieId, LocalDateTime start, Integer durationInMinutes, Double basePrice) {
        this.cinemaId = cinemaId;
        this.movieId = movieId;
        this.startOfShow = start;
        this.basePrice = basePrice;
        this.durationInMinutes = durationInMinutes;
    }

    public Show() {
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public LocalDateTime getStartOfShow() {
        return startOfShow;
    }

    public void setStartOfShow(LocalDateTime startOfShow) {
        this.startOfShow = startOfShow;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Integer durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}
