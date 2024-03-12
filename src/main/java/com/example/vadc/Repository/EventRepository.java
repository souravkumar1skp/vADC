package com.example.vadc.Repository;

import com.example.vadc.Model.EventMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventMaster, Integer> {
    @Query(value = "select count(*) from event_master where start_date>= :startDate and end_date<=:endDate\n", nativeQuery = true)
    Long getCount(Long startDate, Long endDate);
    @Query(value = "with my_cte as (\n" +
            "\tselect distinct status from event_master\n" +
            "),\n" +
            "my_cte2 as (\n" +
            "SELECT status, count(*) AS count\n" +
            "FROM event_master\n" +
            "WHERE start_date >= :startDate AND end_date <= :endDate\n" +
            "GROUP BY status\n" +
            ")\n" +
            "select my_cte.status, coalesce(my_cte2.count, 0) as count from my_cte left join my_cte2 on my_cte.status= my_cte2.status", nativeQuery = true)
    List<Object> getStatus(Long startDate, Long endDate);
    @Query(value = "select count(*) from mettl_client where created_on>= :startDate and created_on<= :endDate", nativeQuery = true)
    Integer getTotalClient(Long startDate, Long endDate);
    @Query(value = "select count(*) from candidate_master where created_on>= :startDate and created_on<= :endDate", nativeQuery = true)
    Integer getCountOfCandidates(Long startDate, Long endDate);
    @Query(value = "with my_cte as (select distinct assessor_email from candidate_assessor_mapping where created_on>= :startDate and created_on<= :endDate)\n" +
            "select count(*) from my_cte", nativeQuery = true)
    Integer getTotalCount(Long startDate, Long endDate);

    @Query(value = "SELECT TO_CHAR(TIMESTAMP 'epoch' + completed_on * INTERVAL '1 millisecond', 'Month') AS months,count(distinct candidate_id) as candidate_count, count(*)\n" +
            "FROM candidate_task_mapping\n" +
            "WHERE completed_on IS NOT NULL\n" +
            "GROUP BY months\n" +
            "ORDER BY TO_DATE(TO_CHAR(TIMESTAMP 'epoch' + completed_on * INTERVAL '1 millisecond', 'Month'), 'Month')", nativeQuery = true)
    List<Object> getCountByMonth();
}
