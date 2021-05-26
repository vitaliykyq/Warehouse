package edu.coursework.warehouse.service.goods.impls;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    GoodsServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Goods;
import edu.coursework.warehouse.repository.GoodsRepository;
import edu.coursework.warehouse.service.goods.interfaces.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    GoodsRepository repository;

    @Override
    public Goods getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Goods create(Goods goods) {
        goods.setCreatedAt(new Date());
        return repository.save(goods);
    }

    @Override
    public Goods update(Goods goods) {
        goods.setModifiedAt(new Date());
        goods.setCreatedAt(repository.findById(goods.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(goods);
        return goods;
    }

    @Override
    public Goods delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Goods> getAll() {

        return repository.findAll();
    }
}
