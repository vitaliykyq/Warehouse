package edu.coursework.warehouse.service.accounting.impls;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    AccountingServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Accounting;
import edu.coursework.warehouse.repository.AccountingRepository;
import edu.coursework.warehouse.service.accounting.interfaces.IAccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountingServiceImpl implements IAccountingService {

    @Autowired
    AccountingRepository repository;

    @Override
    public Accounting getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Accounting create(Accounting accounting) {
        accounting.setCreatedAt(new Date());
        return repository.save(accounting);
    }

    @Override
    public Accounting update(Accounting accounting) {
        accounting.setModifiedAt(new Date());
        accounting.setCreatedAt(repository.findById(accounting.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(accounting);
        return accounting;
    }

    @Override
    public Accounting delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Accounting> getAll() {

        return repository.findAll();
    }
}
