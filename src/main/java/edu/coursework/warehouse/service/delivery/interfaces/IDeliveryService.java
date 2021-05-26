package edu.coursework.warehouse.service.delivery.interfaces;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    IDeliveryService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Delivery;

import java.util.List;

public interface IDeliveryService {

    Delivery getById(String id);
    Delivery create(Delivery delivery);
    Delivery update(Delivery delivery);
    Delivery delete(String id);
    List<Delivery> getAll();
}
