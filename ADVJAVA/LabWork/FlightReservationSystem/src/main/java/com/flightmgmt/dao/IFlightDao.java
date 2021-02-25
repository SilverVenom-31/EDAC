//Created by @AkhilD on 16/02/2021
package com.flightmgmt.dao;

import java.time.LocalDate;
import java.util.List;

import com.flightmgmt.pojos.Airlines;
import com.flightmgmt.pojos.FlightDetails;

public interface IFlightDao {

	// display flights
	java.util.List<FlightDetails> fetchFlightDetails(LocalDate date, String departureCity, String arrivalCity);

	FlightDetails getFlightById(int id);

	Airlines getAirlinesById(int id);

}
