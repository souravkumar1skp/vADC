package com.example.vadc.Service.EventServiceImpl;

import com.example.vadc.Dto.EmailDto;
import com.example.vadc.Dto.EventDto;
import com.example.vadc.Dto.EventStatusDto;
import com.example.vadc.Model.EventMaster;
import com.example.vadc.Repository.EmailRepository;
import com.example.vadc.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Override
    public List<EmailDto> getEmailStatus(Long startDate, Long endDate)
    {
        List<Object> data= emailRepository.getStatus(startDate, endDate);
        List<EmailDto> ldto= new ArrayList<>();
        for(Object row: data)
        {
            Object status= ((Object[]) row)[0];
            Object value= ((Object[]) row)[1];
            EmailDto dto= new EmailDto();

            dto.setStatus(status.toString());
            dto.setCount(value.hashCode());

            ldto.add(dto);
        }
        return ldto;
    }
    @Override
    public List<EventStatusDto> CandidateTaskStatusService()
    {
        Object data= emailRepository.getCandidateTaskStatus();
        EventStatusDto dto= new EventStatusDto();
        List<EventStatusDto> ldto= new ArrayList<>();
        dto.setStatus("Completed");
        dto.setValue(((Object[]) data)[0].hashCode());
        ldto.add(dto);

        EventStatusDto dto_2= new EventStatusDto();
        dto_2.setStatus("Total");
        dto_2.setValue(((Object[]) data)[1].hashCode());
        ldto.add(dto_2);
        return ldto;
    }

    @Override
    public List<EventStatusDto> AssessorTaskStatusService(Long startDate, Long endDate)
    {
        Object data= emailRepository.getAssessorTaskStatus(startDate, endDate);
        EventStatusDto dto= new EventStatusDto();
        List<EventStatusDto> ldto= new ArrayList<>();
        dto.setStatus("Completed");
        dto.setValue(((Object[]) data)[0].hashCode());
        ldto.add(dto);

        EventStatusDto dto_2= new EventStatusDto();
        dto_2.setStatus("Total");
        dto_2.setValue(((Object[]) data)[1].hashCode());
        ldto.add(dto_2);
        return ldto;
    }
}
