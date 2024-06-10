package com.works.controllers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {

    final CustomerService customerService;

    @GetMapping("")
    public String login(){
        return "login";
    }

    /*
    @PostMapping("userLogin")
    public String userLogin(@RequestParam String email, @RequestParam String password) {
        System.out.println(email);
        System.out.println(password);
        return "login";
    }
    */

    @PostMapping("userLogin")
    public String userLogin(Customer customer) {
        customerService.login(customer);
        System.out.println(customer);
        return "login";
    }

}
