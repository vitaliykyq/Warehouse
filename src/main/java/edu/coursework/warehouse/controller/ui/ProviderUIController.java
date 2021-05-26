package edu.coursework.warehouse.controller.ui;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    ProviderUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.warehouse.model.Provider;
import edu.coursework.warehouse.service.provider.impls.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/provider")
@Controller
public class ProviderUIController {

    @Autowired
    ProviderServiceImpl managerService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Provider> providerList = managerService.getAll();
        model.addAttribute("providerList", providerList);

        return "provider/providerList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Provider provider = managerService.getById(id);
        model.addAttribute("provider", provider);
        return "provider/updateProvider";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @ModelAttribute("employee") @RequestBody Provider provider) {
        /*provider.setPerson(personService.getAll().get(Integer.parseInt(provider.getPerson().getId()) - 1));*/
        managerService.update(provider);
        return "redirect:/ui/provider/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Provider provider = new Provider();
        model.addAttribute("provider", provider);
        return "provider/newProvider";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Provider provider) {
        /*provider.setPerson(personService.getAll().get(Integer.parseInt(provider.getPerson().getId()) - 1));*/
        model.addAttribute("provider", managerService.create(provider));
        return "redirect:/ui/provider/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        managerService.delete(id);
        return "redirect:/ui/provider/get/all";
    }
}
