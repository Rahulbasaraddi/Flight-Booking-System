package Spring_Flight.Flight_Booking_System.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Spring_Flight.Flight_Booking_System.entity.Payment;
import Spring_Flight.Flight_Booking_System.enu.ModeOfTransaction;
import Spring_Flight.Flight_Booking_System.enu.Paymentstatus;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    List<Payment> findByPaymentstatus(Paymentstatus paymentstatus);

    List<Payment> findByModeoftransaction(ModeOfTransaction modeoftransaction);

    Optional<Payment> findByBookingId(Integer bookingId);

    List<Payment> findByAmountGreaterThan(Double amount);
}
