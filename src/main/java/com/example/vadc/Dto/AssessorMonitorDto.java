package com.example.vadc.Dto;

import lombok.Data;

import java.util.List;
@Data
public class AssessorMonitorDto {
    int pageNumber;
    int totalPage;
    Long totalElements;
    List<AssessorList> assessorDtoList;
}
