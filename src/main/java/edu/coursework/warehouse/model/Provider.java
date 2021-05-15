package edu.coursework.warehouse.model;

/*
    @author:    Sasha
    @project:    Warehouse 
    @class:    Provider 
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
public class Provider {

    private String id;

    private String name;
    private String address;
    private String number;
    private Head head;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Provider(String id, String name, String address, String number, Head head) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.head = head;
        created_at = LocalDateTime.now();
    }
}
