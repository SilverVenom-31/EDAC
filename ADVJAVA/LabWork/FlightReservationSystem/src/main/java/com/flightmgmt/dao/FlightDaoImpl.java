//Created by @AkhilD on 17/02/2021
package com.flightmgmt.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flightmgmt.pojos.Airlines;
import com.flightmgmt.pojos.FlightDetails;

@Repository
public class FlightDaoImpl implements IFlightDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public List<FlightDetails> fetchFlightDetails(LocalDate date, String departureCity, String arrivalCity) {
		String jpql = "select f from FlightDetails f join fetch f.airlines where f.departureDate = :dt and f.departureCity=:dc and f.arrivalCity=:ac";
		System.out.println("in dao");

		return mgr.createQuery(jpql, FlightDetails.class).setParameter("dt", date).setParameter("dc", departureCity)
				.setParameter("ac", arrivalCity).getResultList();

	}

	@Override
	public FlightDetails getFlightById(int id) {

		return mgr.find(FlightDetails.class, id);
	}

	@Override
	public Airlines getAirlinesById(int id) {

		return mgr.find(Airlines.class, id);
	}

}
