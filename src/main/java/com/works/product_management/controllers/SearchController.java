package com.works.product_management.controllers;

import com.works.product_management.services.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
SearchService service =new SearchService();
    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String q, Model model){
        model.addAttribute("products",service.products(q));
        model.addAttribute("search",q);
        return "search";
    }

}
