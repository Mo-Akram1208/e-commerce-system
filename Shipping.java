import java.util.List;
import java.util.Map;

public class Shipping {
    public static void send(Map<Product, Integer> items) {
        System.out.println("\n** Shipment notice **");
        double totalWeight = 0.0;

        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (product instanceof Shippable_Interface) {
                double weight = ((Shippable_Interface) product).getWeight();
                System.out.printf("%s x%d (%.2f kg each)%n", product.getName(), quantity, weight);
                totalWeight += weight * quantity;
            }
        }
        System.out.printf("Total weight: %.2f kg%n", totalWeight);
    }
}
