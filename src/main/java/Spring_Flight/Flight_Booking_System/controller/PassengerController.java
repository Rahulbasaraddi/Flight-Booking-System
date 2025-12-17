package Spring_Flight.Flight_Booking_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Spring_Flight.Flight_Booking_System.dto.ResponseStructure;
import Spring_Flight.Flight_Booking_System.entity.Passenger;
import Spring_Flight.Flight_Booking_System.service.PassengerService;


@RestController
@RequestMapping("/p12")
public class PassengerController {

	@Autowired
	public PassengerService passengerService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Passenger>> addPassenger(@RequestBody Passenger p) {
		return passengerService.addPasssenger(p);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Passenger>>> getPassengers() {
		return passengerService.getPassengers();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ResponseStructure<Passenger>> getPassengerById(@PathVariable Integer id) {
		return passengerService.getPassengerById(id);
	}
	
	@GetMapping("contact/{nor}")
	public ResponseEntity<ResponseStructure<List<Passenger>>> getPassengerByContact(@PathVariable Long nor) {
	    return passengerService.getPassengerByContact(nor);
	}

	
	@GetMapping("/flight/{id}")
	public ResponseEntity<ResponseStructure<List<Passenger>>> getPassengerByFlight(@PathVariable Integer id) {
		return passengerService.getPassengerByFlight(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Passenger>> updatePassenger(@RequestBody Passenger p) {
	    return passengerService.updatePassenger(p);
	}

}
