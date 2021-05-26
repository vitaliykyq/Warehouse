package edu.coursework.warehouse.controller.ui;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    HeadUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.warehouse.model.Head;
import edu.coursework.warehouse.service.head.impls.HeadServiceImpl;
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
        return "head/updateHead";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @ModelAttribute("employee") @RequestBody Head head) {

        /*head.setPerson(personService.getAll().get(Integer.parseInt(head.getPerson().getId()) - 1));*/
        headService.update(head);
        return "redirect:/ui/head/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Head head = new Head();
        model.addAttribute("head", head);
        return "head/newHead";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Head head) {
        /*head.setPerson(personService.getAll().get(Integer.parseInt(head.getPerson().getId()) - 1));*/
        model.addAttribute("head", headService.create(head));
        return "redirect:/ui/head/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        headService.delete(id);
        return "redirect:/ui/head/get/all";
    }
}
