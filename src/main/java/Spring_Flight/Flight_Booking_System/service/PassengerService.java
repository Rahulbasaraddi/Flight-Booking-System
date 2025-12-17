package Spring_Flight.Flight_Booking_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Spring_Flight.Flight_Booking_System.dao.PassengerDao;
import Spring_Flight.Flight_Booking_System.dto.ResponseStructure;
import Spring_Flight.Flight_Booking_System.entity.Passenger;


@Service
public class PassengerService {
     @Autowired
	public PassengerDao passengerDao;
     
     public ResponseEntity<ResponseStructure<Passenger>> addPasssenger(Passenger f){
  	   ResponseStructure<Passenger> response=new ResponseStructure<Passenger>();
  	   response.setStatusCode(HttpStatus.CREATED.value());
  	   response.setMessage("Passenger Details Saved Successfully");
  	   response.setData(passengerDao.addPassenger(f));
  	   return new ResponseEntity<ResponseStructure<Passenger>>(response,HttpStatus.CREATED);
     }
     
     public ResponseEntity<ResponseStructure<List<Passenger>>> getPassengers(){
    	   ResponseStructure<List<Passenger>> response=new ResponseStructure<List<Passenger>>();
    	   response.setStatusCode(HttpStatus.FOUND.value());
    	   response.setMessage("Passenger Details Accessed Successfully");
    	   response.setData(passengerDao.getPassenger());
    	   return new ResponseEntity<ResponseStructure<List<Passenger>>>(response,HttpStatus.FOUND);
       }
     
     public ResponseEntity<ResponseStructure<Passenger>> getPassengerById(Integer id){
  	   ResponseStructure<Passenger> response=new ResponseStructure<Passenger>();
  	   response.setStatusCode(HttpStatus.FOUND.value());
  	   response.setMessage("Passenger Details Accessed Successfully");
  	   response.setData(passengerDao.getById(id));
  	   return new ResponseEntity<ResponseStructure<Passenger>>(response,HttpStatus.FOUND);
     }
     
     public ResponseEntity<ResponseStructure<List<Passenger>>> getPassengerByContact(Long no){
         ResponseStructure<List<Passenger>> response = new ResponseStructure<>();
         response.setStatusCode(HttpStatus.FOUND.value());
         response.setMessage("Passenger Details Accessed Successfully By Contact Number");
         response.setData(passengerDao.getByContactNor(no));
         return new ResponseEntity<>(response, HttpStatus.FOUND);
     }

     
     public ResponseEntity<ResponseStructure<List<Passenger>>> getPassengerByFlight(Integer id){
  	   ResponseStructure<List<Passenger>> response=new ResponseStructure<List<Passenger>>();
  	   response.setStatusCode(HttpStatus.FOUND.value());
  	   response.setMessage("Passenger Details Accessed Successfully By Flight");
  	   response.setData(passengerDao.getPassengerByFlight(id));
  	   return new ResponseEntity<ResponseStructure<List<Passenger>>>(response,HttpStatus.FOUND);
     }
     
     public ResponseEntity<ResponseStructure<Passenger>> updatePassenger(Passenger p){
    	    ResponseStructure<Passenger> response = new ResponseStructure<Passenger>();
    	    response.setStatusCode(HttpStatus.OK.value());
    	    response.setMessage("Passenger Updated Successfully");
    	    response.setData(passengerDao.updatePassenger(p));

    	    return new ResponseEntity<ResponseStructure<Passenger>>(response, HttpStatus.OK);
    	}

     
}
