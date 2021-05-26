package edu.coursework.warehouse.model;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    Person
    @version:    1.0.0
    @since:    11.05.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "person")
public class Person {

    @Id
    private String id;

    private String name;
    private String surname;
    private int age;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
