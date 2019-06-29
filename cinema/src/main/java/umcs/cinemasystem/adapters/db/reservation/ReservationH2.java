package umcs.cinemasystem.adapters.db.reservation;

import umcs.cinemasystem.adapters.db.show.Seats;
import umcs.cinemasystem.adapters.db.show.ShowH2;
import umcs.cinemasystem.reservation.ReservationStatus;
import umcs.cinemasystem.reservation.TicketType;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class ReservationH2 {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private ShowH2 show;
    private String name;
    private String surname;
    private String email;
    private TicketType ticketType;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Seats> seats;
    private ReservationStatus status;
    @Embedded
    private CancellationTokenH2 token;

    public ReservationH2(ShowH2 show, String name, String surname, String email, TicketType ticketType, List<Seats> seats, ReservationStatus status, CancellationTokenH2 token) {
        this.show = show;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.ticketType = ticketType;
        this.seats = seats;
        this.status = status;
        this.token = token;
    }

    public ReservationH2() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CancellationTokenH2 getToken() {
        return token;
    }

    public void setToken(CancellationTokenH2 token) {
        this.token = token;
    }

    public ShowH2 getShow() {
        return show;
    }

    public void setShow(ShowH2 show) {
        this.show = show;
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
        ReservationH2 that = (ReservationH2) o;
        return id.equals(that.id) &&
                show.equals(that.show) &&
                name.equals(that.name) &&
                surname.equals(that.surname) &&
                email.equals(that.email) &&
                ticketType == that.ticketType &&
                seats.equals(that.seats) &&
                status == that.status &&
                token.equals(that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, show, name, surname, email, ticketType, seats, status, token);
    }
}
