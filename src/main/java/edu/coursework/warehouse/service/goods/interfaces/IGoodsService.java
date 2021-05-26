package edu.coursework.warehouse.service.goods.interfaces;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    IGoodsService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Goods;

import java.util.List;

public interface IGoodsService {

    Goods getById(String id);
    Goods create(Goods goods);
    Goods update(Goods goods);
    Goods delete(String id);
    List<Goods> getAll();
}
