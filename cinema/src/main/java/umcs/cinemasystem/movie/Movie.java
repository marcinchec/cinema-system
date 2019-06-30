package umcs.cinemasystem.movie;

import java.util.Objects;

public class Movie {
    private String title;
    private String type;

    public Movie(String title, String type) {
        this.title = title;
        this.type = type;
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
        Movie movie = (Movie) o;
        return title.equals(movie.title) &&
                type.equals(movie.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type);
    }
}
