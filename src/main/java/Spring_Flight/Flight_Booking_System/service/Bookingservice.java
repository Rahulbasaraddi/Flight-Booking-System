package Spring_Flight.Flight_Booking_System.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Spring_Flight.Flight_Booking_System.dao.BookingDao;
import Spring_Flight.Flight_Booking_System.dto.ResponseStructure;
import Spring_Flight.Flight_Booking_System.entity.Booking;
import Spring_Flight.Flight_Booking_System.entity.Passenger;
import Spring_Flight.Flight_Booking_System.entity.Payment;
import Spring_Flight.Flight_Booking_System.enu.BookingStatus;

@Service
public class Bookingservice {
	@Autowired
	private BookingDao bookingDao;
	
	public ResponseEntity<ResponseStructure<Booking>> createBooking(Booking booking)
	{
		ResponseStructure<Booking> response = new ResponseStructure<Booking>();
		response.setStatusCode(HttpStatus.CREATED.value());
        response.setMessage("Booking Created Successfully");
        response.setData(bookingDao.saveBooking(booking));

        return new ResponseEntity<>(response, HttpStatus.CREATED);

	}
	
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBookings()
	{
		ResponseStructure<List<Booking>> response =new ResponseStructure<List<Booking>>();
		response.setStatusCode(HttpStatus.FOUND.value());
		response.setMessage("All List of Bookings are Fetched ");
		response.setData(bookingDao.getAllBookings());
		
		return new ResponseEntity<>(response,HttpStatus.FOUND);
		
	}
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(Integer id)
	{
		ResponseStructure<Booking> response = new ResponseStructure<Booking>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Record fetched");
		response.setData(bookingDao.getBookingById(id));
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Booking>> getBookingByFlight(Integer id)
	{
		ResponseStructure<Booking> response =new ResponseStructure<Booking>();
		response.setStatusCode(HttpStatus.FOUND.value());
		response.setMessage("Flight is Fetched ");
		response.setData(bookingDao.getBookingById(id));
		
		return new ResponseEntity<>(response,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<List<Booking>>> getBookingByDate(LocalDate date)
	{
		ResponseStructure<List<Booking>> response =new ResponseStructure<List<Booking>>();
		response.setStatusCode(HttpStatus.FOUND.value());
		response.setMessage("Booking is Fetched by date ");
		response.setData(bookingDao.getBookingByDate(date));
		
		return new ResponseEntity<>(response,HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<List<Booking>>> getBookingByStatus(BookingStatus status)
	{
		ResponseStructure<List<Booking>> response =new ResponseStructure<List<Booking>>();
		response.setStatusCode(HttpStatus.FOUND.value());
		response.setMessage("Bookings fetched successfully ");
		response.setData(bookingDao.getBookingByStatus(status));
		
		return new ResponseEntity<>(response,HttpStatus.FOUND);
	}
	
	 public ResponseEntity<ResponseStructure<List<Passenger>>> getAllPassengersInBooking(Integer bookingId) {

	        ResponseStructure<List<Passenger>> response = new ResponseStructure<>();

	        response.setStatusCode(HttpStatus.FOUND.value());
	        response.setMessage("Passengers fetched successfully for booking id: " + bookingId);
	        response.setData(bookingDao.getAllPassengersInBooking(bookingId));

	        return new ResponseEntity<>(response, HttpStatus.FOUND);
	    }
	

	public ResponseEntity<ResponseStructure<Payment>> getPaymentDetailsByBooking(Integer bookingId)
	{
		ResponseStructure<Payment> response = new ResponseStructure<Payment>();
		 response.setStatusCode(HttpStatus.OK.value());
		 response.setMessage("Payment Details fetched for BookingId" + bookingId);
		 response.setData(bookingDao.getPaymentDetailsByBooking(bookingId));
	        return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(Integer id)
	{
		ResponseStructure<Booking> response = new ResponseStructure<Booking>();
		 response.setStatusCode(HttpStatus.OK.value());
		 response.setMessage("Payment Details fetched for BookingId" + id);
		 response.setData(bookingDao.deleteBooking(id));
	        return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Booking>> updateBookingStatus(Integer bookingId, BookingStatus status) {

	    ResponseStructure<Booking> response = new ResponseStructure<>();
	    response.setStatusCode(HttpStatus.OK.value());
	    response.setMessage("Booking status updated successfully for BookingId: " + bookingId);
	    response.setData(bookingDao.updateBookingStatus(bookingId, status));

	    return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Page<Booking>>> getBookingWithPaginationAndSorting(
			int pageNumber, int pageSize, String sortBy, String sortDir) {

		ResponseStructure<Page<Booking>> response = new ResponseStructure<>();
		Page<Booking> bookings = bookingDao.getBookingWithPaginationAndSorting(pageNumber, pageSize, sortBy, sortDir);

		if (bookings.isEmpty()) {
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage("No bookings found");
			response.setData(null);
			return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
		}

		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Bookings retrieved successfully");
		response.setData(bookings);
		return ResponseEntity.ok(response);
}

		 
		 
	}


