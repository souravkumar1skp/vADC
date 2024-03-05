package com.example.vadc.Service;

import com.example.vadc.Dto.EventDto;
import com.example.vadc.Dto.EventStatusDto;

import java.util.List;

public interface EventService {
     EventDto getAllEventService(Long startDate, Long endDate);
     List<EventStatusDto> getEventStatusService();
     Integer getTotalClients();
     Integer getTotalCandidates();
     Integer getAssessorsCount();
     List<EventStatusDto> getTaskCompletionStatusService();
}
