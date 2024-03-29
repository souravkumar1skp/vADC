package com.example.vadc.Dto;

import lombok.Data;

@Data
public class MonitorDto {
    private String email;
    private String firstName;
    private String lastName;
    private String ClientEmail;
    private Long eventId;
    private String eventName;
    private String taskName;
    private String taskType;
    private Long cid;
    private String interviewId;
    private Integer CandidateId;
    private String status;
    private Long startDate;
    private Long endDate;
}
