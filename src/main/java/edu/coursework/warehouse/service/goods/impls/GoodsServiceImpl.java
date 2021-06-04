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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Fields.fields;

@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    GoodsRepository repository;
    private final MongoTemplate mongoTemplate;

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

    public Object getGoodsOfProvider(String name) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("provider.name").is(name)));

        return mongoTemplate.aggregate(aggregation, "goods", Object.class).getMappedResults();
    }
    public Object getGoodsOfProducer(String country) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("producer.country").is(country)));

        return mongoTemplate.aggregate(aggregation, "goods", Object.class).getMappedResults();
    }
    public Object getNumfProducersGoods() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("producer.country").sum("num").as("numberOfGoodsFromCoutry"));

        return mongoTemplate.aggregate(aggregation, "goods", Object.class).getMappedResults();
    }

    public List<Goods> getAllByName (String name) {
        return repository.findAllByName(name);
    }
    public List<Goods> getAllByNum (int num) {
        return repository.findAllByNum(num);
    }
    public List<Goods> getAllBySellingPricePerUnit (String price) {
        return repository.findAllBySellingPricePerUnit(price);
    }
}
