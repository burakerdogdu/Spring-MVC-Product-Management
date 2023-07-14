package com.works.product_management.controllers;

import com.works.product_management.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductListController {
    @GetMapping("/productlist")
    public String productList(Model model){
        ProductService service = new ProductService();

        model.addAttribute("products",service.getProducts());
        return "productlist";
    }
}
