package com.example.vadc.Repository;

import com.example.vadc.Model.EventMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonitorRepository extends JpaRepository<EventMaster, Integer> {
    @Query(value = "with my_cte as (\n" +
            "select em.id, em.event_name, em.client_id, cm.client_name, cm.client_email\n" +
            "from event_master as em inner join mettl_client as cm on em.client_id=cm.mettl_client_id\n" +
            "),\n" +
            "cte2 as (\n" +
            "select mc.*, etm.task_id, etm.start_date, etm.end_date, etm.status, etm.task_display_name\n" +
            "from my_cte as mc inner join event_task_mapping as etm on etm.event_id= mc.id\n" +
            "),\n" +
            "cte3 as (\n" +
            "select cm.id as candidate_id,ctm.task_type,ctm.cid, ctm.interview_cid, cm.first_name, cm.last_name, cm.email, ctm.event_id, ctm.task_id as tid from candidate_task_mapping as ctm inner join candidate_master as cm on ctm.candidate_id=cm.id\n" +
            ")\n" +
            "select * from cte3 inner join cte2 on cte3.event_id=cte2.id and cte3.tid= cte2.task_id where (:email IS NULL OR email ilike concat('%', :email, '%')) AND (:Client IS NULL OR client_email ilike concat('%', :Client, '%'))" +
            "AND (:eventName IS NULL OR event_name ilike concat('%', :eventName, '%')) AND (:eventId IS NULL OR event_id = :eventId) AND (:startDate IS NULL OR start_date = :startDate) AND (:endDate IS NULL OR end_date = :endDate)" +
            "AND (:uuid IS NULL OR interview_cid ilike concat('%', :uuid, '%')) AND (:cid IS NULL OR cid = :cid)", nativeQuery = true)
    List<Object> CandidateMonitor(String email, String Client, String eventName,String uuid, Long cid, Long eventId, Long startDate, Long endDate);

    @Query(value = "with cte1 as (\n" +
            "select cam.id,cam.task_id,cam.event_id, cam.client_id, cam.assessor_name, \n" +
            "\tcam.assessor_email,cam.assessor_status, cam.candidate_id, cm.first_name, cm.last_name, cm.email  as candidate_email\n" +
            "\tfrom candidate_assessor_mapping as cam inner join candidate_master as cm on cm.id= cam.candidate_id\n" +
            "),\n" +
            "cte2 as (\n" +
            "select cte1.*, mc.client_name, mc.client_email from cte1 \n" +
            "inner join mettl_client as mc on cte1.client_id=mc.mettl_client_id\n" +
            "),\n" +
            "cte3 as (\n" +
            "select cte2.*, em.event_name, em.start_date, em.end_date from cte2 inner join event_master as em on cte2.event_id= em.id\n" +
            "),\n" +
            "cte4 as (\n" +
            "select cte3.*, etm.task_display_name, etm.task_type\n" +
            "\tfrom cte3 inner join event_task_mapping as etm on cte3.task_id=etm.task_id and cte3.event_id=etm.event_id\n" +
            "),\n" +
            "cte5 as (\n" +
            "select cte4.*, ctm.cid, ctm.interview_cid from cte4 inner join candidate_task_mapping as ctm \n" +
            "\ton ctm.task_id= cte4.task_id and ctm.candidate_id= cte4.candidate_id and ctm.event_id=cte4.event_id\n" +
            ")\n" +
            "select * from cte5 where (:email IS NULL OR assessor_email ilike concat('%', :email, '%')) AND (:Client IS NULL OR client_email ilike concat('%', :Client, '%'))\n" +
            "AND (:eventName IS NULL OR event_name ilike concat('%', :eventName, '%')) AND (:eventId IS NULL OR event_id = :eventId) AND (:startDate IS NULL OR start_date = :startDate) AND (:endDate IS NULL OR end_date = :endDate)\n" +
            "AND (:uuid IS NULL OR interview_cid ilike concat('%', :uuid, '%')) AND (:cid IS NULL OR cid = :cid)", nativeQuery = true)
    List<Object> AssessorMonitor(String email, String Client, String eventName,String uuid, Long cid, Long eventId, Long startDate, Long endDate);
}
