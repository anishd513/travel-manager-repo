package com.travelbackend.travelmanager.reposervice;

import com.travelbackend.travelmanager.entity.Users;
import com.travelbackend.travelmanager.repository.EventRepository;

import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventRepoService {
    private final EventRepository eventRepository;

    public EventRepoService(@NonNull EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Optional<Users> findByEvent(String event){
        return eventRepository.getEvent(event);
    }
}
