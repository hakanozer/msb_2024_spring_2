package com.works.restcontrollers;

import com.works.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class TestRestController {

    @GetMapping("/test")
    public Product test(){
        /*
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Eli Bilmem");
        map.put("age", 30);
         */
        Product product = new Product();
        product.setId(100);
        product.setName("Audi A5");
        product.setDescription("Audi A5 Description");
        product.setPrice(2500000);

        return product;
    }

}
