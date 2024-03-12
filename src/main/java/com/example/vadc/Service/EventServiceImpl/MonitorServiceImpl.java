package com.example.vadc.Service.EventServiceImpl;

import com.example.vadc.Dto.AssessorList;
import com.example.vadc.Dto.AssessorMonitorDto;
import com.example.vadc.Dto.CandidateMonitorDTO;
import com.example.vadc.Dto.MonitorDto;
import com.example.vadc.Repository.MonitorRepository;
import com.example.vadc.Service.MonitorService;
import com.example.vadc.exception.WrongPageNumberRequested;
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
    public CandidateMonitorDTO CandidateMonitorService(Integer pageNumber, Integer pageSize, String email, String Client, String eventName,String uuid, Long startDate, Long endDate)
    {
        if(pageNumber<0)
        {
            throw new WrongPageNumberRequested("PageNumber Should be greater than or Equal 0");
        }

        //making empty string values null
        if(email.isEmpty()) email=null;
        if(Client.isEmpty()) Client=null;
        if(eventName.isEmpty()) eventName=null;
        if(uuid.isEmpty()) uuid=null;

        //regex to match if eventName is eventId or Not by getting if its All Number or not
        Long eventId=null;
        if(eventName !=null && eventName.matches("-?\\d+"))
        {
            eventId= Long.parseLong(eventName);
            eventName=null;
        }
        Long cid=null;
        if(uuid !=null && uuid.matches("-?\\d+"))
        {
            cid= Long.parseLong(uuid);
            uuid=null;
        }

        Pageable p= PageRequest.of(pageNumber, pageSize);
        List<Object> data= monitorRepository.CandidateMonitor(email,Client,eventName,uuid,cid,eventId,startDate,endDate);

        //getting all data then setting it into pageable as Page dont work with CTE's correctly
        int start = (int) p.getOffset();
        int end = Math.min((start + p.getPageSize()), data.size());
        Page<Object> monitorPage = new PageImpl<>(data.subList(start, end), p, data.size());
        List<MonitorDto> DtoList= new ArrayList<>();
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
                dto.setCid(Long.parseLong(rowData[2].toString()));
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
                dto.setEventId(Long.parseLong(rowData[7].toString()));
            }

            if (rowData[10] != null) {
                dto.setEventName(rowData[10].toString());
            }

            if (rowData[13] != null) {
                dto.setClientEmail(rowData[13].toString());
            }

            if (rowData[15] != null) {
                dto.setStartDate(Long.parseLong(rowData[15].toString()));
            }
            if (rowData[16] != null) {
                dto.setEndDate(Long.parseLong(rowData[16].toString()));
            }
            if (rowData[17] != null) {
                dto.setStatus(rowData[17].toString());
            }
            if (rowData[18] != null) {
                dto.setTaskName(rowData[18].toString());
            }

            DtoList.add(dto);
        }
        CandidateMonitorDTO finalDto= new CandidateMonitorDTO();
        finalDto.setPageNumber(pageNumber);
        finalDto.setTotalPage(monitorPage.getTotalPages());
        finalDto.setTotalElements(monitorPage.getTotalElements());
        finalDto.setMonitorDtoList(DtoList);
        return finalDto;
    }

    @Override
    public AssessorMonitorDto AssessorMonitorService(Integer pageNumber, Integer pageSize, String email, String Client, String eventName,String uuid, Long startDate, Long endDate)
    {
        if(pageNumber<0)
        {
            throw new WrongPageNumberRequested("PageNumber Should be greater than or Equal 0");
        }

        if(email.isEmpty()) email=null;
        if(Client.isEmpty()) Client=null;
        if(eventName.isEmpty()) eventName=null;
        if(uuid.isEmpty()) uuid=null;

        Long eventId=null;
        if(eventName !=null && eventName.matches("-?\\d+"))
        {
            eventId= Long.parseLong(eventName);
            eventName=null;
        }
        Long cid=null;
        if(uuid !=null && uuid.matches("-?\\d+"))
        {
            cid= Long.parseLong(uuid);
            uuid=null;
        }

        Pageable p= PageRequest.of(pageNumber, pageSize);
        List<Object> data= monitorRepository.AssessorMonitor(email,Client,eventName,uuid,cid,eventId,startDate,endDate);
        int start = (int) p.getOffset();
        int end = Math.min((start + p.getPageSize()), data.size());
        Page<Object> monitorPage = new PageImpl<>(data.subList(start, end), p, data.size());
        List<AssessorList> DtoList= new ArrayList<>();
        for (Object row : monitorPage) {
            AssessorList dto = new AssessorList();
            Object[] rowData = (Object[]) row;

            if (rowData[4] != null) {
                dto.setAssessorName(rowData[4].toString());
            }
            if (rowData[5] != null) {
                dto.setAssessorEmail(rowData[5].toString());
            }
            if (rowData[10] != null) {
                dto.setCandidateEmail(rowData[10].toString());
            }
            if (rowData[12] != null) {
                dto.setClientEmail(rowData[12].toString());
            }
            if (rowData[13] != null) {
                dto.setEventName(rowData[13].toString());
            }
            if (rowData[2] != null) {
                dto.setEventId(Long.parseLong(rowData[2].toString()));
            }
            if (rowData[16] != null) {
                dto.setTaskName(rowData[16].toString());
            }
            if (rowData[17] != null) {
                dto.setTaskType(rowData[17].toString());
            }

            if (rowData[6] != null) {
                dto.setStatus(rowData[6].toString());
            }

            if (rowData[18] != null) {
                dto.setCid(Long.parseLong(rowData[18].toString()));
            }

            if (rowData[19] != null) {
                dto.setInterviewId(rowData[19].toString());
            }
            if (rowData[14] != null) {
                dto.setStartDate(Long.parseLong(rowData[14].toString()));
            }
            if (rowData[15] != null) {
                dto.setEndDate(Long.parseLong(rowData[15].toString()));
            }

            DtoList.add(dto);
        }
        AssessorMonitorDto finalDto= new AssessorMonitorDto();
        finalDto.setPageNumber(pageNumber);
        finalDto.setTotalPage(monitorPage.getTotalPages());
        finalDto.setTotalElements(monitorPage.getTotalElements());
        finalDto.setAssessorDtoList(DtoList);
        return finalDto;
    }

}
