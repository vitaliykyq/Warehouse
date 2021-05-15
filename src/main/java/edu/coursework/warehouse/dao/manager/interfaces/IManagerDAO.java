package edu.coursework.warehouse.dao.manager.interfaces;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    IManagerDAO
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Manager;

import java.util.List;

public interface IManagerDAO {

    Manager getById(String id);
    Manager create(Manager manager);
    Manager update(Manager manager);
    Manager delete(String id);
    Manager save(Manager manager);
    List<Manager> getAll();
}
