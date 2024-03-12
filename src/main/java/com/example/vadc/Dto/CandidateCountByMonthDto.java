package com.example.vadc.Dto;

import lombok.Data;

@Data
public class CandidateCountByMonthDto {
    private String status;
    private Integer count;
    private Integer candidate_count;
}
