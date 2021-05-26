package edu.coursework.warehouse.dao.person.impls;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    PersonDAOImpl
    @version:    1.0.0 
    @since:    14.04.2021     
*/


import edu.coursework.warehouse.dao.person.interfaces.IPersonDAO;
import edu.coursework.warehouse.data.FakeData;
import edu.coursework.warehouse.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public class PersonDAOImpl implements IPersonDAO {

    @Autowired
    FakeData fakeData;

    /*@Override
    public Administration getById(String id) {
        return null;
    }

    @Override
    public Administration create(Administration administration) {
        return null;
    }

    @Override
    public Administration update(Administration administration) {
        return null;
    }

    @Override
    public Administration delete(String id) {
        return null;
    }

    @Override
    public Administration save(Administration administration) {
        return null;
    }

    @Override
    public List<Administration> getAll() {
        return fakeData.getAdministrations();
    }*/

    @Override
    public Person getById(String id) {
        return this.getAll().stream()
                .filter(person -> person.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Person create(Person person) {
        String id = String.valueOf(this.getAll().stream()
                .mapToInt(el->Integer.parseInt(el.getId()))
                .max().orElse(0)+1);
        person.setCreatedAt(new Date());
        person.setId(id);
        this.getAll().add(person);
        return person;
    }

    @Override
    public Person update(Person person) {
        Person updatedPerson = this.getById(person.getId());
        updatedPerson.setName(person.getName());
        updatedPerson.setSurname(person.getSurname());
        updatedPerson.setAge(person.getAge());
        updatedPerson.setModifiedAt(new Date());

        return updatedPerson;

    }

    @Override
    public Person delete(String id) {
        Person person = this.getById(id);
        this.getAll().remove(person);
        return person;
    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return null /*fakeData.getPersonList()*/;
    }
}
