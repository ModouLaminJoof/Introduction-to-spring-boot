import model.Category;
import model.Product;
import repository.ProductRepository;
import service.ProductRepositoryImpl;
import service.ProductService;

import java.util.Comparator;
import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ProductRepository repo = new ProductRepositoryImpl();
        ProductService service = new ProductService(repo);
        

            while(true){
                System.out.println("\n1. Add Product");
                System.out.println("2. List Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Filter Category");
                System.out.println("6. In Stock");
                System.out.println("7. Exit");

                int choice = input.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Enter product Id: ");
                        int id = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter product name: ");
                        String name = input.nextLine();
                        System.out.println("Enter product description: ");
                        String description = input.nextLine();
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(input.nextLine());
                        System.out.println("Enter product quantity: ");
                        int quantity = input.nextInt();

                        System.out.println("0-ELECTRONICS");
                        System.out.println("1-CLOTHING");
                        System.out.println("2-BOOKS");
                        System.out.println("3-HOME");
                        System.out.println("4-OTHER");

                        Category category = Category.values()[input.nextInt()];

                        service.addProduct(new Product(id, name, description, price, quantity, category));
                        System.out.println("Saved");
                        System.out.println(service.findAll().size());
                        break;
                    case 2:
                        service.findAll().stream()
                                .sorted(Comparator.comparing(Product::getName))
                                .forEach(System.out::println);
                        break;
                    case 3:
                        System.out.println("Product Id: ");
                        Product p = service.findById(input.nextInt());

                        if (p != null) {
                            input.nextLine();
                            System.out.println("New product name: ");
                            p.setName(input.nextLine());
                            System.out.println("Product name changed successfully");
                        }
                        break;
                    case 4:
                        System.out.println("Product Id: ");
                        service.delete(input.nextInt());
                        System.out.println("Product deleted successfully");
                        break;
                    case 5:
                        System.out.println("0-ELECTRONICS");
                        System.out.println("1-CLOTHING");
                        System.out.println("2-BOOKS");
                        System.out.println("3-HOME");
                        System.out.println("4-OTHER");

                        Category c = Category.values()[input.nextInt()];

                        service.findByCategory(c).forEach(System.out::println);
                        break;
                    case 6:
                        service.findAll().stream()
                                .filter(x -> x.getStockQuantity() > 0)
                                .toList()
                                .forEach(System.out::println);
                        break;
                    case 7:
                        return;
                }
            }
    }
}

