package com.naka.webstore.controller;

import com.naka.webstore.domain.repository.ProductRepository;
import com.naka.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("market")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "views/products"; // 뷰 이름 반환
    }

    @RequestMapping("/products/update/stock")
    public String updateStock(Model model) {
        productService.updateAllStock();
        return "redirect:market/products";
    }

    @RequestMapping("/products/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
// @PathVariable String category) {
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        // productService.getProductsByCategory(category));
        return "views/products";
    }

    @RequestMapping("/products/filter/{params}")
    public String getProductsByFilter(@MatrixVariable(pathVar="params") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "views/products";
    }

    @RequestMapping("/product") // 7절 실습
    public String getProductById(
            @RequestParam("id") String productId, Model model) {
        model.addAttribute("product",
                productService.getProductById(productId));
        return "views/product";
    }


}

