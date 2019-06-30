package umcs.cinemasystem.adapters.db.movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class MovieH2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String type;

    public MovieH2() {
    }

    public MovieH2(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieH2 movieH2 = (MovieH2) o;
        return Objects.equals(id, movieH2.id) &&
                Objects.equals(title, movieH2.title) &&
                Objects.equals(type, movieH2.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, type);
    }
}
