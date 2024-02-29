package com.example.vadc.Repository;

import com.example.vadc.Dto.EventStatusDto;
import com.example.vadc.Model.EventMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmailRepository extends JpaRepository<EventMaster, Integer> {
    @Query(value = "select status,count(*) from email_tracker group by status", nativeQuery = true)
    List<Object> getStatus();

    @Query(value = "with my_cte as (\n" +
            "\tselect count(*) as completed from candidate_event_mapping where candidate_event_status= 'COMPLETED'\n" +
            ")\n" +
            "select * , (select count(*) from candidate_event_mapping) as total from my_cte", nativeQuery = true)
    Object getCandidateTaskStatus();
}
