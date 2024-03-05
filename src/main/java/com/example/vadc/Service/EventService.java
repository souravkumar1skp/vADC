package com.example.vadc.Service;

import com.example.vadc.Dto.EventDto;
import com.example.vadc.Dto.EventStatusDto;

import java.util.List;

public interface EventService {
     EventDto getAllEventService(Long startDate, Long endDate);
     List<EventStatusDto> getEventStatusService(Long startDate, Long endDate);
     Integer getTotalClients(Long startDate, Long endDate);
     Integer getTotalCandidates(Long startDate, Long endDate);
     Integer getAssessorsCount(Long startDate, Long endDate);
     List<EventStatusDto> getTaskCompletionStatusService();
}
