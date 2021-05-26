package edu.coursework.warehouse.service.provider.impls;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    ProviderServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Provider;
import edu.coursework.warehouse.repository.ProviderRepository;
import edu.coursework.warehouse.service.provider.interfaces.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProviderServiceImpl implements IProviderService {

    @Autowired
    ProviderRepository repository;

    @Override
    public Provider getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Provider create(Provider provider) {
        provider.setCreatedAt(new Date());
        return repository.save(provider);
    }

    @Override
    public Provider update(Provider provider) {
        provider.setModifiedAt(new Date());
        provider.setCreatedAt(repository.findById(provider.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(provider);
        return provider;
    }

    @Override
    public Provider delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Provider> getAll() {

        return repository.findAll();
    }
}
