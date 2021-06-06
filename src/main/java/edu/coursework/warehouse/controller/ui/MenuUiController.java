package edu.coursework.warehouse.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/ui/menu")
@Controller
public class MenuUiController {

    @RequestMapping()
    public String showAll(){ return "menu/menu"; }

    @RequestMapping("/requests")
    public String getRequests(){ return "menu/requests"; }

}
