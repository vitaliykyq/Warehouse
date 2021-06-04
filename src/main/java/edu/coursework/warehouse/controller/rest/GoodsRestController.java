package edu.coursework.warehouse.controller.rest;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    GoodsRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Goods;
import edu.coursework.warehouse.service.goods.impls.GoodsServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Goods controller API")
@RestController
@RequestMapping("api/goods")
public class GoodsRestController {

    @Autowired
    GoodsServiceImpl service;

    @GetMapping("/get/all")
    public List<Goods> getManager(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Goods getById(@PathVariable("id") String id){
        Goods byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Goods deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Goods create(@RequestBody Goods goods){
        return service.create(goods);
    }

    @PostMapping ("/update/")
    public Goods update(@RequestBody Goods goods){
        return service.update(goods);
    }

    @GetMapping("/get/goodsOfProvider/{provider}")
    public Object getGoodsOfProvider(@PathVariable("provider") String provider){
        return service.getGoodsOfProvider(provider) ;
    }


    @GetMapping("/get/goodsOfProducer/{producer}")
    public Object getGoodsOfProducer(@PathVariable("producer") String producer){
        return service.getGoodsOfProducer(producer) ;
    }
    @GetMapping("/get/numOfProducersGoods")
    public Object getNumOfProducersGoods(){
        return service.getNumfProducersGoods() ;
    }


    @GetMapping("/get/byName/{name}")
    public List<Goods> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name) ;
    }


    @GetMapping("/get/byNum/{num}")
    public List<Goods> getAllByNum(@PathVariable("num") int num){
        return service.getAllByNum(num) ;
    }

    @GetMapping("/get/bySellingPricePerUnit/{price}")
    public List<Goods> getAllBySellingPricePerUnit(@PathVariable("price") String price){
        return service.getAllBySellingPricePerUnit(price) ;
    }


}
