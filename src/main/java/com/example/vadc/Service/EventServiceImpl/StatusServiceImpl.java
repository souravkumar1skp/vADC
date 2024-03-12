package com.example.vadc.Service.EventServiceImpl;

import com.example.vadc.Dto.EventStatusDto;
import com.example.vadc.Repository.StatusRepository;
import com.example.vadc.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository emailRepository;

    @Override
    public List<EventStatusDto> getEmailStatus(Long startDate, Long endDate)
    {
        List<Object> data= emailRepository.getStatus(startDate, endDate);
        List<EventStatusDto> DtoList= new ArrayList<>();
        for(Object row: data)
        {
            Object status= ((Object[]) row)[0];
            Object value= ((Object[]) row)[1];
            EventStatusDto dto= new EventStatusDto();

            dto.setStatus(status.toString());
            dto.setValue(value.hashCode());

            DtoList.add(dto);
        }
        return DtoList;
    }
    @Override
    public List<EventStatusDto> CandidateTaskStatusService(Long startDate, Long endDate)
    {
        Object data= emailRepository.getCandidateTaskStatus(startDate, endDate);
        EventStatusDto dto= new EventStatusDto();
        List<EventStatusDto> DtoList= new ArrayList<>();
        dto.setStatus("Completed");
        dto.setValue(((Object[]) data)[0].hashCode());
        DtoList.add(dto);

        EventStatusDto dto_2= new EventStatusDto();
        dto_2.setStatus("Total");
        dto_2.setValue(((Object[]) data)[1].hashCode());
        DtoList.add(dto_2);
        return DtoList;
    }

    @Override
    public List<EventStatusDto> AssessorTaskStatusService(Long startDate, Long endDate)
    {
        Object data= emailRepository.getAssessorTaskStatus(startDate, endDate);
        EventStatusDto dto= new EventStatusDto();
        List<EventStatusDto> DtoList= new ArrayList<>();
        dto.setStatus("Completed");
        dto.setValue(((Object[]) data)[0].hashCode());
        DtoList.add(dto);

        EventStatusDto dto_2= new EventStatusDto();
        dto_2.setStatus("Total");
        dto_2.setValue(((Object[]) data)[1].hashCode());
        DtoList.add(dto_2);
        return DtoList;
    }
    @Override
    public List<EventStatusDto> taskWiseStatusService(String type)
    {
        List<Object> data= emailRepository.getTaskWiseStatus(type);
        List<EventStatusDto> dtoList= new ArrayList<>();
        for(Object row: data)
        {
            Object status= ((Object[]) row)[0];
            Object value= ((Object[]) row)[1];

            EventStatusDto dto= new EventStatusDto();
            dto.setStatus(status.toString());
            dto.setValue(value.hashCode());

            dtoList.add(dto);
        }
        return dtoList;
    }
}
