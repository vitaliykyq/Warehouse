package edu.coursework.warehouse.controller.ui;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    BuyerUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.warehouse.model.Buyer;
import edu.coursework.warehouse.model.Manager;
import edu.coursework.warehouse.service.buyer.impls.BuyerServiceImpl;
import edu.coursework.warehouse.service.manager.impls.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/buyer")
@Controller
public class BuyerUIController {

    @Autowired
    BuyerServiceImpl buyerService;

    @Autowired
    ManagerServiceImpl managerService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Buyer> buyerList = buyerService.getAll();
        model.addAttribute("buyerList", buyerList);

        return "buyer/buyerList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Buyer buyer = buyerService.getById(id);
        model.addAttribute("buyer", buyer);

        List<Manager> managerIdList = managerService.getAll();
        model.addAttribute("managerIdList", managerIdList);
        return "buyer/updateBuyer";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("buyer") @RequestBody Buyer buyer) {

        buyerService.update(buyer);
        return "redirect:/ui/buyer/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Buyer buyer = new Buyer();
        model.addAttribute("buyer", buyer);

        List<Manager> managerIdList = managerService.getAll();
        model.addAttribute("managerIdList", managerIdList);
        return "buyer/newBuyer";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("buyer") @RequestBody Buyer buyer) {
        model.addAttribute("buyer", buyerService.create(buyer));
        return "redirect:/ui/buyer/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        buyerService.delete(id);
        return "redirect:/ui/buyer/get/all";
    }
}
