//Created by @AkhilD on 17/02/2021
package com.flightmgmt.service;

import java.time.LocalDate;
import java.util.List;

import com.flightmgmt.pojos.Airlines;
import com.flightmgmt.pojos.FlightDetails;

public interface IFlightService {
	public List<FlightDetails> fetchFlightDetails(LocalDate date, String departureCity, String arrivalCity);
	FlightDetails getFlightById(int id);
	Airlines getAirlinesById(int id);
}
