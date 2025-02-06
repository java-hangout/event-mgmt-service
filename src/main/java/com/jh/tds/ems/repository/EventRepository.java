package com.jh.tds.ems.repository;

import com.jh.tds.ems.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
//    List<Event> findByIsActiveTrue();

    List<Event> findByEventActiveFlag();
    List<Event> findByBusinessUnitName(String businessUnitName);
}
