import java.time.LocalDate;

public class ExpirableShippableProduct extends Product implements Shippable_Interface , Expirable_Interface{
    private final LocalDate expiryDate;
    private final double weight;

    public ExpirableShippableProduct(String name, double price, int quantity, LocalDate expiry,double weighty) {
        super(name, price, quantity);
        this.expiryDate = expiry;
        if(weighty < 0){
            throw new IllegalArgumentException("Weight must be Positivee");
        }
        this.weight=weighty;
    }

    @Override
    public boolean isitExpired() {
        return expiryDate != null && expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public double getWeight() {
        // TODO Auto-generated method stub
        return this.weight;
    }

}
