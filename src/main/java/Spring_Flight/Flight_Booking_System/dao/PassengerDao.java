package Spring_Flight.Flight_Booking_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Spring_Flight.Flight_Booking_System.entity.Passenger;
import Spring_Flight.Flight_Booking_System.exception.IdNotFoundException;
import Spring_Flight.Flight_Booking_System.exception.NoRecordFoundexception;
import Spring_Flight.Flight_Booking_System.repository.PassengerRepository;



@Repository
public class PassengerDao {

	@Autowired
	public PassengerRepository passengerRepository;

	public Passenger addPassenger(Passenger p) {
		return passengerRepository.save(p);
	}

	public List<Passenger> getPassenger() {
		return passengerRepository.findAll();
	}

	public Passenger getById(Integer id) {
		Optional<Passenger> opt = passengerRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new IdNotFoundException("Passenger With Id " + id + " is Not Present");
		}
	}

	// PassengerDao
	public List<Passenger> getByContactNor(Long nor) {
	    List<Passenger> passengers = passengerRepository.findByContactnumber(nor);
	    if (passengers.isEmpty()) {
	        throw new NoRecordFoundexception("Passenger with contact " + nor + " is Not present");
	    }
	    return passengers;
	}

	
	
	public List<Passenger> getPassengerByFlight(Integer id) {
		List<Passenger> passengers=passengerRepository.findByBookingFlightId(id);
		if(!passengers.isEmpty()) {
		    return passengers;
		}
		else {
			throw new IdNotFoundException("No Passenger Found For Flight "+id);
		}
	}
	
	public Passenger updatePassenger(Passenger p) {

	    if (p.getId() == null) {
	        throw new IdNotFoundException("Id is required to update Passenger");
	    }

	    Optional<Passenger> opt = passengerRepository.findById(p.getId());

	    if (opt.isPresent()) {
	        return passengerRepository.save(p);
	    } else {
	        throw new IdNotFoundException("Passenger with Id " + p.getId() + " not present in DB, update failed");
	    }
	}

	
}
