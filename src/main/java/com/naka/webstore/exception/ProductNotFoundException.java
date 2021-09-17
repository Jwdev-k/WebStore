package com.naka.webstore.exception;

import com.naka.webstore.domain.Product;

import java.util.List;

public class ProductNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -694354952032299587L;
    private String productId;


    public ProductNotFoundException(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
