package umcs.cinemasystem.adapters.db.reservation;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class CancellationTokenH2 {
    private String token;

    public CancellationTokenH2(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public CancellationTokenH2() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CancellationTokenH2 that = (CancellationTokenH2) o;
        return token.equals(that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
