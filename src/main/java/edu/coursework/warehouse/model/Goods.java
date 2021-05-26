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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "goods")
public class Goods {

    @Id
    private String id;

    private Provider provider;
    private Producer producer;
    private String name;
    private String unitsOfMeasurement;
    private String num;
    private String purchasePricePerUnit;
    private String sellingPricePerUnit;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
