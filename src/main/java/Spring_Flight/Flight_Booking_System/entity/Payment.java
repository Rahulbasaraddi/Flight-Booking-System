package Spring_Flight.Flight_Booking_System.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Spring_Flight.Flight_Booking_System.enu.ModeOfTransaction;
import Spring_Flight.Flight_Booking_System.enu.Paymentstatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@CreationTimestamp
	private LocalDateTime paymentDate;
	private Double amount;
	@Enumerated(EnumType.STRING)
	private ModeOfTransaction modeoftransaction;
	@Enumerated(EnumType.STRING)
	private Paymentstatus paymentstatus;
	@JsonIgnore
	@JoinColumn
	@OneToOne
	private Booking booking;

	public Payment(Integer id, LocalDateTime paymentDate, Double amount, ModeOfTransaction modeoftransaction,
			Paymentstatus paymentstatus) {
		super();
		this.id = id;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.modeoftransaction = modeoftransaction;
		this.paymentstatus = paymentstatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public ModeOfTransaction getModeoftransaction() {
		return modeoftransaction;
	}

	public void setModeoftransaction(ModeOfTransaction modeoftransaction) {
		this.modeoftransaction = modeoftransaction;
	}

	public Paymentstatus getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(Paymentstatus paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
