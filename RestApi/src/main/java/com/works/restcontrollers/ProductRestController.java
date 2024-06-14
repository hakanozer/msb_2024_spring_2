package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductRestController {

    private final ProductService productService;

    @PostMapping("add")
    public ResponseEntity add(@Valid @RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("list")
    public ResponseEntity list() {
        return productService.productList();
    }

    @GetMapping("delete/{pid}")
    public ResponseEntity delete(@PathVariable String pid) {
        return productService.delete(pid);
    }

    @PutMapping("update")
    public ResponseEntity update(@Valid @RequestBody Product product) {
        return productService.update(product);
    }

    @PostMapping("addAll")
    public ResponseEntity addAll(@Valid @RequestBody List<Product> productList) {
        return productService.allAdd(productList);
    }

    @GetMapping("pageList")
    public ResponseEntity pageList(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return productService.pageList(pageNo, pageSize );
    }

    @GetMapping("search")
    public ResponseEntity search(
            @RequestParam("") String q,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "pid") String attr,
            @RequestParam(defaultValue = "asc") String type
    ) {
        return productService.search(q, pageNo, pageSize, attr, type);
    }

}
