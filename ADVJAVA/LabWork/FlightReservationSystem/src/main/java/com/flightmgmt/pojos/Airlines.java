//Created by @AkhilD on 16/02/2021
package com.flightmgmt.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "airlines")
public class Airlines extends BaseEntity {

	@Column(length = 20)
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private FlightDetails flightDetails;

	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FlightDetails getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Airlines [name=" + name + ", flightDetails=" + flightDetails + ", price=" + price + "]";
	}

}
