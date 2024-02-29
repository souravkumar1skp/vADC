package com.example.vadc.Repository;

import com.example.vadc.Model.EventMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmailRepository extends JpaRepository<EventMaster, Integer> {
    @Query(value = "select status,count(*) from email_tracker group by status", nativeQuery = true)
    List<Object> getStatus();
}
