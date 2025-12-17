package Spring_Flight.Flight_Booking_System.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Spring_Flight.Flight_Booking_System.entity.Flight;


public interface Flightrepository extends JpaRepository<Flight, Integer>{
	
	Optional<List<Flight>> findBySourceAndDestination(String source , String destination);

	Optional<List<Flight>> findByAirline(String airline);



	

}