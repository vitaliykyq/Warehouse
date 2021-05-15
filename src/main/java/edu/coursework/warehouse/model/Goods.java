package edu.coursework.warehouse.model;

/*
    @author:    Sasha
    @project:    Warehouse 
    @class:    Goods 
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
public class Goods {

    private String id;

    private Provider provider;
    private Producer producer;
    private String name;
    private String unitsOfMeasurement;
    private String num;
    private String purchasePricePerUnit;
    private String sellingPricePerUnit;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Goods(String id, Provider provider, Producer producer, String name, String unitsOfMeasurement, String num,
                 String purchasePricePerUnit, String sellingPricePerUnit) {
        this.id = id;
        this.provider = provider;
        this.producer = producer;
        this.name = name;
        this.unitsOfMeasurement = unitsOfMeasurement;
        this.num = num;
        this.purchasePricePerUnit = purchasePricePerUnit;
        this.sellingPricePerUnit = sellingPricePerUnit;
        created_at = LocalDateTime.now();
    }
}
