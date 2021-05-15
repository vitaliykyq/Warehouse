package edu.coursework.warehouse.controller.rest;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    ManagerRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.warehouse.model.Manager;
import edu.coursework.warehouse.service.manager.impls.ManagerServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Manager controller API")
@RestController
@RequestMapping("api/manager")
public class ManagerRestController {

    @Autowired
    ManagerServiceImpl service;

    @GetMapping("/get/all")
    public List<Manager> getManager(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Manager getById(@PathVariable("id") String id){
        Manager byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Manager deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Manager create(@RequestBody Manager manager){
        return service.create(manager);
    }

    @PostMapping ("/update/")
    public Manager update(@RequestBody Manager manager){
        return service.update(manager);
    }

}
