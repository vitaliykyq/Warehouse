package edu.coursework.warehouse.model;

/*
    @author:    Sasha
    @project:    Warehouse 
    @class:    Producer 
    @version:    1.0.0 
    @since:    11.05.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.image.LookupOp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producer {

    private String id;

    private String country;
    private String address;
    private String number;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Producer(String id, String country, String address, String number) {
        this.id = id;
        this.country = country;
        this.address = address;
        this.number = number;
        created_at = LocalDateTime.now();
    }
}
