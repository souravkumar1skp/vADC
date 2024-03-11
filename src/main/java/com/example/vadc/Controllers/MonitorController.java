package com.example.vadc.Controllers;

import com.example.vadc.Dto.AssessorMonitorDto;
import com.example.vadc.Dto.CandidateMonitorDTO;
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
    public ResponseEntity<CandidateMonitorDTO> MonitorCandidate(@RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                                                @RequestParam(name = "email", required = false, defaultValue = "")String email,
                                                                @RequestParam(name = "clientEmail", required = false, defaultValue = "")String Client,
                                                                @RequestParam(name = "eventName", required = false, defaultValue = "")String eventName,
                                                                @RequestParam(name = "uuid", required = false, defaultValue = "")String uuid,
                                                                @RequestParam(name = "startDate", required = false)Long startDate,
                                                                @RequestParam(name = "endDate", required = false)Long endDate)
    {
        CandidateMonitorDTO data=monitorServiceImpl.CandidateMonitorService(pageNumber,10, email, Client, eventName, uuid, startDate, endDate);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/MonitorAssesor")
    public ResponseEntity<AssessorMonitorDto> MonitorAssesor(@RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                                             @RequestParam(name = "AssessorEmail", required = false, defaultValue = "")String email,
                                                             @RequestParam(name = "clientEmail", required = false, defaultValue = "")String Client,
                                                             @RequestParam(name = "eventName", required = false, defaultValue = "")String eventName,
                                                             @RequestParam(name = "uuid", required = false, defaultValue = "")String uuid,
                                                             @RequestParam(name = "startDate", required = false)Long startDate,
                                                             @RequestParam(name = "endDate", required = false)Long endDate)
    {
        AssessorMonitorDto data=monitorServiceImpl.AssessorMonitorService(pageNumber,10, email, Client, eventName,uuid, startDate, endDate);
        return ResponseEntity.ok(data);
    }
}
