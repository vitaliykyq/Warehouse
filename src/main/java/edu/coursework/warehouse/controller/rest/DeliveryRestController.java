package edu.coursework.warehouse.controller.rest;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    DeliveryRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Delivery;
import edu.coursework.warehouse.service.delivery.impls.DeliveryServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Delivery controller API")
@RestController
@RequestMapping("api/delivery")
public class DeliveryRestController {

    @Autowired
    DeliveryServiceImpl service;

    @GetMapping("/get/all")
    public List<Delivery> getManager(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Delivery getById(@PathVariable("id") String id){
        Delivery byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Delivery deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Delivery create(@RequestBody Delivery delivery){
        return service.create(delivery);
    }

    @PostMapping ("/update/")
    public Delivery update(@RequestBody Delivery delivery){
        return service.update(delivery);
    }

}
