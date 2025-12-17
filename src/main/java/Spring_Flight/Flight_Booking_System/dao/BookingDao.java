package Spring_Flight.Flight_Booking_System.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import Spring_Flight.Flight_Booking_System.entity.Booking;
import Spring_Flight.Flight_Booking_System.entity.Flight;
import Spring_Flight.Flight_Booking_System.entity.Passenger;
import Spring_Flight.Flight_Booking_System.entity.Payment;
import Spring_Flight.Flight_Booking_System.enu.BookingStatus;
import Spring_Flight.Flight_Booking_System.enu.ModeOfTransaction;
import Spring_Flight.Flight_Booking_System.enu.Paymentstatus;
import Spring_Flight.Flight_Booking_System.exception.IdNotFoundException;
import Spring_Flight.Flight_Booking_System.exception.NoRecordFoundexception;
import Spring_Flight.Flight_Booking_System.repository.BookingRepository;
import Spring_Flight.Flight_Booking_System.repository.Flightrepository;

@Repository
public class BookingDao {
	
	@Autowired
	public BookingRepository bookingRepository;
	
	@Autowired
	public Flightrepository flightRepository;
	
	public Booking saveBooking(Booking booking) {

	    Integer flightId = booking.getFlight().getId();
	    Optional<Flight> op = flightRepository.findById(flightId);

	    if (op.isEmpty()) {
	        throw new IdNotFoundException("Flight with id " + flightId + " not found");
	    }

	    Flight flight = op.get();

	    List<Passenger> passengers = booking.getPassenger();
	    if (passengers == null || passengers.isEmpty()) {
	        throw new NoRecordFoundexception("At least one passenger is required for booking");
	    }

	    int passengerCount = passengers.size();
	    double pricePerSeat = flight.getPrice();
	    double totalAmount = pricePerSeat * passengerCount;

	    double discountPercentage = 0.0;
	    if (passengerCount == 1) {
	        discountPercentage = 10.0;
	    } else if (passengerCount == 2) {
	        discountPercentage = 5.0;
	    } else if (passengerCount >= 3) {
	        discountPercentage = 15.0;
	    }

	    double discountAmount = totalAmount * (discountPercentage / 100.0);
	    double finalAmount = totalAmount - discountAmount;

	    Payment payment = booking.getPayment();
	    if (payment == null) {
	        payment = new Payment();
	    }

	    payment.setAmount(finalAmount);
	    if (payment.getModeoftransaction() == null) {
	        payment.setModeoftransaction(ModeOfTransaction.UPI); // or CARD, NET_BANKING, etc.
	    }
	    if (payment.getPaymentstatus() == null) {
	        payment.setPaymentstatus(Paymentstatus.SUCCESS); // or PENDING
	    }
	    payment.setBooking(booking);
	    booking.setPayment(payment);

	    booking.setFlight(flight);
	    for (Passenger p : passengers) {
	        p.setBooking(booking);
	    }

	    return bookingRepository.save(booking);
	}
	
	public List<Booking> getAllBookings() {
	    List<Booking> bookings = bookingRepository.findAll();
	    
	    if (bookings.isEmpty()) {
	        throw new NoRecordFoundexception("No bookings found in the database");
	    }
	    
	    return bookings;
	}
	
	public Booking getBookingById(Integer id)
	{
		Optional<Booking> op = bookingRepository.findById(id);
		if(op.isPresent())
		{
			return op.get();
		}
		else
		{
			throw new IdNotFoundException("Booking with this "+id+" not exist in this database");
		}
	}
		
		public List<Booking> getBookingByFlight(Integer id) {

		    Optional<Flight> flightOpt = flightRepository.findById(id);

		    if (flightOpt.isEmpty()) {
		        throw new IdNotFoundException("Flight with this " + id + " not exist in this database");
		    }

		    List<Booking> bookings = bookingRepository.findByFlightId(id);

		    if (bookings.isEmpty()) {
		        throw new NoRecordFoundexception("No bookings available for this flight id: " + id);
		    }

		    return bookings;
		}
		
		

		public List<Booking> getBookingByDate(LocalDate date) {

		    LocalDateTime startOfDay = date.atStartOfDay();
		    LocalDateTime endOfDay = date.atTime(23, 59, 59);

		    List<Booking> bookings = bookingRepository.findByBookingDateBetween(startOfDay, endOfDay);

		    if (bookings.isEmpty()) {
		        throw new NoRecordFoundexception("No bookings found on date: " + date);
		    }

		    return bookings;
		    
		}
		 public List<Booking> getBookingByStatus(BookingStatus status)
		    {
		    	List<Booking> bookings = bookingRepository.findByBookingStatus(status);
		    	
		    	if (bookings.isEmpty()) {
			        throw new NoRecordFoundexception("No bookings found with status: " + status);
			    }

			    return bookings;
		    }
		

		 public List<Passenger> getAllPassengersInBooking(Integer bookingId) {

			 Optional<Booking> op = bookingRepository.findById(bookingId);

			 if (op.isEmpty()) {
				 throw new IdNotFoundException("Booking with id " + bookingId + " not exist in this database");
			 	}

			 Booking booking = op.get();
			 List<Passenger> passengers = booking.getPassenger();

			 if (passengers == null || passengers.isEmpty()) {
				 throw new NoRecordFoundexception("No passengers found for booking id " + bookingId);
			 }

			 return passengers;
		 }
	


	public Payment getPaymentDetailsByBooking(Integer bookingId) {

    // 1. Find booking by id
		Optional<Booking> op = bookingRepository.findById(bookingId);
		if (op.isEmpty()) {
			throw new IdNotFoundException("Booking with id " + bookingId + " not exist in this database");
    }

		Booking booking = op.get();

    // 2. Get payment from booking
		Payment payment = booking.getPayment();

		if (payment == null) {
			throw new NoRecordFoundexception("No payment found for booking id " + bookingId);
		}

		return payment;
}
	public Booking  deleteBooking(Integer id)
	{
		Optional<Booking> op =  bookingRepository.findById(id);
		if(op.isPresent())
		{
			Booking booking = op.get();
			bookingRepository.delete(booking);
			return booking;
		}
		else
		{
			throw new IdNotFoundException("Booking with this " + id + " not exist in this database");
			
		}
		
	}
	
	public Booking updateBookingStatus(Integer bookingId, BookingStatus status) {

	    Optional<Booking> op = bookingRepository.findById(bookingId);

	    if (op.isEmpty()) {
	        throw new IdNotFoundException("Booking with id " + bookingId + " not found");
	    }

	    Booking booking = op.get();
	    booking.setBookingStatus(status);

	    return bookingRepository.save(booking);
	}
	
	public Page<Booking> getBookingWithPaginationAndSorting(int pageNumber, int pageSize, String sortBy,
			String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending()
	            : Sort.by(sortBy).descending();
		
		return bookingRepository.findAll(PageRequest.of(pageNumber, pageSize,sort));
	}

	}





	
	



