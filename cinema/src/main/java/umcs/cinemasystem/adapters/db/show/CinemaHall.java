package umcs.cinemasystem.adapters.db.show;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hall_table")
public class CinemaHall {

    private static final int MAX_ROWS = 20;
    private static final int MAX_SEATS_IN_ROW = 30;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Seats> reservedSeats;

    public CinemaHall() {
        reservedSeats = new ArrayList<>();
    }

    public List<Seats> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<Seats> seats) {
        this.reservedSeats = seats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Integer getSeatsAmount() {
        return MAX_ROWS * MAX_SEATS_IN_ROW;
    }

    public static int getMaxRows() {
        return MAX_ROWS;
    }

    public static int getMaxSeatsInRow() {
        return MAX_SEATS_IN_ROW;
    }
}
