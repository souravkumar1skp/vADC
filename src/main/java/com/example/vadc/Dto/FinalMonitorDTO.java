package com.example.vadc.Dto;

import lombok.Data;

import java.util.List;
@Data
public class FinalMonitorDTO {
    int pageNumber;
    int totalPage;
    Long totalElements;
    List<MonitorDto> monitorDtoList;
}
