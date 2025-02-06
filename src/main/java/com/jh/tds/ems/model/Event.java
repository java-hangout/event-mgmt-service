package com.jh.tds.ems.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "events_mgmt")
public class Event {

    @Id
    private String id;
    private String title;
    private String description;
    private String type; //ACHIEVEMENT, TOWNHALL, CULTURAL_ACTIVITY
    private boolean eventActiveFlag;
    private String businessUnitName;
    @CreatedDate
    private Date createdDate;  // Stores the date when the record was created
    @LastModifiedDate
    private Date updatedDate;

}
