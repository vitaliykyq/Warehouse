package edu.coursework.warehouse.controller.ui;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    ProducerUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.warehouse.model.Producer;
import edu.coursework.warehouse.service.producer.impls.ProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/producer")
@Controller
public class ProducerUIController {

    @Autowired
    ProducerServiceImpl producerService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Producer> producerList = producerService.getAll();
        model.addAttribute("producerList", producerList);

        return "producer/producerList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Producer producer = producerService.getById(id);
        model.addAttribute("producer", producer);
        return "producer/updateProducer";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("producer") @RequestBody Producer producer) {

        producerService.update(producer);
        return "redirect:/ui/producer/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Producer producer = new Producer();
        model.addAttribute("producer", producer);
        return "producer/newProducer";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("producer") @RequestBody Producer producer) {

        model.addAttribute("producer", producerService.create(producer));
        return "redirect:/ui/producer/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        producerService.delete(id);
        return "redirect:/ui/producer/get/all";
    }
}
