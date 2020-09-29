package com.trainee.schedulemodule.dao;

import com.trainee.schedulemodule.entities.Airport;
import com.trainee.schedulemodule.entities.Flight;
import com.trainee.schedulemodule.entities.FlightSchedule;
import com.trainee.schedulemodule.entities.Schedule;
import com.trainee.schedulemodule.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class FlightScheduleDaoImple implements IFlightScheduleDao {

    @Autowired
    private ScheduleDao scheduleDao;
    @Autowired
    private IFlightDao flightDao;

    @Autowired
    private EntityManager entityManager;
    @Override
    public FlightSchedule addFlightSchedule(FlightSchedule flightSchedule) {
        validate(flightSchedule);
        entityManager.persist(flightSchedule);
        return flightSchedule;
    }
    private void validate(FlightSchedule flightSchedule) {
        if(flightSchedule==null)
        {
            throw new InvalidArgumentException("flight schedule cant be null");
        }
    }
    @Override
    public List<FlightSchedule> viewScheduleFlights(Airport source, Airport destination, Date time) {
        List<FlightSchedule> details=new ArrayList<>();
        List<Schedule> list=scheduleDao.betweenAirports(source,destination);
        for(Schedule schedule:list)
        {
            Date arrTime=schedule.getArrivalTime();

        }


    }

    @Override
    public FlightSchedule modifyFlightSchedule(Flight flight, Schedule schedule, Airport airport) {
        String getCarrierName=flight.getCarrierName();
        flight.setCarrierName(getCarrierName);
    }

    @Override
    public void deleteSchedule(BigInteger flightId) {
        flightDao.delete(flightId);
    }
}
