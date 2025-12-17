package Spring_Flight.Flight_Booking_System.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import Spring_Flight.Flight_Booking_System.dto.ResponseStructure;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handle(IdNotFoundException exp){
    	ResponseStructure<String> resp=new ResponseStructure<String>();
    	resp.setStatusCode(HttpStatus.NOT_FOUND.value());
    	resp.setMessage("failure");
    	resp.setData(exp.getMessage());
    	return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(NoRecordFoundexception.class)
	public ResponseEntity<ResponseStructure<String>> handleNRFE(NoRecordFoundexception exp){
    	ResponseStructure<String> resp=new ResponseStructure<String>();
    	resp.setStatusCode(HttpStatus.NOT_FOUND.value());
    	resp.setMessage("failure");
    	resp.setData(exp.getMessage());
    	return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.NOT_FOUND);
    } 
}
