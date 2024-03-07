package com.example.vadc.Service.EventServiceImpl;

import com.example.vadc.Dto.EventStatusDto;
import com.example.vadc.Dto.MonitorDto;
import com.example.vadc.Repository.MonitorRepository;
import com.example.vadc.Service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonitorServiceImpl implements MonitorService {
    @Autowired
    private MonitorRepository monitorRepository;

    public List<MonitorDto> CandidateMonitorService(Integer pageNumber, Integer pageSize)
    {
        Pageable p= PageRequest.of(pageNumber, pageSize);
        List<Object> data= monitorRepository.CandidateMonitor(p);
        List<MonitorDto> ldto= new ArrayList<>();
        for (Object row : data) {
            MonitorDto dto = new MonitorDto();
            Object[] rowData = (Object[]) row;

            if (rowData[0] != null) {
                dto.setCandidate_id(rowData[0].hashCode());
            }
            if (rowData[1] != null) {
                dto.setFirstName(rowData[1].toString());
            }
            if (rowData[2] != null) {
                dto.setLastName(rowData[2].toString());
            }
            if (rowData[3] != null) {
                dto.setEmail(rowData[3].toString());
            }
            if (rowData[4] != null) {
                dto.setEventId((long) rowData[4].hashCode());
            }
            if (rowData[5] != null) {
                dto.setId((long) rowData[5].hashCode());
            }
            if (rowData[6] != null) {
                dto.setEventName(rowData[6].toString());
            }
            if (rowData[7] != null) {
                dto.setClientId((long) rowData[7].hashCode());
            }
            if (rowData[8] != null) {
                dto.setClientName(rowData[8].toString());
            }
            if (rowData[9] != null) {
                dto.setClientEmail(rowData[9].toString());
            }
            if (rowData[10] != null) {
                dto.setTaskId((long) rowData[10].hashCode());
            }
            if (rowData[11] != null) {
                dto.setStartDate((long) rowData[11].hashCode());
            }
            if (rowData[12] != null) {
                dto.setEndDate((long) rowData[12].hashCode());
            }
            if (rowData[13] != null) {
                dto.setStatus(rowData[13].toString());
            }
            if (rowData[14] != null) {
                dto.setTaskName(rowData[14].toString());
            }
            if (rowData[15] != null) {
                dto.setModeType(rowData[15].toString());
            }

            ldto.add(dto);
        }

        return ldto;
    }
}
