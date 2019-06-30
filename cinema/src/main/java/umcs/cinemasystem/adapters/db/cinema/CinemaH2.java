package umcs.cinemasystem.adapters.db.cinema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class CinemaH2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String street;

    public CinemaH2() {
    }

    public CinemaH2(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaH2 cinemaH2 = (CinemaH2) o;
        return id.equals(cinemaH2.id) &&
                city.equals(cinemaH2.city) &&
                street.equals(cinemaH2.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, street);
    }
}
