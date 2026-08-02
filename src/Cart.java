import model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Product, Integer> items = new HashMap<>();

    public void add(Product product, int quantity) {
        items.put(product,quantity);
    }
}
