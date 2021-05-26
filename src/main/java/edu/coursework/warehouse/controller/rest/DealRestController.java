package edu.coursework.warehouse.controller.rest;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    DealRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Deal;
import edu.coursework.warehouse.service.deal.impls.DealServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Deal controller API")
@RestController
@RequestMapping("api/deal")
public class DealRestController {

    @Autowired
    DealServiceImpl service;

    @GetMapping("/get/all")
    public List<Deal> getManager(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Deal getById(@PathVariable("id") String id){
        Deal byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Deal deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Deal create(@RequestBody Deal deal){
        return service.create(deal);
    }

    @PostMapping ("/update/")
    public Deal update(@RequestBody Deal deal){
        return service.update(deal);
    }

}
