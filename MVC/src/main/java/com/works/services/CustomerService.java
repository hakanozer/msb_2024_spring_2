package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository cRepo;
    final HttpServletRequest req;

    public boolean login(Customer customer) {
        Optional<Customer> optionalCustomer = cRepo.findByEmailEqualsAndPasswordEquals(customer.getEmail(), customer.getPassword());
        if (optionalCustomer.isPresent()) {
            Customer c = optionalCustomer.get();
            req.getSession().setAttribute("customer", c);
            return true;
        }
        return false;
    }


    public void logout() {
        req.getSession().removeAttribute("customer");
    }


}
