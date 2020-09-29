package com.trainee.schedulemodule.dao;

import com.trainee.schedulemodule.entities.Airport;
import com.trainee.schedulemodule.entities.Flight;
import com.trainee.schedulemodule.entities.FlightSchedule;
import com.trainee.schedulemodule.entities.Schedule;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IFlightScheduleDao {
    FlightSchedule addFlightSchedule(FlightSchedule flightSchedule);
    List<FlightSchedule> viewScheduleFlights(Airport source, Airport destination, Date time);
    FlightSchedule modifyFlightSchedule(Flight flight, Schedule schedule,Airport airport);
   void deleteSchedule(BigInteger flightId);
}
