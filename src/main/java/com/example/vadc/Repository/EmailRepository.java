package com.example.vadc.Repository;

import com.example.vadc.Dto.EventStatusDto;
import com.example.vadc.Model.EventMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmailRepository extends JpaRepository<EventMaster, Integer> {
    @Query(value = "with my_cte as (select distinct status from email_tracker),\n" +
            "my_cte2 as (SELECT status, count(*) AS count FROM email_tracker \n" +
            "\t\t\tWHERE created_date>= :startDate AND created_date<=:endDate GROUP BY status) \n" +
            "select my_cte.status, coalesce(my_cte2.count, 0) as count from my_cte left join my_cte2 on my_cte.status= my_cte2.status", nativeQuery = true)
    List<Object> getStatus(Long startDate, Long endDate);

    @Query(value = "with my_cte as (\n" +
            "\tselect count(*) as completed from candidate_event_mapping where candidate_event_status= 'COMPLETED'\n" +
            ")\n" +
            "select * , (select count(*) from candidate_event_mapping) as total from my_cte", nativeQuery = true)
    Object getCandidateTaskStatus();

    @Query(value = "with my_cte as (select count(*) as completed from candidate_assessor_mapping where assessor_status= 'COMPLETED' and created_on>= 0 AND created_on<=9679483752681)\n" +
            "select * , (select count(*) from candidate_assessor_mapping WHERE created_on>= 0 AND created_on<=9679483752681) as total from my_cte", nativeQuery = true)
    Object getAssessorTaskStatus(Long startDate, Long endDate);
}
