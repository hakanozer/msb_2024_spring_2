package com.works.controllers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    public String userLogin(@Valid Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            model.addAttribute("errors", errors);
        }else {
            boolean status = customerService.login(customer);
            if (status) {
                return "redirect:/dashboard";
            }else {
                model.addAttribute("error", "E-Mail or Password is incorrect");
            }
        }
         return "login";
    }

}
