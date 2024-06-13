package bank;

//Ab hier soll die Klasse CurrentAccount implementiert werden.
public class CurrentAccount extends Account {
    //setting attributes
    private static final double limit= -1000.0;
    public CurrentAccount(int accnum, double balance){
        super(accnum, balance);
    }
    //withdraw method for current account
    @Override //overriding the withdraw method from the account class to check if the balance will be less than the limit
    public double withdraw(double amount){
        if (getBalance() - amount < limit) {
            System.out.println("You can't withdraw " + amount + " from your account, your balance will be less than the limit of " + limit);
            return 1.1;
        }
        else {
            return super.withdraw(amount);
        }
    }
    @Override //overriding the update method from the account class to check if the balance is negative
    public void update(){
        if (getBalance() < 0){
            System.out.println("Acount number : " + getAccnum()+ " has a negative balance of : " + getBalance() + "is overdown :(");
        }
    }
}