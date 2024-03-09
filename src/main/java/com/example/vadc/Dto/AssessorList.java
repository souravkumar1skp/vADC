package com.example.vadc.Dto;

import lombok.Data;

@Data
public class AssessorList {
    private String assessorName;
    private String assessorEmail;
    private String ClientEmail;
    private Long eventId;
    private String eventName;
    private String candidateEmail;
    private Long cid;
    private String interviewId;
    private String status;
    private Long startDate;
    private Long endDate;
    private String taskName;
    private String taskType;
}
