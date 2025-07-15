package services;

import models.Product;
import java.util.*;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(String name, double price, String category) {
        products.add(new Product(name, price, category));
    }

    public boolean updateProduct(int id, String name, double price, String category) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(name);
                p.setPrice(price);
                p.setCategory(category);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        return products.removeIf(p -> p.getId() == id);
    }

    public List<Product> getAllProducts() { return products; }

    public Product getProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }
}
