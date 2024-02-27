package com.example.vadc.Controllers;

import com.example.vadc.Dto.EventDto;
import com.example.vadc.Dto.EventStatusDto;
import com.example.vadc.Service.EventServiceImpl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventServiceImpl eventServiceImpl;
    @GetMapping("/getAllEventsCount")
    public EventDto getAllEventCount()
    {
        return eventServiceImpl.getAllEventService();
    }

    @GetMapping("/getAllEventsStatus")
    public List<EventStatusDto> getAllEventsStatus()
    {
        return eventServiceImpl.getEventStatusService();
    }

    @GetMapping("/getTotalClients")
    public Integer getTotalClients()
    {
        return eventServiceImpl.getTotalClients();
    }

    @GetMapping("/getTotalCandidates")
    public Integer getTotalCandidates()
    {
        return eventServiceImpl.getTotalCandidates();
    }

    @GetMapping("/getAssessorsCount")
    public Integer getAssessorsCount()
    {
        return eventServiceImpl.getAssessorsCount();
    }
}
