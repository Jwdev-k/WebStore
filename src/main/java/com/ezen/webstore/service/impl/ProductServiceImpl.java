package com.ezen.webstore.service.impl;

import com.ezen.webstore.domain.Product;
import com.ezen.webstore.domain.repository.ProductRepository;
import com.ezen.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
