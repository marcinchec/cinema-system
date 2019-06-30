package umcs.cinemasystem.adapters.mail_manager;

import org.springframework.stereotype.Component;
import umcs.cinemasystem.reservation.CancellationToken;
import umcs.cinemasystem.reservation.MailManager;

@Component
public class CustomMailManager implements MailManager {
    @Override
    public void sendMail(CancellationToken token, String email) {
        System.out.print("Mail has been sent to: " + email + " with token " + token.getToken());
    }
}
