package edu.coursework.warehouse.controller.ui;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    PersonUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/


import edu.coursework.warehouse.model.Person;
import edu.coursework.warehouse.service.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/person")
@Controller
public class PersonUIController {

    @Autowired
    PersonServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Person> personList = service.getAll();
        model.addAttribute("personList", personList);

        return "person/personList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Person person = service.getById(id);
        model.addAttribute("person",person);
        return "person/updatePerson";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "person/newPerson";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Person person) {
        String name = person.getName();
        String surname = person.getSurname();
        int age = person.getAge();
        List<Person> personList = service.getAll();

        if (name != null && name.length() > 0 && surname != null && surname.length() > 0
                && age > 0) {
            model.addAttribute("person", service.create(person));
            return "redirect:/ui/person/get/all";
        }
        return "redirect:/ui/person/showNewForm";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Person person) {

        service.update(person);
        return "redirect:/ui/person/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/person/get/all";
    }
}
