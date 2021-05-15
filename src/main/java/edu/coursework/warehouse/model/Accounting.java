package edu.coursework.warehouse.model;

/*
    @author:    Sasha
    @project:    Warehouse 
    @class:    Accounting 
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
public class Accounting {

    private String id;

    private Provider provider;
    private Buyer buyer;
    private Goods goods;
    private String conclusion;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Accounting(String id, Provider provider, Buyer buyer, Goods goods, String conclusion) {
        this.id = id;
        this.provider = provider;
        this.buyer = buyer;
        this.goods = goods;
        this.conclusion = conclusion;
        created_at = LocalDateTime.now();
    }
}
