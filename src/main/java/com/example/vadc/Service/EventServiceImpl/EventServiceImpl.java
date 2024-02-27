package com.example.vadc.Service.EventServiceImpl;

import com.example.vadc.Dto.EventDto;
import com.example.vadc.Dto.EventStatusDto;
import com.example.vadc.Model.EventMaster;
import com.example.vadc.Repository.EventRepository;
import com.example.vadc.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventDto getAllEventService()
    {
        Long res= eventRepository.getCount();
        EventDto dto= new EventDto();
        dto.setCountOfEvents(res);
        return dto;
    }

    public List<EventStatusDto> getEventStatusService()
    {
        List<Object> data= eventRepository.getStatus();
        List<EventStatusDto> ldto= new ArrayList<>();
        for(Object row: data)
        {
            Object status= ((Object[]) row)[0];
            Object value= ((Object[]) row)[1];
            EventStatusDto dto= new EventStatusDto();
            dto.setStatus(status.toString());
            dto.setValue(value.hashCode());
            ldto.add(dto);
        }
        return ldto;
    }

    public Integer getTotalClients()
    {
        return eventRepository.getTotalClients();
    }
}