package com.example.vadc.Controllers;

import com.example.vadc.Dto.EventStatusDto;
import com.example.vadc.Service.EventServiceImpl.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class StatusController {
    @Autowired
    private StatusServiceImpl emailServiceImpl;

    @GetMapping("/getEmailStatus")
    public List<EventStatusDto> getEmailStatus(@RequestParam(name = "startDate", defaultValue = "0") Long startDate, @RequestParam(name = "endDate", defaultValue = "" + Long.MAX_VALUE) Long endDate)
    {
        return emailServiceImpl.getEmailStatus(startDate, endDate);
    }

    @GetMapping("/getCandidateTaskStatus")
    public List<EventStatusDto> getCandidateTaskStatus(@RequestParam(name = "startDate", defaultValue = "0") Long startDate, @RequestParam(name = "endDate", defaultValue = "" + Long.MAX_VALUE) Long endDate)
    {
        return emailServiceImpl.CandidateTaskStatusService(startDate, endDate);
    }

    @GetMapping("/getAssessorTaskStatus")
    public List<EventStatusDto> getAssessorTaskStatus(@RequestParam(name = "startDate", defaultValue = "0") Long startDate, @RequestParam(name = "endDate", defaultValue = "" + Long.MAX_VALUE) Long endDate)
    {
        return emailServiceImpl.AssessorTaskStatusService(startDate, endDate);
    }

    @GetMapping("/getTaskWiseStatus")
    public List<EventStatusDto> getTaskWiseStatus(@RequestParam(name = "type", defaultValue = "ASSESSMENT") String type)
    {
        return emailServiceImpl.taskWiseStatusService(type);
    }
}
