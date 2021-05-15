package edu.coursework.warehouse.model;

/*
    @author:    Sasha
    @project:    Warehouse 
    @class:    Deal
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
public class Deal {

    private String id;

    private Provider provider;
    private Buyer buyer;
    private int offtake;
    private double sum;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Deal(String id, Provider provider, Buyer buyer, int offtake, double sum) {
        this.id = id;
        this.provider = provider;
        this.buyer = buyer;
        this.offtake = offtake;
        this.sum = sum;
        created_at = LocalDateTime.now();
    }
}
