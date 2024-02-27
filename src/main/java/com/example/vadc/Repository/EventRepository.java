package com.example.vadc.Repository;

import com.example.vadc.Model.EventMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventMaster, Integer> {
    @Query(value = "SELECT count(*) FROM event_master", nativeQuery = true)
    Long getCount();
    @Query(value = "select status,count(*) from event_master group by status", nativeQuery = true)
    List<Object> getStatus();
    @Query(value = "select count(*) from mettl_client", nativeQuery = true)
    Integer getTotalClients();
    @Query(value = "with my_cte as (\n" +
            "\tselect distinct candidate_id from candidate_event_mapping\n" +
            ")\n" +
            "select count(*) from my_cte", nativeQuery = true)
    Integer getCountOfCandidates();
    @Query(value = "with my_cte as (\n" +
            "\tselect distinct assessor_email from candidate_assessor_mapping\n" +
            ")\n" +
            "\n" +
            "select count(*) from my_cte", nativeQuery = true)
    Integer getTotalCount();
}
