package com.trainee.schedulemodule.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.*;

import com.trainee.schedulemodule.entities.Flight;
import com.trainee.schedulemodule.exceptions.FlightNotFoundException;
import org.springframework.stereotype.Repository;
@Repository
public class FlightDaoImpl implements IFlightDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Flight addFlight(Flight flight) {
		entityManager.persist(flight);
		return flight;
	}

	@Override
	public Flight viewByFlightNum(BigInteger flightNum) {

		Flight flight = entityManager.find(Flight.class, flightNum);
		if (flight == null) {
			throw new FlightNotFoundException("flight not found for the given flight number" +flightNum);
		}
		return flight;	}

	@Override
	public List<Flight> viewAllFlights() {
		 String jpaQuery = "from Flight";
	       TypedQuery<Flight>flightquery= entityManager.createQuery(jpaQuery, Flight.class);
	        List<Flight> resultList = flightquery.getResultList();
	        return resultList;
	}

	@Override
	public Flight modifyFlight(Flight flight) {
		entityManager.merge(flight);
		return flight;
		}

		@Override
	public void delete(BigInteger flightNum) {
		Flight flight=viewByFlightNum(flightNum);
		entityManager.remove(flight);
		
	}

}
