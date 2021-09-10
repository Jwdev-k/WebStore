package com.naka.webstore.controller;

import com.naka.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProdHeroTroller {
    @Autowired
    private ProductService productService;

    @RequestMapping("/products/{category}/{price}")
    public String getProdsByMultiFilter(Model model, @PathVariable("category") String productCategory, @MatrixVariable(pathVar="price") Map<String,String> price, @RequestParam(required = false) String brand) {
        model.addAttribute("products", productService.getProdsByMultiFilter(productCategory, price, brand));
        return "views/products";
    }
}

