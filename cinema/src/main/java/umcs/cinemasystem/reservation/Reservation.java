package umcs.cinemasystem.reservation;

import umcs.cinemasystem.adapters.db.show.Seats;

import java.util.List;
import java.util.Objects;

public class Reservation {
    private Long showId;
    private String name;
    private String surname;
    private String email;
    private TicketType ticketType;
    private List<Seats> seats;
    private ReservationStatus status;

    public Reservation(Long showId, String name, String surname, String email, TicketType ticketType, List<Seats> seats, ReservationStatus status) {
        this.showId = showId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.ticketType = ticketType;
        this.seats = seats;
        this.status = status;
    }

    public Reservation() {
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public List<Seats> getSeats() {
        return seats;
    }

    public void setSeats(List<Seats> seats) {
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return showId.equals(that.showId) &&
                name.equals(that.name) &&
                surname.equals(that.surname) &&
                email.equals(that.email) &&
                ticketType == that.ticketType &&
                seats.equals(that.seats) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(showId, name, surname, email, ticketType, seats, status);
    }
}
