package edu.coursework.warehouse.controller.rest;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    ProducerRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Producer;
import edu.coursework.warehouse.service.producer.impls.ProducerServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Producer controller API")
@RestController
@RequestMapping("api/producer")
public class ProducerRestController {

    @Autowired
    ProducerServiceImpl service;

    @GetMapping("/get/all")
    public List<Producer> getManager(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Producer getById(@PathVariable("id") String id){
        Producer byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Producer deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Producer create(@RequestBody Producer producer){
        return service.create(producer);
    }

    @PostMapping ("/update/")
    public Producer update(@RequestBody Producer producer){
        return service.update(producer);
    }

}
