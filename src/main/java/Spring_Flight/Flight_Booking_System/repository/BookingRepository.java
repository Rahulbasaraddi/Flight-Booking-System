package Spring_Flight.Flight_Booking_System.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Spring_Flight.Flight_Booking_System.entity.Booking;
import Spring_Flight.Flight_Booking_System.entity.Flight;
import Spring_Flight.Flight_Booking_System.enu.BookingStatus;

public interface BookingRepository extends JpaRepository<Booking, Integer> 
{
	List<Booking> findByFlightId(Integer flightId);

	List<Booking> findByBookingDateBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);

	List<Booking> findByBookingStatus(BookingStatus status);
	

}
