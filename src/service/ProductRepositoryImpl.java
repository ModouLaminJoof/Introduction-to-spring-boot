package service;
import model.Category;
import model.Product;
import repository.ProductRepository;

import java.util.*;
import java.util.stream.Collectors;

public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return products.stream()
                .filter(p -> p.getCategory() == category)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}
