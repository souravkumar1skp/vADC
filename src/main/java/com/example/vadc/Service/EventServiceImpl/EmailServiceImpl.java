package com.example.vadc.Service.EventServiceImpl;

import com.example.vadc.Dto.EmailDto;
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
    public List<EmailDto> getEmailStatus()
    {
        List<Object> data= emailRepository.getStatus();
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
}
