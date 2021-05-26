package edu.coursework.warehouse.service.person.impls;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    PersonServiceImpl
    @version:    1.0.0
    @since:    14.04.2021
*/

import edu.coursework.warehouse.model.Person;
import edu.coursework.warehouse.repository.PersonRepository;
import edu.coursework.warehouse.service.person.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    PersonRepository repository;

    @Override
    public Person getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Person create(Person person) {
        person.setCreatedAt(new Date());
        return repository.save(person);
    }

    @Override
    public Person update(Person person) {
        person.setModifiedAt(new Date());
        person.setCreatedAt(repository.findById(person.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(person);
        return person;
    }

    @Override
    public Person delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Person> getAll() {

        return repository.findAll();
    }
}
