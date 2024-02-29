package com.example.vadc.Controllers;

import com.example.vadc.Dto.EmailDto;
import com.example.vadc.Service.EventServiceImpl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmailController {
    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @GetMapping("/getEmailStatus")
    public List<EmailDto> getEmailStatus()
    {
        return emailServiceImpl.getEmailStatus();
    }
}
