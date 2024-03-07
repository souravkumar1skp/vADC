package com.example.vadc.Dto;

import lombok.Data;

@Data
public class MonitorDto {
    private Integer Candidate_id;
    private String firstName;
    private String lastName;
    private String email;
    private Long eventId;
    private Long id;
    private String eventName;
    private Long clientId;
    private String clientName;
    private String ClientEmail;
    private Long taskId;
    private Long startDate;
    private Long endDate;
    private String status;
    private String taskName;
    private String modeType;
    private String uuid;
}
