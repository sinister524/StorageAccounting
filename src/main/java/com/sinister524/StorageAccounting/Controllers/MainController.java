package com.sinister524.StorageAccounting.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String index () {
        return "index";
    }

    @GetMapping("/info")
    public String info () {
        return "info";
    }

}
