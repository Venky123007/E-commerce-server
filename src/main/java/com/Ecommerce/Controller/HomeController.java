package com.Ecommerce.Controller;

import com.Ecommerce.model.Home;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {

    @GetMapping
    public Home home(){
        Home home = new Home();

        home.setMessage("Welcome to Ecommerce Backend...!");
        home.setStatus("true");

        return home;
    }
}
