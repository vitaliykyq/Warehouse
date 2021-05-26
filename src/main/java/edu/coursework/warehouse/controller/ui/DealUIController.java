package edu.coursework.warehouse.controller.ui;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    DealUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.warehouse.model.Deal;
import edu.coursework.warehouse.service.deal.impls.DealServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/deal")
@Controller
public class DealUIController {

    @Autowired
    DealServiceImpl dealService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Deal> dealList = dealService.getAll();
        model.addAttribute("dealList", dealList);

        return "deal/dealList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Deal deal = dealService.getById(id);
        model.addAttribute("deal", deal);
        return "deal/updateDeal";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @ModelAttribute("employee") @RequestBody Deal deal) {

        /*deal.setPerson(personService.getAll().get(Integer.parseInt(deal.getPerson().getId()) - 1));*/
        dealService.update(deal);
        return "redirect:/ui/deal/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Deal deal = new Deal();
        model.addAttribute("deal", deal);
        return "deal/newDeal";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Deal deal) {
        /*deal.setPerson(personService.getAll().get(Integer.parseInt(deal.getPerson().getId()) - 1));*/
        model.addAttribute("deal", dealService.create(deal));
        return "redirect:/ui/deal/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        dealService.delete(id);
        return "redirect:/ui/deal/get/all";
    }
}
