package umcs.cinemasystem.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.CancellationException;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private MailManager manager;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, MailManager manager) {
        this.reservationRepository = reservationRepository;
        this.manager = manager;
    }

    public void reserve(Reservation reservation) {
        reservation.setStatus(ReservationStatus.WAITING_FOR_PAY);
        CancellationToken token = this.reservationRepository.save(reservation);
        this.manager.sendMail(token, reservation.getEmail());
    }

    @Transactional
    public void cancel(Long id, CancellationToken token) {
        String tokenDB = this.reservationRepository.getTokenById(id).getToken();
        String requestedToken = token.getToken().trim();
        if (tokenDB.equals(requestedToken)) {
            this.reservationRepository.updateByStatus(id, ReservationStatus.CANCELLED);
        } else
            throw new CancellationException();
    }

    public void markAsPaid(Long id) {
        this.reservationRepository.updateByStatus(id, ReservationStatus.PAID);
    }

    public void createAlreadyPaid(Reservation reservation) {
        reservation.setStatus(ReservationStatus.PAID);
        this.reservationRepository.save(reservation);
    }
}
