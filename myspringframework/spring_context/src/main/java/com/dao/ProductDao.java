package com.dao;

import com.bean.Product;

public interface ProductDao {
    Product getProductDetails(int product_code);
}
