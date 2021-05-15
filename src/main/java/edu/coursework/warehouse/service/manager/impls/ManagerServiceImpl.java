package edu.coursework.warehouse.service.manager.impls;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    ManagerServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.dao.manager.impls.ManagerDAOImpl;
import edu.coursework.warehouse.data.FakeData;
import edu.coursework.warehouse.model.Manager;
import edu.coursework.warehouse.service.manager.interfaces.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements IManagerService {

    @Autowired
    FakeData fakeData;

    @Autowired
    ManagerDAOImpl dao;

    @Override
    public Manager getById(String id) {
        return dao.getById(id);
    }

    @Override
    public Manager create(Manager manager) {
        return dao.create(manager);
    }

    @Override
    public Manager update(Manager manager) {
        return dao.update(manager);
    }

    @Override
    public Manager delete(String id) {
        return dao.delete(id);
    }

    @Override
    public Manager save(Manager manager) {
        return null;
    }

    @Override
    public List<Manager> getAll() {
        return fakeData.getManagerList();
    }
}
