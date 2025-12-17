package Spring_Flight.Flight_Booking_System.exception;

public class IdNotFoundException extends RuntimeException
{  
	public IdNotFoundException()
	{
	}
	public IdNotFoundException(String msg){
		super(msg);
	}
}
