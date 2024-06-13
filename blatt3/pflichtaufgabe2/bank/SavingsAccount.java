package bank;

//Ab hier soll die Klasse SavingsAccount implementiert werden.
public class SavingsAccount extends Account{
    //setting attributes
    private static double min_balance = 100.0;
    private static double interest_rate = 0.3;
    //constructor for savings account
    public SavingsAccount(int accnum, double balance){
        super(accnum, balance);
        if (balance < min_balance) {
            System.out.println("You need to deposit atleast " + min_balance + " to open a savings account");
        }
    }
    @Override //overriding the withdraw method from the account class to check if the balance will be less than the minimum balance
    public double withdraw (double amount){
        if (getBalance() - amount < min_balance) {
            System.out.println("You can't withdraw " + amount + " from your account, your balance will be less than the minimum balance of " + min_balance);
            return 1.0;
        }
        else {
            return super.withdraw(amount);
        }
    }
    @Override //overriding the update method from the account class to update the balance with the interest rate
    public void update(){
        setBalance(getBalance() * interest_rate);
    }
}