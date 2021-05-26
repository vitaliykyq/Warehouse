package edu.coursework.warehouse.controller.rest;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    BuyerRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Buyer;
import edu.coursework.warehouse.service.buyer.impls.BuyerServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Buyer controller API")
@RestController
@RequestMapping("api/buyer")
public class BuyerRestController {

    @Autowired
    BuyerServiceImpl service;

    @GetMapping("/get/all")
    public List<Buyer> getManager(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Buyer getById(@PathVariable("id") String id){
        Buyer byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Buyer deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Buyer create(@RequestBody Buyer buyer){
        return service.create(buyer);
    }

    @PostMapping ("/update/")
    public Buyer update(@RequestBody Buyer buyer){
        return service.update(buyer);
    }

}
