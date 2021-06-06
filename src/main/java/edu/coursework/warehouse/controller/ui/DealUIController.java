package edu.coursework.warehouse.controller.ui;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    DealUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.warehouse.model.Buyer;
import edu.coursework.warehouse.model.Deal;
import edu.coursework.warehouse.model.Provider;
import edu.coursework.warehouse.service.buyer.impls.BuyerServiceImpl;
import edu.coursework.warehouse.service.deal.impls.DealServiceImpl;
import edu.coursework.warehouse.service.provider.impls.ProviderServiceImpl;
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

    @Autowired
    ProviderServiceImpl providerService;

    @Autowired
    BuyerServiceImpl buyerService;

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

        List<Provider> providerIdList = providerService.getAll();
        model.addAttribute("providerIdList", providerIdList);

        List<Buyer> buyerIdList = buyerService.getAll();
        model.addAttribute("buyerIdList", buyerIdList);
        return "deal/updateDeal";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("deal") @RequestBody Deal deal) {

        dealService.update(deal);
        return "redirect:/ui/deal/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Deal deal = new Deal();
        model.addAttribute("deal", deal);

        List<Provider> providerIdList = providerService.getAll();
        model.addAttribute("providerIdList", providerIdList);

        List<Buyer> buyerIdList = buyerService.getAll();
        model.addAttribute("buyerIdList", buyerIdList);
        return "deal/newDeal";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("deal") @RequestBody Deal deal) {

        model.addAttribute("deal", dealService.create(deal));
        return "redirect:/ui/deal/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        dealService.delete(id);
        return "redirect:/ui/deal/get/all";
    }
}
