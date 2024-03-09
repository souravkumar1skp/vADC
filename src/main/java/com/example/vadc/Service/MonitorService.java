package com.example.vadc.Service;

import com.example.vadc.Dto.AssessorMonitorDto;
import com.example.vadc.Dto.CandidateMonitorDTO;

public interface MonitorService {
    CandidateMonitorDTO CandidateMonitorService(Integer pageNumber, Integer pageSize, String email, String Client, String eventName, String uuid, Long startDate, Long endDate);
    AssessorMonitorDto AssessorMonitorService(Integer pageNumber, Integer pageSize, String email, String Client, String eventName, String uuid, Long startDate, Long endDate);
}
