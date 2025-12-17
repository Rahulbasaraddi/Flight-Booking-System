package Spring_Flight.Flight_Booking_System.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import Spring_Flight.Flight_Booking_System.enu.BookingStatus;
import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    private LocalDateTime bookingDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Passenger> passenger;

    @JoinColumn
    @ManyToOne
    private Flight flight;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;

    public Booking() {}  // <-- VERY IMPORTANT for Jackson

    public Booking(Integer id, LocalDateTime bookingDate, BookingStatus bookingStatus) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
    }

    // getters & setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }

    public BookingStatus getBookingStatus() { return bookingStatus; }
    public void setBookingStatus(BookingStatus bookingStatus) { this.bookingStatus = bookingStatus; }

    public List<Passenger> getPassenger() { return passenger; }
    public void setPassenger(List<Passenger> passenger) { this.passenger = passenger; }

    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }
}


































//package Spring_Flight.Flight_Booking_System.entity;
//
//
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.hibernate.annotations.CreationTimestamp;
//import org.springframework.stereotype.Controller;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import Spring_Flight.Flight_Booking_System.enu.BookingStatus;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//@RequiredArgsConstructor
//@Entity
//@Data
//public class Booking {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	@CreationTimestamp
//	private LocalDateTime bookingDate;
//	@Enumerated(EnumType.STRING)
//	private BookingStatus bookingStatus;
//	public List<Passenger> getPassenger() {
//		return passenger;
//	}
//	public void setPassenger(List<Passenger> passenger) {
//		this.passenger = passenger;
//	}
//	public Flight getFlight() {
//		return flight;
//	}
//	public void setFlight(Flight flight) {
//		this.flight = flight;
//	}
//	public Payment getPayment() {
//		return payment;
//	}
//	public void setPayment(Payment payment) {
//		this.payment = payment;
//	}
//	
//	@OneToMany(mappedBy="booking",cascade = CascadeType.ALL)
//	private List<Passenger> passenger;
//	
//	@JoinColumn
//	@ManyToOne
//	private Flight flight;
//	
//	@OneToOne(mappedBy="booking")
//	private Payment payment;
//	
//	public Booking(Integer id, LocalDateTime bookingDate, BookingStatus bookingStatus) {
//		super();
//		this.id = id;
//		this.bookingDate = bookingDate;
//		this.bookingStatus = bookingStatus;
//	}
//	
//	public Booking()
//	{
//	}
//	
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public LocalDateTime getBookingDate() {
//		return bookingDate;
//	}
//	public void setBookingDate(LocalDateTime bookingDate) {
//		this.bookingDate = bookingDate;
//	}
//	public BookingStatus getBookingStatus() {
//		return bookingStatus;
//	}
//	public void setBookingStatus(BookingStatus bookingStatus) {
//		this.bookingStatus = bookingStatus;
//	}
//	
//	
//
//}
//
