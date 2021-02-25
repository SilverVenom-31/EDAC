//Created by @AkhilD on 17/02/2021
package com.flightmgmt.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmgmt.dao.FlightDaoImpl;
import com.flightmgmt.pojos.Airlines;
import com.flightmgmt.pojos.FlightDetails;

@Service
@Transactional
public class FlightServiceImpl implements IFlightService {

	@Autowired
	private FlightDaoImpl fDao;

	@Override
	public List<FlightDetails> fetchFlightDetails(LocalDate date, String departureCity, String arrivalCity) {
		System.out.println("in service");
		return fDao.fetchFlightDetails(date, departureCity, arrivalCity);

	}

	@Override
	public FlightDetails getFlightById(int id) {

		return fDao.getFlightById(id);
	}

	@Override
	public Airlines getAirlinesById(int id) {

		return fDao.getAirlinesById(id);
	}

}
