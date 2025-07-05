import java.util.List;

public class CheckoutService {
    private static final double SHIPPING_RATE = 5.0;

    public void checkout(Customer customer, Cart cart) {
        if (cart.getItems().isEmpty()) throw new IllegalStateException("Cart is empty");

        double subtotal = 0;
        double total = 0;
        for (var entry : cart.getItems().entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            subtotal += p.getPrice() * qty;
            if (p instanceof Shippable_Interface) {
                total += ((Shippable_Interface) p).getWeight() * qty;
            }
        }
        double shippingFee = total * SHIPPING_RATE;
        double totalMoney = subtotal + shippingFee;

        if (customer.getBalance() < totalMoney) {
            throw new IllegalStateException("Insufficient funds");
        }

        // Deduct balance & reduce stock
        customer.withdrawMoney(totalMoney);
        for (var entry : cart.getItems().entrySet()) {
            entry.getKey().quantityReduction(entry.getValue());
        }

        Shipping.send(cart.getItems());

        cart.clear();

        Receipt.print(subtotal, shippingFee, totalMoney);
    }
}
