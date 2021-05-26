package edu.coursework.warehouse.service.provider.interfaces;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    IProviderService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Provider;

import java.util.List;

public interface IProviderService {

    Provider getById(String id);
    Provider create(Provider provider);
    Provider update(Provider provider);
    Provider delete(String id);
    List<Provider> getAll();
}
