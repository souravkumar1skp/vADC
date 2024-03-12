package com.example.vadc.Service.EventServiceImpl;

import com.example.vadc.Dto.EventDto;
import com.example.vadc.Dto.EventStatusDto;
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
    public EventDto getAllEventService(Long startDate, Long endDate)
    {
        Long res= eventRepository.getCount(startDate, endDate);
        EventDto dto= new EventDto();
        dto.setCountOfEvents(res);
        return dto;
    }
    @Override
    public List<EventStatusDto> getEventStatusService(Long startDate, Long endDate)
    {
        List<Object> data= eventRepository.getStatus(startDate, endDate);
        List<EventStatusDto> dtoList= new ArrayList<>();
        for(Object row: data)
        {
            Object status= ((Object[]) row)[0];
            Object value= ((Object[]) row)[1];

            EventStatusDto dto= new EventStatusDto();
            if (status.toString().equals("FINISHED")) {
                dto.setStatus("COMPLETED");
            }
            else
            {
                dto.setStatus(status.toString());
            }
            dto.setValue(value.hashCode());

            dtoList.add(dto);
        }
        return dtoList;
    }
    @Override
    public Integer getTotalClients(Long startDate, Long endDate)
    {
        return eventRepository.getTotalClient(startDate, endDate);
    }
    @Override
    public Integer getTotalCandidates(Long startDate, Long endDate)
    {
        return eventRepository.getCountOfCandidates(startDate, endDate);
    }
    @Override
    public Integer getAssessorsCount(Long startDate, Long endDate)
    {
        return eventRepository.getTotalCount(startDate, endDate);
    }

    @Override
    public List<EventStatusDto> getTaskCompletionStatusService()
    {
        List<Object> data= eventRepository.getCountByMonth();
        List<EventStatusDto> dtoList= new ArrayList<>();
        for(Object row: data)
        {
            Object status= ((Object[]) row)[0];
            Object value= ((Object[]) row)[1];

            EventStatusDto dto= new EventStatusDto();
            dto.setStatus(status.toString().substring(0,3));
            dto.setValue(value.hashCode());

            dtoList.add(dto);
        }
        return dtoList;
    }
}
