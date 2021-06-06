package edu.coursework.warehouse.controller.ui;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    HeadUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.warehouse.model.Head;
import edu.coursework.warehouse.model.Person;
import edu.coursework.warehouse.service.head.impls.HeadServiceImpl;
import edu.coursework.warehouse.service.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/head")
@Controller
public class HeadUIController {

    @Autowired
    HeadServiceImpl headService;

    @Autowired
    PersonServiceImpl personService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Head> headList = headService.getAll();
        model.addAttribute("headList", headList);

        return "head/headList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Head head = headService.getById(id);
        model.addAttribute("head", head);

        List<Person> personIdList = personService.getAll();
        model.addAttribute("personIdList", personIdList);
        return "head/updateHead";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("head") @RequestBody Head head) {

        headService.update(head);
        return "redirect:/ui/head/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Head head = new Head();
        model.addAttribute("head", head);

        List<Person> personIdList = personService.getAll();
        model.addAttribute("personIdList", personIdList);
        return "head/newHead";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("head") @RequestBody Head head) {

        model.addAttribute("head", headService.create(head));
        return "redirect:/ui/head/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        headService.delete(id);
        return "redirect:/ui/head/get/all";
    }
}
