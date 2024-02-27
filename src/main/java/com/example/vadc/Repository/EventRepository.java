package com.example.vadc.Repository;

import com.example.vadc.Dto.EventDto;
import com.example.vadc.Dto.EventStatusDto;
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
    @Query(value = "select * from mettl_client", nativeQuery = true)
    Integer getTotalClients();
}
