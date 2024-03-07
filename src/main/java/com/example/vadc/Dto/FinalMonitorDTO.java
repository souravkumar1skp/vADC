package com.example.vadc.Dto;

import lombok.Data;

import java.util.List;
@Data
public class FinalMonitorDTO {
    int pageNumber;
    int totalCount;
    List<MonitorDto> monitorDtoList;
}
