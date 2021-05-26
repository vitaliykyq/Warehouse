package edu.coursework.warehouse.controller.rest;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    HeadRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Head;
import edu.coursework.warehouse.service.head.impls.HeadServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Head controller API")
@RestController
@RequestMapping("api/head")
public class HeadRestController {

    @Autowired
    HeadServiceImpl service;

    @GetMapping("/get/all")
    public List<Head> getManager(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Head getById(@PathVariable("id") String id){
        Head byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Head deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Head create(@RequestBody Head head){
        return service.create(head);
    }

    @PostMapping ("/update/")
    public Head update(@RequestBody Head head){
        return service.update(head);
    }

}
