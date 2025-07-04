public class ShippableProduct extends Product implements Shippable_Interface {
    private final double weight;

    public ShippableProduct(String name, double price, int quantity, double weighty){
        super(name, price, quantity);
        if(weighty < 0){
            throw new IllegalArgumentException("Weight must be Positivee");
        }
        this.weight=weighty;
    }

    @Override
    public double getWeight() {
        // TODO Auto-generated method stub
        return this.weight;
    }

}
