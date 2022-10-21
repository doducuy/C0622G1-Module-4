package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new LinkedHashMap<>();
        products.put(1, new Product(1, "Iphone3", "Apple", "American Tho"));
        products.put(2, new Product(2, "RedMi Note 8", "Xiaomi", "Chinese"));
        products.put(3, new Product(2, "Nokia 1280", "Nokia", "ThaiLand"));
        products.put(4, new Product(2, "Huawei 700", "Huawei", "Chinese"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productListByName = new ArrayList<>();
        for (Product product: products.values()
             ) {
            if(product.getName().contains(name)){
                productListByName.add(product);
            }
        }
        return productListByName;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
