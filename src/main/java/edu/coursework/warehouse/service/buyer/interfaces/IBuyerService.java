package edu.coursework.warehouse.service.buyer.interfaces;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    IBuyerService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Buyer;

import java.util.List;

public interface IBuyerService {

    Buyer getById(String id);
    Buyer create(Buyer buyer);
    Buyer update(Buyer buyer);
    Buyer delete(String id);
    List<Buyer> getAll();
}
