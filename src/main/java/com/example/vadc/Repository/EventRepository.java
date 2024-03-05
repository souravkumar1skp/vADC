package com.example.vadc.Repository;

import com.example.vadc.Model.EventMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventMaster, Integer> {
    @Query(value = "select count(*) from event_master where start_date>= :startDate and end_date<=:endDate or start_date is null or end_date is null;\n", nativeQuery = true)
    Long getCount(Long startDate, Long endDate);
    @Query(value = "select status,count(*) from event_master group by status", nativeQuery = true)
    List<Object> getStatus();
    @Query(value = "select count(*) from mettl_client", nativeQuery = true)
    Integer getTotalClients();
    @Query(value = "select count(*) from candidate_master", nativeQuery = true)
    Integer getCountOfCandidates();
    @Query(value = "with my_cte as (\n" +
            "\tselect distinct assessor_email from candidate_assessor_mapping\n" +
            ")\n" +
            "\n" +
            "select count(*) from my_cte", nativeQuery = true)
    Integer getTotalCount();

    @Query(value = "SELECT TO_CHAR(TIMESTAMP 'epoch' + completed_on * INTERVAL '1 millisecond', 'Month') AS months, count(*)\n" +
            "FROM candidate_task_mapping\n" +
            "WHERE completed_on IS NOT NULL\n" +
            "GROUP BY months", nativeQuery = true)
    List<Object> getCountByMonth();
}
