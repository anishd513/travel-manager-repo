package com.travelbackend.travelmanager.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
@Data
@Entity
@Table(name = "events")
@Accessors(chain = true)
@NoArgsConstructor
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private String eventId;

    @Column(name = "start_timestamp")
    Timestamp startTimestamp;
    @Column(name = "end_timestamp")
    Timestamp endTimestamp;


    @Type(type = "com.baeldung.hibernate.arraymapping.CustomStringArrayType")
    @Column(name = "user_id",columnDefinition = "text[]")
    String[] userId;
}
