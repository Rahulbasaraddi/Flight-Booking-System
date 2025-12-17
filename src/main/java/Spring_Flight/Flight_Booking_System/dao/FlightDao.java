package Spring_Flight.Flight_Booking_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Spring_Flight.Flight_Booking_System.entity.Flight;
import Spring_Flight.Flight_Booking_System.exception.IdNotFoundException;
import Spring_Flight.Flight_Booking_System.exception.NoRecordFoundexception;
import Spring_Flight.Flight_Booking_System.repository.Flightrepository;

@Repository
public class FlightDao {

	@Autowired
	public Flightrepository flightRepository;

	public Flight saveFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	public List<Flight> getAllFlight() {
		return flightRepository.findAll();
	}

	public Flight getFlightById(Integer id) {
		Optional<Flight> op = flightRepository.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new IdNotFoundException("Flight with this " + id + " not exist in this database");
		}
	}

	public List<Flight> getFlightSourceAndDestination(String source, String destination) {
		Optional<List<Flight>> optional = flightRepository.findBySourceAndDestination(source, destination);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new NoRecordFoundexception("No flight from " + source + " to " + destination);
		}
	}

	public List<Flight> getFlightByAirline(String airline) {
		Optional<List<Flight>> op = flightRepository.findByAirline(airline);

		if (op.isPresent()) {
			return op.get();
		} else {
			throw new NoRecordFoundexception("No airline found on this name" + airline);
		}

	}

	public Flight updateFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	public Flight deleteFlight(Integer id) {
		Flight flight = getFlightById(id);
		flightRepository.delete(flight);
		return flight;
	}
}
