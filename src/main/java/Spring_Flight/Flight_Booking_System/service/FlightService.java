package Spring_Flight.Flight_Booking_System.service;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import Spring_Flight.Flight_Booking_System.dao.FlightDao;
import Spring_Flight.Flight_Booking_System.dto.ResponseStructure;
import Spring_Flight.Flight_Booking_System.entity.Flight;
@Service
public class FlightService {
	@Autowired
	private FlightDao flightDao;
	public ResponseEntity<ResponseStructure<Flight>> saveFlight(Flight flight)
	{
	ResponseStructure<Flight> response=new ResponseStructure<Flight>();
	response.setStatusCode(HttpStatus.CREATED.value());
	response.setMessage("Record Saved");
	response.setData(flightDao.saveFlight(flight));
	return new ResponseEntity<ResponseStructure<Flight>>(response,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Flight>>> getAllFlight()
	{
		ResponseStructure<List<Flight>> response=new ResponseStructure<List<Flight>>();
		response.setStatusCode(HttpStatus.FOUND.value());
		response.setMessage("Record fetched");
		response.setData(flightDao.getAllFlight());
		return new ResponseEntity<ResponseStructure<List<Flight>>>(response,HttpStatus.FOUND);
		}
	
	
	public ResponseEntity<ResponseStructure<Flight>> getFlightById(@PathVariable Integer id)
	{
		ResponseStructure<Flight> response = new ResponseStructure<Flight>();
		
	    response.setStatusCode(HttpStatus.OK.value());
	    response.setMessage("Record fetched");
	    response.setData(flightDao.getFlightById(id));
	    return new ResponseEntity<ResponseStructure<Flight>>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Flight>>> getFlightSourceAndDestination(@PathVariable String source ,String destination)
	{
		ResponseStructure<List<Flight>> response =new ResponseStructure<List<Flight>>();
		response.setStatusCode(HttpStatus.FOUND.value());
		response.setMessage("Record fetched");
		response.setData(flightDao.getFlightSourceAndDestination(source, destination));
		return new ResponseEntity<ResponseStructure<List<Flight>>>(response, HttpStatus.FOUND);
		
	}
	
	public ResponseEntity<ResponseStructure<List<Flight>>> getFlightByAirline(@PathVariable String airline)
	{
		ResponseStructure<List<Flight>> response = new ResponseStructure<List<Flight>>();
		response.setStatusCode(HttpStatus.FOUND.value());
		response.setMessage("Airline Found");
		response.setData(flightDao.getFlightByAirline(airline));
		return new ResponseEntity<ResponseStructure<List<Flight>>>(response, HttpStatus.FOUND);
	}
	
	
	
	public ResponseEntity<ResponseStructure<Flight>> updateFlight(Integer id, Flight flight) {
	    ResponseStructure<Flight> response = new ResponseStructure<>();

	  
	    Flight existingFlight = flightDao.getFlightById(id);

	    if (existingFlight == null) {
	        response.setStatusCode(HttpStatus.NOT_FOUND.value());
	        response.setMessage("Flight not found with id: " + id);
	        response.setData(null);
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	    }

	    
	    if (flight.getAirline() != null && !flight.getAirline().isBlank()) {
	        existingFlight.setAirline(flight.getAirline());
	    }
	    if (flight.getSource() != null && !flight.getSource().isBlank()) {
	        existingFlight.setSource(flight.getSource());
	    }
	    if (flight.getDestination() != null && !flight.getDestination().isBlank()) {
	        existingFlight.setDestination(flight.getDestination());
	    }
	    if (flight.getDepartureDateTime() != null) {
	        existingFlight.setDepartureDateTime(flight.getDepartureDateTime());
	    }
	    if (flight.getArrivalDateTime() != null) {
	        existingFlight.setArrivalDateTime(flight.getArrivalDateTime());
	    }
	    if (flight.getTotalSeats() != null) {
	        existingFlight.setTotalSeats(flight.getTotalSeats());
	    }
	    if (flight.getPrice() != null) {
	        existingFlight.setPrice(flight.getPrice());
	    }

	   
	    Flight saved = flightDao.saveFlight(existingFlight);

	    response.setStatusCode(HttpStatus.OK.value());
	    response.setMessage("Flight updated successfully");
	    response.setData(saved);

	    return new ResponseEntity<>(response, HttpStatus.OK);
	}
}