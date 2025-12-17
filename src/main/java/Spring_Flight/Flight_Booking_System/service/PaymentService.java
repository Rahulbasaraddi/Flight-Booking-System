package Spring_Flight.Flight_Booking_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Spring_Flight.Flight_Booking_System.dao.PaymentDao;
import Spring_Flight.Flight_Booking_System.dto.ResponseStructure;
import Spring_Flight.Flight_Booking_System.enu.ModeOfTransaction;
import Spring_Flight.Flight_Booking_System.enu.Paymentstatus;
import Spring_Flight.Flight_Booking_System.entity.Payment;

@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public ResponseEntity<ResponseStructure<Payment>> recordPayment(Integer bookingId, Payment payment) {
        ResponseStructure<Payment> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setMessage("Payment recorded successfully for bookingId " + bookingId);
        response.setData(paymentDao.recordPayment(payment, bookingId));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<List<Payment>>> getAllPayments() {
        ResponseStructure<List<Payment>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.FOUND.value());
        response.setMessage("All payment records fetched successfully");
        response.setData(paymentDao.getAllPayments());
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    public ResponseEntity<ResponseStructure<Payment>> getPaymentById(Integer id) {
        ResponseStructure<Payment> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.FOUND.value());
        response.setMessage("Payment fetched successfully for id " + id);
        response.setData(paymentDao.getPaymentById(id));
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    public ResponseEntity<ResponseStructure<List<Payment>>> getPaymentsByStatus(Paymentstatus status) {
        ResponseStructure<List<Payment>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.FOUND.value());
        response.setMessage("Payments fetched successfully with status " + status);
        response.setData(paymentDao.getPaymentsByStatus(status));
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    public ResponseEntity<ResponseStructure<List<Payment>>> getPaymentsByMode(ModeOfTransaction mode) {
        ResponseStructure<List<Payment>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.FOUND.value());
        response.setMessage("Payments fetched successfully with mode " + mode);
        response.setData(paymentDao.getPaymentsByModeOfTransaction(mode));
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    public ResponseEntity<ResponseStructure<Payment>> getPaymentByBooking(Integer bookingId) {
        ResponseStructure<Payment> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.FOUND.value());
        response.setMessage("Payment fetched successfully for bookingId " + bookingId);
        response.setData(paymentDao.getPaymentByBooking(bookingId));
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    public ResponseEntity<ResponseStructure<Payment>> updatePaymentStatus(Integer paymentId, Paymentstatus status) {
        ResponseStructure<Payment> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Payment status updated successfully for paymentId " + paymentId);
        response.setData(paymentDao.updatePaymentStatus(paymentId, status));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<Payment>>> getPaymentsWithAmountGreaterThan(Double amount) {
        ResponseStructure<List<Payment>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.FOUND.value());
        response.setMessage("Payments fetched with amount greater than " + amount);
        response.setData(paymentDao.getPaymentsWithAmountGreaterThan(amount));
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
