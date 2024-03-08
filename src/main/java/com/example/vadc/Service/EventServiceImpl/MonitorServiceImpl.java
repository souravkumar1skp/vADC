package com.example.vadc.Service.EventServiceImpl;

import ch.qos.logback.core.net.server.Client;
import com.example.vadc.Dto.FinalMonitorDTO;
import com.example.vadc.Dto.MonitorDto;
import com.example.vadc.Repository.MonitorRepository;
import com.example.vadc.Service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonitorServiceImpl implements MonitorService {
    @Autowired
    private MonitorRepository monitorRepository;
    @Override
    public FinalMonitorDTO CandidateMonitorService(Integer pageNumber, Integer pageSize, String email, String Client, String eventName, Long eventId, Long startDate, Long endDate)
    {
        Pageable p= PageRequest.of(pageNumber, pageSize);
        List<Object> data= monitorRepository.CandidateMonitor(email,Client,eventName,eventId,startDate,endDate);
        int start = (int) p.getOffset();
        int end = Math.min((start + p.getPageSize()), data.size());
        Page<Object> monitorPage = new PageImpl<>(data.subList(start, end), p, data.size());
        List<MonitorDto> ldto= new ArrayList<>();
        for (Object row : monitorPage) {
            MonitorDto dto = new MonitorDto();
            Object[] rowData = (Object[]) row;

            if (rowData[0] != null) {
                dto.setCandidateId(rowData[0].hashCode());
            }
            if (rowData[1] != null) {
                dto.setTaskType(rowData[1].toString());
            }
            if (rowData[2] != null) {
                dto.setCid((long)rowData[2].hashCode());
            }
            if (rowData[3] != null) {
                dto.setInterviewId(rowData[3].toString());
            }
            if (rowData[4] != null) {
                dto.setFirstName(rowData[4].toString());
            }
            if (rowData[5] != null) {
                dto.setLastName(rowData[5].toString());
            }
            if (rowData[6] != null) {
                dto.setEmail(rowData[6].toString());
            }
            if (rowData[7] != null) {
                dto.setEventId((long) rowData[7].hashCode());
            }
            if (rowData[8] != null) {
                dto.setId((long) rowData[8].hashCode());
            }
            if (rowData[9] != null) {
                dto.setEventName(rowData[9].toString());
            }
            if (rowData[10] != null) {
                dto.setClientId((long) rowData[10].hashCode());
            }
            if (rowData[11] != null) {
                dto.setClientName(rowData[11].toString());
            }
            if (rowData[12] != null) {
                dto.setClientEmail(rowData[12].toString());
            }
            if (rowData[13] != null) {
                dto.setTaskId((long) rowData[13].hashCode());
            }
            if (rowData[14] != null) {
                dto.setStartDate((long) rowData[14].hashCode());
            }
            if (rowData[15] != null) {
                dto.setEndDate((long) rowData[15].hashCode());
            }
            if (rowData[16] != null) {
                dto.setStatus(rowData[16].toString());
            }
            if (rowData[17] != null) {
                dto.setTaskName(rowData[17].toString());
            }
            if (rowData[18] != null) {
                dto.setModeType(rowData[18].toString());
            }

            ldto.add(dto);
        }
        FinalMonitorDTO fdto= new FinalMonitorDTO();
        fdto.setPageNumber(pageNumber);
        fdto.setTotalCount(monitorPage.getTotalPages());
        fdto.setMonitorDtoList(ldto);
        return fdto;
    }

}
