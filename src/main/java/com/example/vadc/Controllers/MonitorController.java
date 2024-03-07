package com.example.vadc.Controllers;

import com.example.vadc.Dto.FinalMonitorDTO;
import com.example.vadc.Service.EventServiceImpl.MonitorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MonitorController {
    @Autowired
    private MonitorServiceImpl monitorServiceImpl;

    @GetMapping("/MonitorCandidate")
    public ResponseEntity<FinalMonitorDTO> MonitorCandidate(@RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                                            @RequestParam(name = "email", required = false)String email,
                                                            @RequestParam(name = "Client", required = false)String Client,
                                                            @RequestParam(name = "eventName", required = false)String eventName,
                                                            @RequestParam(name = "eventId", required = false)Long eventId,
                                                            @RequestParam(name = "startDate", required = false)Long startDate,
                                                            @RequestParam(name = "endDate", required = false)Long endDate)
    {
        FinalMonitorDTO data=monitorServiceImpl.CandidateMonitorService(pageNumber,10, email, Client, eventName, eventId, startDate, endDate);
        return ResponseEntity.ok(data);
    }
}
