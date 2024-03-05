package com.example.vadc.Controllers;

import com.example.vadc.Dto.EmailDto;
import com.example.vadc.Dto.EventStatusDto;
import com.example.vadc.Service.EventServiceImpl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class EmailController {
    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @GetMapping("/getEmailStatus")
    public List<EmailDto> getEmailStatus(@RequestParam(name = "startDate", defaultValue = "0") Long startDate, @RequestParam(name = "endDate", defaultValue = "" + Long.MAX_VALUE) Long endDate)
    {
        return emailServiceImpl.getEmailStatus(startDate, endDate);
    }

    @GetMapping("/getCandidateTaskStatus")
    public List<EventStatusDto> getCandidateTaskStatus()
    {
        return emailServiceImpl.CandidateTaskStatusService();
    }

    @GetMapping("/getAssessorTaskStatus")
    public List<EventStatusDto> getAssessorTaskStatus(@RequestParam(name = "startDate", defaultValue = "0") Long startDate, @RequestParam(name = "endDate", defaultValue = "" + Long.MAX_VALUE) Long endDate)
    {
        return emailServiceImpl.AssessorTaskStatusService(startDate, endDate);
    }
}
