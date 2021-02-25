package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "locations_tbl")
public class Location extends BaseEntity {
@Column(length = 20)
	private String city;
@Column(length = 20)
	private String state;
@Column(length = 20)
	private String country;
//uni directional one to one assoc with Vendor
@OneToOne
@JoinColumn(name = "vendor_id")
//without mapsID there would be separate PK for location table
@MapsId //shared Pk and Fk refrencing pk of vendors
	private Vendors currentVendor;
	
	

	public Location() {
		System.out.println("In location constr");
	}

	public Location(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public Vendors getCurrentVendor() {
		return currentVendor;
	}

	public void setCurrentVendor(Vendors currentVendor) {
		this.currentVendor = currentVendor;
	}
	@Override
	public String toString() {
		return "Location [city=" + city + ", state=" + state + ", country=" + country + "]";
	}

}
