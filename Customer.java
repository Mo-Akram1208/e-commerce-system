
public class Customer {
    private final String name;
    private double balance;

    public Customer(String name , double money) {
        if(money < 0 ) throw new IllegalArgumentException("Balance deposited must be positive");
        this.balance=money;
        this.name=name;
    }

    public double getBalance() {
        // TODO Auto-generated method stub
        return this.balance;
    }
    public String getName(){
        return this.name;
    }

    public void withdrawMoney(double amount){
        if(this.balance < amount){
            throw new IllegalArgumentException("Balance is insufficient");
        }
        else if(amount < 0){
            throw new IllegalArgumentException("Balance must be positive");
        }

        balance-=amount;
    } 
}
