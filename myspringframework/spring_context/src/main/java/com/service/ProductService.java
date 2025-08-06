package com.service;

import com.bean.Product;
import com.dao.ProductDao;

public class ProductService {
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product getProductDetails(int product_code) {
        return productDao.getProductDetails(product_code);
    }

    public double calculatePrice(int quantity, double product_price) {
        return quantity * product_price;
    }

    public boolean validateProductCode(int product_code) {
        return (product_code > 0 && (product_code >= 1000 && product_code <= 9999));
    }

    public boolean validateQuantity(int quantity) {
        return quantity > 0;
    }
}
