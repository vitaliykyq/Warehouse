package edu.coursework.warehouse.model;

/*
    @author:    Sasha
    @project:    Warehouse 
    @class:    Head 
    @version:    1.0.0 
    @since:    11.05.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Head {

    private String id;

    private Person person;
    private int experience;
    private int numberOfDevoted;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Head(String id, Person person, int experience, int numberOfDevoted) {
        this.id = id;
        this.person = person;
        this.experience = experience;
        this.numberOfDevoted = numberOfDevoted;
        created_at = LocalDateTime.now();
    }
}
