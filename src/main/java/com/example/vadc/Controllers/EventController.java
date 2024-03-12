package com.example.vadc.Controllers;

import com.example.vadc.Dto.CandidateCountByMonthDto;
import com.example.vadc.Dto.EventDto;
import com.example.vadc.Dto.EventStatusDto;
import com.example.vadc.Service.EventServiceImpl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class EventController {
    @Autowired
    private EventServiceImpl eventServiceImpl;
    @GetMapping("/getAllEventsCount")
    public EventDto getAllEventCount(@RequestParam(name = "startDate", defaultValue = "0") Long startDate, @RequestParam(name = "endDate", defaultValue = "" + Long.MAX_VALUE) Long endDate)
    {
        return eventServiceImpl.getAllEventService(startDate, endDate);
    }

    @GetMapping("/getAllEventsStatus")
    public List<EventStatusDto> getAllEventsStatus(@RequestParam(name = "startDate", defaultValue = "0") Long startDate, @RequestParam(name = "endDate", defaultValue = "" + Long.MAX_VALUE) Long endDate)
    {
        return eventServiceImpl.getEventStatusService(startDate, endDate);
    }

    @GetMapping("/getTotalClients")
    public Integer getTotalClients(@RequestParam(name = "startDate", defaultValue = "0") Long startDate, @RequestParam(name = "endDate", defaultValue = "" + Long.MAX_VALUE) Long endDate)
    {
        return eventServiceImpl.getTotalClients(startDate, endDate);
    }

    @GetMapping("/getTotalCandidates")
    public Integer getTotalCandidates(@RequestParam(name = "startDate", defaultValue = "0") Long startDate, @RequestParam(name = "endDate", defaultValue = "" + Long.MAX_VALUE) Long endDate)
    {
        return eventServiceImpl.getTotalCandidates(startDate, endDate);
    }

    @GetMapping("/getAssessorsCount")
    public Integer getAssessorsCount(@RequestParam(name = "startDate", defaultValue = "0") Long startDate, @RequestParam(name = "endDate", defaultValue = "" + Long.MAX_VALUE) Long endDate)
    {
        return eventServiceImpl.getAssessorsCount(startDate, endDate);
    }

    @GetMapping("/getTaskStatus")
    public List<CandidateCountByMonthDto> getTaskStatus()
    {
        return eventServiceImpl.getTaskCompletionStatusService();
    }
}
