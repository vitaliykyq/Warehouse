package edu.coursework.warehouse.service.deal.impls;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    DealServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Deal;
import edu.coursework.warehouse.repository.DealRepository;
import edu.coursework.warehouse.service.deal.interfaces.IDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DealServiceImpl implements IDealService {

    @Autowired
    DealRepository repository;

    @Override
    public Deal getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Deal create(Deal deal) {
        deal.setCreatedAt(new Date());
        return repository.save(deal);
    }

    @Override
    public Deal update(Deal deal) {
        deal.setModifiedAt(new Date());
        deal.setCreatedAt(repository.findById(deal.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(deal);
        return deal;
    }

    @Override
    public Deal delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Deal> getAll() {

        return repository.findAll();
    }
}
