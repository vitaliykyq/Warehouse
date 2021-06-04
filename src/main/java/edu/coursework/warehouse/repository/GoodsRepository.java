package edu.coursework.warehouse.repository;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    PersonRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.warehouse.model.Goods;
import edu.coursework.warehouse.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends MongoRepository<Goods, String> {
    public List<Goods> findAllByName (String name);
    public List<Goods> findAllByNum (int num);
    public List<Goods> findAllBySellingPricePerUnit (String price);

}
