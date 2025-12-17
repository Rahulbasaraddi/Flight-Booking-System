package Spring_Flight.Flight_Booking_System.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private String gender;
    private Integer seatnumber;
    private long contactnumber;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private Booking booking;

    public Passenger() {}  // needed for Jackson

    public Passenger(Integer id, String name, Integer age, String gender, Integer seatnumber, long contactnumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.seatnumber = seatnumber;
        this.contactnumber = contactnumber;
    }

    // getters & setters…

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Integer getSeatnumber() { return seatnumber; }
    public void setSeatnumber(Integer seatnumber) { this.seatnumber = seatnumber; }

    public long getContactnumber() { return contactnumber; }
    public void setContactnumber(long contactnumber) { this.contactnumber = contactnumber; }

    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }
}






























//package Spring_Flight.Flight_Booking_System.entity;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import lombok.RequiredArgsConstructor;
//
//@Entity
//@RequiredArgsConstructor
//public class Passenger { 
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	private String name;
//	private Integer age;
//	private String gender;
//	private Integer seatnumber;
//	private long contactnumber;
//	@JoinColumn
//	@ManyToOne
//	@JsonIgnore
//	private Booking booking;
//	
//	public Passenger(Integer id, String name, Integer age, String gender, Integer seatnumber, Integer contactnumber) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.age = age;
//		this.gender = gender;
//		this.seatnumber = seatnumber;
//		this.contactnumber = contactnumber;
//	}
//	
//	public Passenger()
//	{}
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Integer getAge() {
//		return age;
//	}
//	public void setAge(Integer age) {
//		this.age = age;
//	}
//	public String getGender() {
//		return gender;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//	public Integer getSeatnumber() {
//		return seatnumber;
//	}
//	public void setSeatnumber(Integer seatnumber) {
//		this.seatnumber = seatnumber;
//	}
//	
//
//	public long getContactnumber() {
//		return contactnumber;
//	}
//
//	public void setContactnumber(long contactnumber) {
//		this.contactnumber = contactnumber;
//	}
//
//	public Booking getBooking() {
//		return booking;
//	}
//
//	public void setBooking(Booking booking) {
//		this.booking = booking;
//	}
//	
//	
//}
//
