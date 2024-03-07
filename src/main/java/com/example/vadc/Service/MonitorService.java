package com.example.vadc.Service;

import com.example.vadc.Dto.FinalMonitorDTO;

public interface MonitorService {
    FinalMonitorDTO CandidateMonitorService(Integer pageNumber, Integer pageSize, String email, String Client, String eventName, Long eventId, Long startDate, Long endDate);
}
