package com.trainee.schedulemodule.controllers;

import com.trainee.schedulemodule.dto.CreateFlightSchedule;
import com.trainee.schedulemodule.dto.FlightScheduleDto;
import com.trainee.schedulemodule.entities.Flight;
import com.trainee.schedulemodule.entities.FlightSchedule;
import com.trainee.schedulemodule.entities.Schedule;
import com.trainee.schedulemodule.service.FlightServiceImpl;
import com.trainee.schedulemodule.service.IFlightScheduleService;
import com.trainee.schedulemodule.utility.FlightScheduleUtil;
import com.trainee.schedulemodule.utility.FlightUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private IFlightScheduleService scheduleService;
    @Autowired
    private FlightScheduleUtil flightScheduleUtil;

    @PostMapping("/add")
    public FlightScheduleDto addSchedule(@RequestBody  CreateFlightSchedule requestdata)
    {
        Integer seats=requestdata.getAvailableSeats();
        Flight flight=requestdata.getFlight();
        Schedule schedule=requestdata.getSchedule();
        FlightSchedule schedule1=new FlightSchedule(flight,seats, schedule);
        schedule1=scheduleService.addFlightSchedule(schedule1);
        FlightScheduleDto response=flightScheduleUtil.dto(schedule1);
        return response;
    }



}
