package edu.coursework.warehouse.model;

/*
    @author:    Sasha
    @project:    Warehouse 
    @class:    Manager 
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
public class Manager {

    private String id;

    private Person person;
    private double salary;
    private int numberOfWorks;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Manager(String id, Person person, double salary, int numberOfWorks) {
        this.id = id;
        this.person = person;
        this.salary = salary;
        this.numberOfWorks = numberOfWorks;
        created_at = LocalDateTime.now();
    }
}
