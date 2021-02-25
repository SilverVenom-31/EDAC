//Created by @AkhilD on 16/02/2021
package com.flightmgmt.pojos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "flights")
public class FlightDetails extends BaseEntity {
	@Column(length = 20)
	private String departureCity;
	@Column(length = 20)
	private String arrivalCity;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent
	private LocalDate departureDate;

	private LocalTime departureTime;

	// one to many
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "flightDetails", orphanRemoval = true)
	private java.util.List<Airlines> airlines = new ArrayList<>();

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public java.util.List<Airlines> getAirlines() {
		return airlines;
	}

	public void setAirlines(java.util.List<Airlines> airlines) {
		this.airlines = airlines;
	}

}
