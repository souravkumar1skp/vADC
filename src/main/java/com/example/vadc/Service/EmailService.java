package com.example.vadc.Service;

import com.example.vadc.Dto.EmailDto;
import com.example.vadc.Dto.EventStatusDto;

import java.util.List;

public interface EmailService {
    List<EmailDto> getEmailStatus();
    List<EventStatusDto> CandidateTaskStatusService();
    List<EventStatusDto> AssessorTaskStatusService();
}
