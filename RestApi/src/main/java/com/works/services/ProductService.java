package com.works.services;

import com.works.configs.Util;
import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ResponseEntity addProduct(Product product) {
        productRepository.save(product);
        return Util.success(product);
    }

    public ResponseEntity productList() {
        List<Product> products = productRepository.findAll();
        return Util.success(products);
    }

    public ResponseEntity delete(String pid) {
        try {
            long id = Long.parseLong(pid);
            Optional<Product> product = productRepository.findById(id);
            if (product.isPresent()) {
                Product pro = product.get();
                productRepository.deleteById(id);
                return Util.success(pro);
            }
            return Util.fail(pid + " Not Product!",HttpStatus.BAD_REQUEST );
        }catch (Exception e) {
            return Util.fail(pid + " Not Valid!",HttpStatus.BAD_REQUEST );
        }
    }


    public ResponseEntity update(Product product) {
        Optional<Product> optionalProduct = productRepository.findById(product.getPid());
        if(optionalProduct.isPresent()) {
            productRepository.saveAndFlush(product);
            return Util.success(product);
        }
        return Util.fail("Update Fail",HttpStatus.BAD_REQUEST );
    }

    public ResponseEntity allAdd(List<Product> productList) {
        List<Product> ls = productRepository.saveAll(productList);
        return Util.success(ls);
    }

}
