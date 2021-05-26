package edu.coursework.warehouse.service.head.impls;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    HeadServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Head;
import edu.coursework.warehouse.repository.HeadRepository;
import edu.coursework.warehouse.service.head.interfaces.IHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HeadServiceImpl implements IHeadService {

    @Autowired
    HeadRepository repository;

    @Override
    public Head getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Head create(Head head) {
        head.setCreatedAt(new Date());
        return repository.save(head);
    }

    @Override
    public Head update(Head head) {
        head.setModifiedAt(new Date());
        head.setCreatedAt(repository.findById(head.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(head);
        return head;
    }

    @Override
    public Head delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Head> getAll() {

        return repository.findAll();
    }
}
