import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        //Add products to the system 
        ExpirableShippableProduct cheese = new ExpirableShippableProduct("cheese", 4, 10, LocalDate.now().plusDays(20), 0.5);

        ShippableProduct tv = new ShippableProduct("tv", 399, 12, 20);

        Product scratchCard = new Product("Scratch Card" , 1.0 , 20){};
    
        Customer customer = new Customer("Akram", 3600);
        Cart carty = new Cart();

        carty.add(scratchCard, 3);
        carty.add(cheese , 2);
        carty.add(tv, 3);
    
        new CheckoutService().checkout(customer, carty);

        
    }
}
