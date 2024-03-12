package com.example.vadc.Service;

import com.example.vadc.Dto.EventStatusDto;

import java.util.List;

public interface StatusService {
    List<EventStatusDto> getEmailStatus(Long startDate, Long endDate);
    List<EventStatusDto> CandidateTaskStatusService(Long startDate, Long endDate);
    List<EventStatusDto> AssessorTaskStatusService(Long startDate, Long endDate);

    List<EventStatusDto> taskWiseStatusService(String type);
}
