package repository;

import model.Category;
import model.Product;

import java.util.List;

public interface ProductRepository{
    void addProduct(Product product);

    void add(Product product);
    Product findById(int id);
    List<Product> findAll();
    List<Product> findByCategory(Category category);
    void delete(int id);
}
