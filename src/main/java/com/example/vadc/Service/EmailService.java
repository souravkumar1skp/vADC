package com.example.vadc.Service;

import com.example.vadc.Dto.EmailDto;

import java.util.List;

public interface EmailService {
    List<EmailDto> getEmailStatus();
}
