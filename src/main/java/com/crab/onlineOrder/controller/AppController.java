package com.crab.onlineOrder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/projects/web_projects/crab_eats/demo/**")
    public String index() {
        return "forward:/projects/web_projects/crab_eats/index.html";
    }
}
