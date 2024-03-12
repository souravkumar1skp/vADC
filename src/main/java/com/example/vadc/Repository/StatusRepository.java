package com.example.vadc.Repository;

import com.example.vadc.Model.EventMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StatusRepository extends JpaRepository<EventMaster, Integer> {
    @Query(value = "with my_cte as (select distinct status from email_tracker),\n" +
            "my_cte2 as (SELECT status, count(*) AS count FROM email_tracker \n" +
            "\t\t\tWHERE created_date>= :startDate AND created_date<=:endDate GROUP BY status) \n" +
            "select my_cte.status, coalesce(my_cte2.count, 0) as count from my_cte left join my_cte2 on my_cte.status= my_cte2.status",
            nativeQuery = true)
    List<Object> getStatus(Long startDate, Long endDate);

    @Query(value = "with my_cte as (\n" +
            "select cem.*, em.start_date, em.end_date from candidate_event_mapping as cem inner join event_master as em on cem.event_id=em.id\n" +
            "),\n" +
            "cte2 as (\n" +
            "select count(*) as completed from my_cte where candidate_event_status= 'COMPLETED' and start_date>=0 and end_date<=1698706800000\n" +
            ")\n" +
            "select * , (select count(*) from my_cte where start_date>=0 and end_date<=1698706800000) as total from cte2 ", nativeQuery = true)
    Object getCandidateTaskStatus(Long startDate, Long endDate);

    @Query(value = "with my_cte as (select count(*) as completed from candidate_assessor_mapping where assessor_status= 'COMPLETED' " +
            "and created_on>= :startDate AND created_on<=:endDate)\n" +
            "select * , (select count(*) from candidate_assessor_mapping WHERE created_on>= :startDate AND created_on<=:endDate) " +
            "as total from my_cte", nativeQuery = true)
    Object getAssessorTaskStatus(Long startDate, Long endDate);
}
