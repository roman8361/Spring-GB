package ru.kravchenko.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Roman Kravchenko
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String hello(Model uiModel ) {
        uiModel.addAttribute("name", "WORLD!!!");
        return "index";
    }



}
