package Spring_Flight.Flight_Booking_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Spring_Flight.Flight_Booking_System.entity.Booking;
import Spring_Flight.Flight_Booking_System.entity.Payment;
import Spring_Flight.Flight_Booking_System.enu.ModeOfTransaction;
import Spring_Flight.Flight_Booking_System.enu.Paymentstatus;
import Spring_Flight.Flight_Booking_System.exception.IdNotFoundException;
import Spring_Flight.Flight_Booking_System.exception.NoRecordFoundexception;
import Spring_Flight.Flight_Booking_System.repository.BookingRepository;
import Spring_Flight.Flight_Booking_System.repository.PaymentRepository;

@Repository
public class PaymentDao {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Payment recordPayment(Payment payment, Integer bookingId) {

        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isEmpty()) {
            throw new IdNotFoundException("Booking with id " + bookingId + " not found");
        }

        Booking booking = bookingOpt.get();

        payment.setBooking(booking);
        booking.setPayment(payment);

        if (payment.getPaymentstatus() == null) {
            payment.setPaymentstatus(Paymentstatus.PENDING);
        }

        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        List<Payment> list = paymentRepository.findAll();
        if (list.isEmpty()) {
            throw new NoRecordFoundexception("No payments found in database");
        }
        return list;
    }

    public Payment getPaymentById(Integer id) {
        Optional<Payment> opt = paymentRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new IdNotFoundException("Payment with id " + id + " not found");
        }
    }

    public List<Payment> getPaymentsByStatus(Paymentstatus status) {
        List<Payment> list = paymentRepository.findByPaymentstatus(status);
        if (list.isEmpty()) {
            throw new NoRecordFoundexception("No payments found with status " + status);
        }
        return list;
    }

    public List<Payment> getPaymentsByModeOfTransaction(ModeOfTransaction mode) {
        List<Payment> list = paymentRepository.findByModeoftransaction(mode);
        if (list.isEmpty()) {
            throw new NoRecordFoundexception("No payments found with mode " + mode);
        }
        return list;
    }

    public Payment getPaymentByBooking(Integer bookingId) {

        Optional<Payment> opt = paymentRepository.findByBookingId(bookingId);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new NoRecordFoundexception("No payment found for booking id " + bookingId);
        }
    }

    public Payment updatePaymentStatus(Integer paymentId, Paymentstatus newStatus) {

        Optional<Payment> opt = paymentRepository.findById(paymentId);
        if (opt.isEmpty()) {
            throw new IdNotFoundException("Payment with id " + paymentId + " not found, cannot update status");
        }

        Payment payment = opt.get();
        payment.setPaymentstatus(newStatus);

        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymentsWithAmountGreaterThan(Double amount) {

        List<Payment> list = paymentRepository.findByAmountGreaterThan(amount);
        if (list.isEmpty()) {
            throw new NoRecordFoundexception("No payments found with amount greater than " + amount);
        }
        return list;
    }
}
