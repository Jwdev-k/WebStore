package com.naka.webstore.service.impl;

import com.naka.webstore.domain.Product;
import com.naka.webstore.domain.repository.ProductRepository;
import com.naka.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void updateAllStock() {
        List<Product> allProducts = productRepository.getAllProducts();

        for (Product product : allProducts) {
            if (product.getUnitsInStock() < 500) {
                productRepository.updateStock(product.getProductId(),
                        product.getUnitsInStock() + 1000);
            }
            if (product.getUnitsInStock() > 300) {
                productRepository.updateStock(product.getProductId(),
                        product.getUnitsInStock() + -500);
            }
        }
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }

    public List<Product> getProductsByFilter(
            Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    public Product getProductById(String productID) {
        return productRepository.getProductById(productID);
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public List<Product> getProdsByMultiFilter(String productCategory, Map<String, String> price, String brand) {
        return productRepository.getProdsByMultiFilter(productCategory, price, brand);
    }
}
