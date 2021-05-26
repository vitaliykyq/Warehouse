package edu.coursework.warehouse.service.accounting.interfaces;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    IAccountingService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Accounting;

import java.util.List;

public interface IAccountingService {

    Accounting getById(String id);
    Accounting create(Accounting accounting);
    Accounting update(Accounting accounting);
    Accounting delete(String id);
    List<Accounting> getAll();
}
