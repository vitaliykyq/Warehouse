package edu.coursework.warehouse.service.person.impls;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    PersonServiceImpl
    @version:    1.0.0
    @since:    14.04.2021
*/

import edu.coursework.warehouse.dao.person.impls.PersonDAOImpl;
import edu.coursework.warehouse.data.FakeData;
import edu.coursework.warehouse.model.Person;
import edu.coursework.warehouse.service.person.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    FakeData fakeData;

    @Autowired
    PersonDAOImpl dao;

    @Override
    public Person getById(String id) {
        return dao.getById(id);
    }

    @Override
    public Person create(Person person) {
        return dao.create(person);
    }

    @Override
    public Person update(Person person) {
        return dao.update(person);
    }

    @Override
    public Person delete(String id) {
        return dao.delete(id);
    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return dao.getAll();
    }
}
