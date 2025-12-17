package Spring_Flight.Flight_Booking_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Spring_Flight.Flight_Booking_System.dto.ResponseStructure;
import Spring_Flight.Flight_Booking_System.enu.ModeOfTransaction;
import Spring_Flight.Flight_Booking_System.enu.Paymentstatus;
import Spring_Flight.Flight_Booking_System.entity.Payment;
import Spring_Flight.Flight_Booking_System.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/{bookingId}")
    public ResponseEntity<ResponseStructure<Payment>> recordPayment(@PathVariable Integer bookingId,@RequestBody Payment payment) {
        return paymentService.recordPayment(bookingId, payment);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Payment>>> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Payment>> getPaymentById(@PathVariable Integer id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ResponseStructure<List<Payment>>> getPaymentsByStatus(
            @PathVariable Paymentstatus status) {
        return paymentService.getPaymentsByStatus(status);
    }

    @GetMapping("/mode/{mode}")
    public ResponseEntity<ResponseStructure<List<Payment>>> getPaymentsByMode(
            @PathVariable ModeOfTransaction mode) {
        return paymentService.getPaymentsByMode(mode);
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<ResponseStructure<Payment>> getPaymentByBooking(
            @PathVariable Integer bookingId) {
        return paymentService.getPaymentByBooking(bookingId);
    }

    @PatchMapping("/{paymentId}/status/{status}")
    public ResponseEntity<ResponseStructure<Payment>> updatePaymentStatus(
            @PathVariable Integer paymentId,
            @PathVariable Paymentstatus status) {
        return paymentService.updatePaymentStatus(paymentId, status);
    }

    @GetMapping("/amountgreaterthan/{amount}")
    public ResponseEntity<ResponseStructure<List<Payment>>> getPaymentsWithAmountGreaterThan(
            @PathVariable Double amount) {
        return paymentService.getPaymentsWithAmountGreaterThan(amount);
    }
}
