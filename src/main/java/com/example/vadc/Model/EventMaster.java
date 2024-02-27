package com.example.vadc.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "event_master")
public class EventMaster {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "vent_name")
    private String event_name;
    @Column(name = "start_date")
    private Long start_date;
    @Column(name = "end_date")
    private Long end_date;
    @Column(name = "timezone")
    private String timezone;
    @Column(name = "created_on")
    private Long created_on;
    @Column(name = "created_by")
    private String created_by;
    @Column(name = "event_type")
    private String event_type;
    @Column(name = "event_language")
    private String event_language;
    @Column(name = "event_note", columnDefinition = "text")
    private String event_note;
}