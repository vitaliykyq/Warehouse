package edu.coursework.warehouse.controller.ui;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    DeliveryUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.warehouse.model.Delivery;
import edu.coursework.warehouse.service.delivery.impls.DeliveryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/delivery")
@Controller
public class DeliveryUIController {

    @Autowired
    DeliveryServiceImpl deliveryService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Delivery> deliveryList = deliveryService.getAll();
        model.addAttribute("deliveryList", deliveryList);

        return "delivery/deliveryList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Delivery delivery = deliveryService.getById(id);
        model.addAttribute("delivery", delivery);
        return "delivery/updateDelivery";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("delivery") @RequestBody Delivery delivery) {

        deliveryService.update(delivery);
        return "redirect:/ui/delivery/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Delivery delivery = new Delivery();
        model.addAttribute("delivery", delivery);
        return "delivery/newDelivery";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("delivery") @RequestBody Delivery delivery) {

        model.addAttribute("delivery", deliveryService.create(delivery));
        return "redirect:/ui/delivery/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        deliveryService.delete(id);
        return "redirect:/ui/delivery/get/all";
    }
}
