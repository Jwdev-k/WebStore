package com.naka.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import com.naka.webstore.domain.Product;

public interface ProductRepository {
    List<Product> getAllProducts();
    void updateStock(String productId, long noOfUnits);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    Product getProductById(String productID);
    void addProduct(Product product);
    List<Product> getProdsByMultiFilter(String productCategory, Map<String, String> price, String brand);
    List<Product> getProdsByMultiFilter2(String productCategory, Map<String, String> price);

}

