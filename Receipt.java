public class Receipt {
    public static void print(double subtotal, double shippingFee, double total) {
        System.out.println("\n** Checkout receipt **");
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Shipping: $%.2f\n", shippingFee);
        System.out.printf("Total: $%.2f\n", total);
    }
}