import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<Product,Integer> itemsOrdered = new HashMap<>(); 

    public void add(Product product, int qty) {
        if (qty <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (!product.isProductAvailable()) throw new IllegalStateException("Product out of stock: " + product.getName());
        if (product instanceof Expirable_Interface) {
            Expirable_Interface exp = (Expirable_Interface) product;
            if (exp.isitExpired()) throw new IllegalStateException("Cannot add expired product: " + product.getName());
        }
        int current = itemsOrdered.getOrDefault(product, 0);
        if (qty + current > product.getQuantity()) {
            throw new IllegalStateException("Not enough stock for " + product.getName());
        }
        itemsOrdered.put(product, current + qty);
    }
    
    public Map<Product, Integer> getItems() {
        return Collections.unmodifiableMap(itemsOrdered);
    }
    public void clear() {
        itemsOrdered.clear();
    }
}
