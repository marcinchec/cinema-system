package umcs.cinemasystem.reservation;

import java.util.Objects;

public class CancellationToken {
    private String token;

    public CancellationToken() {
    }

    private CancellationToken(String token) {
        this.token = token;
    }

    public static CancellationToken of(String token) {
        return new CancellationToken(token);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CancellationToken that = (CancellationToken) o;
        return token.equals(that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
