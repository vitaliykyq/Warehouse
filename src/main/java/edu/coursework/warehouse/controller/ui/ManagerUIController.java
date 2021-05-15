package edu.coursework.warehouse.controller.ui;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    ManagerUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.warehouse.model.Manager;
import edu.coursework.warehouse.model.Person;
import edu.coursework.warehouse.service.manager.impls.ManagerServiceImpl;
import edu.coursework.warehouse.service.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/manager")
@Controller
public class ManagerUIController {

    @Autowired
    ManagerServiceImpl managerService;

    @Autowired
    PersonServiceImpl personService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Manager> managerList = managerService.getAll();
        model.addAttribute("managerList", managerList);

        return "manager/managerList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Manager manager = managerService.getById(id);
        model.addAttribute("manager", manager);

        List<Person> personIdList = personService.getAll();
        model.addAttribute("personIdList", personIdList);
        return "manager/updateManager";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @ModelAttribute("employee") @RequestBody Manager manager) {

        manager.setPerson(personService.getAll().get(Integer.parseInt(manager.getPerson().getId()) - 1));
        managerService.update(manager);
        return "redirect:/ui/manager/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Manager manager = new Manager();
        model.addAttribute("manager", manager);

        List<Person> personIdList = personService.getAll();
        model.addAttribute("personIdList", personIdList);
        return "manager/newManager";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Manager manager) {

        manager.setPerson(personService.getAll().get(Integer.parseInt(manager.getPerson().getId()) - 1));
        double salary = manager.getSalary();
        int numberOfWorks = manager.getNumberOfWorks();
        /*List<Plane> planes = planeService.getAll();*/

        if (salary > 0 && numberOfWorks > 0) {
            model.addAttribute("manager", managerService.create(manager));
            return "redirect:/ui/manager/get/all";
        }
        return "redirect:/ui/manager/showNewForm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        managerService.delete(id);
        return "redirect:/ui/manager/get/all";
    }
}
