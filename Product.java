import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class Product{

    protected final String name;
    protected final double price;
    protected int quantity;


    public Product(String name, double price, int quantity) {
        if (price < 0) throw new IllegalArgumentException("Price must be positive");
        if (quantity < 0) throw new IllegalArgumentException("Quantity must be positive");
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void quantityReduction(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > quantity) {
            throw new IllegalArgumentException("Reducing more than you Ordered " + amount);
        }
        quantity -= amount;
    }

    public boolean isProductAvailable() {
        return quantity > 0 ? true : false;
    }
}