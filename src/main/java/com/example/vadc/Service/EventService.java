package com.example.vadc.Service;

import com.example.vadc.Dto.EventDto;
import com.example.vadc.Dto.EventStatusDto;

import java.util.List;

public interface EventService {
    abstract EventDto getAllEventService();
    abstract List<EventStatusDto> getEventStatusService();
    abstract Integer getTotalClients();
}
