package com.works.product_management.controllers;

import com.works.product_management.props.Products;
import com.works.product_management.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @PostMapping("/productSave")
    public String productSave(Products products){
        ProductService service = new ProductService();
        int status = service.productAdd(products);
        return "home";
    }
}
