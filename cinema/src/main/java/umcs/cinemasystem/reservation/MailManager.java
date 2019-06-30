package umcs.cinemasystem.reservation;

public interface MailManager {
    void sendMail(CancellationToken token, String email);
}
