package umcs.cinemasystem.cinema;

import java.util.Objects;

public class Cinema {
    private String city;
    private String street;

    public Cinema(String city, String street) {
        this.city = city;
        this.street = street;
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
        Cinema cinema = (Cinema) o;
        return city.equals(cinema.city) &&
                street.equals(cinema.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street);
    }
}
