package com.example.vadc.Controllers;

import com.example.vadc.Dto.MonitorDto;
import com.example.vadc.Service.EventServiceImpl.MonitorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class MonitorController {
    @Autowired
    private MonitorServiceImpl monitorServiceImpl;

    @GetMapping("/MonitorCandidate")
    public ResponseEntity<List<MonitorDto>> MonitorCandidate(@RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber)
    {
        List<MonitorDto> data=monitorServiceImpl.CandidateMonitorService(pageNumber,15);
        return ResponseEntity.ok(data);
    }
}