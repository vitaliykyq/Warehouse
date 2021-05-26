package edu.coursework.warehouse.service.delivery.impls;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    DeliveryServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Delivery;
import edu.coursework.warehouse.repository.DeliveryRepository;
import edu.coursework.warehouse.service.delivery.interfaces.IDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeliveryServiceImpl implements IDeliveryService {

    @Autowired
    DeliveryRepository repository;

    @Override
    public Delivery getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Delivery create(Delivery delivery) {
        delivery.setCreatedAt(new Date());
        return repository.save(delivery);
    }

    @Override
    public Delivery update(Delivery delivery) {
        delivery.setModifiedAt(new Date());
        delivery.setCreatedAt(repository.findById(delivery.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(delivery);
        return delivery;
    }

    @Override
    public Delivery delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Delivery> getAll() {

        return repository.findAll();
    }
}
