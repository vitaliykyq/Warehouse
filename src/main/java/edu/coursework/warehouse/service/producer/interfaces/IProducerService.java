package edu.coursework.warehouse.service.producer.interfaces;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    IProducerService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Producer;

import java.util.List;

public interface IProducerService {

    Producer getById(String id);
    Producer create(Producer producer);
    Producer update(Producer producer);
    Producer delete(String id);
    List<Producer> getAll();
}
