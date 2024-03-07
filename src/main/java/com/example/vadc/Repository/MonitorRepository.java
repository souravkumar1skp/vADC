package com.example.vadc.Repository;

import com.example.vadc.Dto.MonitorDto;
import com.example.vadc.Model.EventMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonitorRepository extends JpaRepository<EventMaster, Integer> {
    @Query(value = "with my_cte as (\n" +
            "select em.id, em.event_name, em.client_id, cm.client_name, cm.client_email \n" +
            "\tfrom event_master as em inner join mettl_client as cm on em.client_id=cm.mettl_client_id\n" +
            "),\n" +
            "cte2 as (\n" +
            "select mc.*, etm.task_id, etm.start_date, etm.end_date, etm.status, etm.task_display_name, etm.mode_type \n" +
            "\tfrom my_cte as mc inner join event_task_mapping as etm on etm.event_id= mc.id\n" +
            "),\n" +
            "cte3 as (\n" +
            "select cm.id as candidate_id, cm.first_name, cm.last_name, cm.email, ctm.event_id from candidate_task_mapping as ctm inner join candidate_master as cm on ctm.candidate_id=cm.id\n" +
            ")\n" +
            "\n" +
            "select * from cte3 inner join cte2 on cte3.event_id=cte2.id order by candidate_id", nativeQuery = true)
    List<Object> CandidateMonitor();
}
