package service;

import java.util.List;
import model.Category;
import model.Product;
import repository.ProductRepository;


public class ProductService {

    private ProductRepositoryImpl repository;

    public ProductService(ProductRepository repository) {
        this.repository = (ProductRepositoryImpl) repository;
    }

    public void addProduct(Product product) {
        repository.add(product);
    }

    public Product findById(int id) {
        return repository.findById(id);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public List<Product> findByCategory(Category category) {
        return repository.findByCategory(category);
    }

    public void updateProduct(int id, String name) {
        Product product = repository.findById(id);

        if (product != null) {
            product.setName(name);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public List<Product> getProductsInStock() {
        return repository.findAll()
                .stream()
                .filter(product -> product.getStockQuantity() > 0)
                .toList();
    }
}