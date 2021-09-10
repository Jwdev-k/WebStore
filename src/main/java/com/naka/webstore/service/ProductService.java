package com.naka.webstore.service;

import com.naka.webstore.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    void updateAllStock();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    Product getProductById(String productID);
    void addProduct(Product product);
    List<Product> getProdsByMultiFilter(String productCategory, Map<String,String> price, String brand);

}

