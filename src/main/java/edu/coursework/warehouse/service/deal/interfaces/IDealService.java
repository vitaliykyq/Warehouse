package edu.coursework.warehouse.service.deal.interfaces;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    IDealService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Deal;

import java.util.List;

public interface IDealService {

    Deal getById(String id);
    Deal create(Deal deal);
    Deal update(Deal deal);
    Deal delete(String id);
    List<Deal> getAll();
}
