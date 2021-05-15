package edu.coursework.warehouse.service.person.interfaces;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    IPersonService
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.warehouse.model.Person;

import java.util.List;

public interface IPersonService {

    Person getById(String id);
    Person create(Person person);
    Person update(Person person);
    Person delete(String id);
    Person save(Person person);
    List<Person> getAll();
}
