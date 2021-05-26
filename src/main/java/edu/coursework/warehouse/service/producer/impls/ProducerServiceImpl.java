package edu.coursework.warehouse.service.producer.impls;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    ProducerServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Producer;
import edu.coursework.warehouse.repository.ProducerRepository;
import edu.coursework.warehouse.service.producer.interfaces.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProducerServiceImpl implements IProducerService {

    @Autowired
    ProducerRepository repository;

    @Override
    public Producer getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Producer create(Producer producer) {
        producer.setCreatedAt(new Date());
        return repository.save(producer);
    }

    @Override
    public Producer update(Producer producer) {
        producer.setModifiedAt(new Date());
        producer.setCreatedAt(repository.findById(producer.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(producer);
        return producer;
    }

    @Override
    public Producer delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Producer> getAll() {

        return repository.findAll();
    }
}
