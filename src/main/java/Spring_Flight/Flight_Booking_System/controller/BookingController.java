package Spring_Flight.Flight_Booking_System.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Spring_Flight.Flight_Booking_System.dto.ResponseStructure;
import Spring_Flight.Flight_Booking_System.entity.Booking;
import Spring_Flight.Flight_Booking_System.entity.Passenger;
import Spring_Flight.Flight_Booking_System.entity.Payment;
import Spring_Flight.Flight_Booking_System.enu.BookingStatus;
import Spring_Flight.Flight_Booking_System.service.Bookingservice;

@RestController
public class BookingController {
	@Autowired
	private Bookingservice bookingService;

	@PostMapping("/b12")
	public ResponseEntity<ResponseStructure<Booking>> createBooking(@RequestBody Booking booking) {
		return bookingService.createBooking(booking);
	}

	@GetMapping("/b12")
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBooking() {
		return bookingService.getAllBookings();
	}

	@GetMapping("/b12/{id}")
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(@PathVariable Integer id) {
		return bookingService.getBookingById(id);
	}

	@GetMapping("/b12/flight/{id}")
	public ResponseEntity<ResponseStructure<Booking>> getBookingByFlight(@PathVariable Integer id) {
		return bookingService.getBookingByFlight(id);
	}

	@GetMapping("/b12/date/{date}")
	public ResponseEntity<ResponseStructure<List<Booking>>> getBookingByDate(
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

		return bookingService.getBookingByDate(date);
	}

	@GetMapping("/b12/status/{status}")
	public ResponseEntity<ResponseStructure<List<Booking>>> getBookingByStatus(@PathVariable BookingStatus status) {
		return bookingService.getBookingByStatus(status);
	}

	@GetMapping("/b12/{id}/ps12")
	public ResponseEntity<ResponseStructure<List<Passenger>>> getAllPassengersInBooking(@PathVariable Integer id) {
		return bookingService.getAllPassengersInBooking(id);
	}

	@GetMapping("/b12/{bookingId}/pt12")
	public ResponseEntity<ResponseStructure<Payment>> getPaymentDetailsByBooking(@PathVariable Integer bookingId) {
		return bookingService.getPaymentDetailsByBooking(bookingId);
	}

	@DeleteMapping("/b12/{id}")
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(@PathVariable Integer id) {
		return bookingService.deleteBooking(id);
	}

	@PatchMapping("/b12/{bookingId}/status/{status}")
	public ResponseEntity<ResponseStructure<Booking>> updateBookingStatus(@PathVariable Integer bookingId,
			@PathVariable BookingStatus status) {
		return bookingService.updateBookingStatus(bookingId, status);
	}

	@GetMapping("/pagination-sorting")
	public ResponseEntity<ResponseStructure<Page<Booking>>> getBookingWithPaginationAndSorting(
			@RequestParam(defaultValue = "0") int pageNumber,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "price") String sortBy,
			@RequestParam(defaultValue = "asc") String sortDir) {

		return bookingService.getBookingWithPaginationAndSorting(pageNumber, pageSize, sortBy, sortDir);
	}

}
