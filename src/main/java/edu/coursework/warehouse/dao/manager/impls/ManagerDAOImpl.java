/*
package edu.coursework.warehouse.dao.manager.impls;

*/
/*
    @author:    Sasha
    @project:    Warehouse
    @class:    ManagerDAOImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*//*


import edu.coursework.warehouse.dao.manager.interfaces.IManagerDAO;
import edu.coursework.warehouse.data.FakeData;
import edu.coursework.warehouse.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public class ManagerDAOImpl implements IManagerDAO {

    @Autowired
    FakeData fakeData;

    @Override
    public Manager getById(String id) {
        return this.getAll().stream()
                .filter(manager -> manager.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Manager create(Manager manager) {
        String id = String.valueOf(this.getAll().stream()
                .mapToInt(el->Integer.parseInt(el.getId()))
                .max().orElse(0)+1);
        manager.setCreatedAt(new Date());
        manager.setId(id);
        this.getAll().add(manager);
        return manager;
    }

    @Override
    public Manager update(Manager manager) {
        Manager updatedManager = this.getById(manager.getId());
        updatedManager.setPerson(manager.getPerson());
        updatedManager.setSalary(manager.getSalary());
        updatedManager.setNumberOfWorks(manager.getNumberOfWorks());
        updatedManager.setModifiedAt(new Date());
        return updatedManager;

    }

    @Override
    public Manager delete(String id) {
        Manager manager = this.getById(id);
        this.getAll().remove(manager);
        return manager;
    }

    @Override
    public Manager save(Manager manager) {
        return null;
    }

    @Override
    public List<Manager> getAll() {
        return null */
/*fakeData.getManagerList()*//*
;
    }
}
*/
