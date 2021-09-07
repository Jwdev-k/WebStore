package com.ezen.webstore.controller;

import com.ezen.webstore.domain.Product;
import com.ezen.webstore.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @RequestMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "views/products"; // 뷰 이름 반환
    }
}

