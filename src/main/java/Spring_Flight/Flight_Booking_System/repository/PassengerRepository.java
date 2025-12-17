package Spring_Flight.Flight_Booking_System.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Spring_Flight.Flight_Booking_System.entity.Passenger;



public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

    boolean existsBySeatnumberAndBookingFlightId(Integer seatnumber, Integer flightId);

    Integer countByBookingFlightId(Integer flightId);

    List<Passenger> findByContactnumber(long contactNumber);


    List<Passenger> findByBookingFlightId(Integer id);
}
