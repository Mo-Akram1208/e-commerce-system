import java.time.LocalDate;

public class ExpirableProduct extends Product implements Expirable_Interface{
    private final LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiry) {
        super(name, price, quantity);
        this.expiryDate = expiry;
    }

    @Override
    public boolean isitExpired() {
        // if expiryDate is null -> non-expirable Product
        return expiryDate != null && expiryDate.isBefore(LocalDate.now());
    }
}
