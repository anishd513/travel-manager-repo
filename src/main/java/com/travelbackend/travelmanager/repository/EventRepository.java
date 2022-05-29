package com.travelbackend.travelmanager.repository;

import com.travelbackend.travelmanager.entity.Events;
import com.travelbackend.travelmanager.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Events,String> {
    @Query(value = "select * from events where event_id=:eventId",nativeQuery = true)
    Optional<Users> getEvent(String eventId);

}
