package edu.coursework.warehouse.controller.ui;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    AccountingUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.warehouse.model.*;
import edu.coursework.warehouse.service.accounting.impls.AccountingServiceImpl;
import edu.coursework.warehouse.service.buyer.impls.BuyerServiceImpl;
import edu.coursework.warehouse.service.goods.impls.GoodsServiceImpl;
import edu.coursework.warehouse.service.provider.impls.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/accounting")
@Controller
public class AccountingUIController {

    @Autowired
    AccountingServiceImpl accountingService;

    @Autowired
    ProviderServiceImpl providerService;

    @Autowired
    BuyerServiceImpl buyerService;

    @Autowired
    GoodsServiceImpl goodsService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Accounting> accountingList = accountingService.getAll();
        model.addAttribute("accountingList", accountingList);

        return "accounting/accountingList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Accounting accounting = accountingService.getById(id);
        model.addAttribute("accounting", accounting);

        List<Provider> providerIdList = providerService.getAll();
        model.addAttribute("providerIdList", providerIdList);

        List<Buyer> buyerIdList = buyerService.getAll();
        model.addAttribute("buyerIdList", buyerIdList);

        List<Goods> goodsIdList = goodsService.getAll();
        model.addAttribute("goodsIdList", goodsIdList);
        return "accounting/updateAccounting";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("accounting") @RequestBody Accounting accounting) {
        accountingService.update(accounting);
        return "redirect:/ui/accounting/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Accounting accounting = new Accounting();
        model.addAttribute("accounting", accounting);

        List<Provider> providerIdList = providerService.getAll();
        model.addAttribute("providerIdList", providerIdList);

        List<Buyer> buyerIdList = buyerService.getAll();
        model.addAttribute("buyerIdList", buyerIdList);

        List<Goods> goodsIdList = goodsService.getAll();
        model.addAttribute("goodsIdList", goodsIdList);
        return "accounting/newAccounting";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("accounting") @RequestBody Accounting accounting) {
        model.addAttribute("accounting", accountingService.create(accounting));
        return "redirect:/ui/accounting/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        accountingService.delete(id);
        return "redirect:/ui/accounting/get/all";
    }
}
