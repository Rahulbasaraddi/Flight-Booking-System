package Spring_Flight.Flight_Booking_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Spring_Flight.Flight_Booking_System.dto.ResponseStructure;
import Spring_Flight.Flight_Booking_System.entity.Flight;
import Spring_Flight.Flight_Booking_System.service.FlightService;

@RestController
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@PostMapping("/flight")
	public ResponseEntity<ResponseStructure<Flight>> saveFlight(@RequestBody Flight flight)
	{
		return flightService.saveFlight(flight);
	}
	@GetMapping("/flight")
	public ResponseEntity<ResponseStructure<List<Flight>>> getAllFlight()
	{
		return flightService.getAllFlight();
	}
	
	@GetMapping("/flight/{id}")
	public ResponseEntity<ResponseStructure<Flight>> getFlightById(@PathVariable Integer id)
	{
		return flightService.getFlightById(id);
	}
	
	@GetMapping("/flight/{source}/{destination}")
	public ResponseEntity<ResponseStructure<List<Flight>>> getFlightSourecAndDestination(@PathVariable String source , @PathVariable String destination)
	{
		return flightService.getFlightSourceAndDestination(source, destination);
	}
	
	@GetMapping("/flight/airline/{airline}")
	public ResponseEntity<ResponseStructure<List<Flight>>> getFlightByAirline(@PathVariable String airline)
	{
		return flightService.getFlightByAirline(airline);
	}
	
	
	@PatchMapping("/flight/update/{id}")
    public ResponseEntity<ResponseStructure<Flight>> updateFlight( @PathVariable Integer id, @RequestBody Flight flight) {
        return flightService.updateFlight(id, flight);
    }

}
