package com.camilla.library.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

/**
 * @author camilla
 *
 */
@Entity()
public class Rental extends EntityModel {

	private static final long serialVersionUID = 6157718994642163332L;

	@Column(nullable = false)
	private BookUnit bookUnit;

	@Column(nullable = false)
	@JoinColumn(name = "client_id")
	private Client client;

	@Column(nullable = false)
	private Date rentalDate;

	@Transient
	private Double latePenaltyAmount;

	@Transient
	private long lateDays;

	public Rental() {
		super();
		setLateDays(calculateLateDays());
		setLatePenaltyAmount(calculateLatePenaltyAmount());
	}

	/**
	 * @return the latePenaltyAmount
	 */
	public Double getLatePenaltyAmount() {
		return latePenaltyAmount;
	}

	/**
	 * @param latePenaltyAmount the latePenaltyAmount to set
	 */
	public void setLatePenaltyAmount(Double latePenaltyAmount) {
		this.latePenaltyAmount = latePenaltyAmount;
	}

	/**
	 * @return the lateDays
	 */
	public long getLateDays() {
		return lateDays;
	}

	/**
	 * @param lateDays the lateDays to set
	 */
	public void setLateDays(long lateDays) {
		this.lateDays = lateDays;
	}

	/**
	 * @return the rentalDate
	 */
	public Date getRentalDate() {
		return rentalDate;
	}

	/**
	 * @param rentalDate the rentalDate to set
	 */
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	/**
	 * @return the bookUnit
	 */
	public BookUnit getBookUnit() {
		return bookUnit;
	}

	/**
	 * @param bookUnit the bookUnit to set
	 */
	public void setBookUnit(BookUnit bookUnit) {
		this.bookUnit = bookUnit;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the lateDays
	 */
	public long calculateLateDays() {
		if(getRentalDate() == null ) {
			return 0;
		}
		LocalDate limitDate = getRentalDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(3);

		if (LocalDate.now().isAfter(limitDate)) {
			return Duration.between(limitDate, LocalDate.now()).toDays();
		}
		return 0;

	}

	/**
	 * @return the latePenaltyAmount
	 */
	public double calculateLatePenaltyAmount() {
		long lateDays = getLateDays();
		if (lateDays > 0) {
			if (lateDays <= 3) {
				return 3 + (0.2 * lateDays);
			}
			if (lateDays <= 5) {
				return 5 + (0.4 * lateDays);
			}
			return 7 + (0.6 * lateDays);
		}
		return 0;
	}

}
