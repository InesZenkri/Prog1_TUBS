package bank;

//Ab hier soll die Klasse Account implementiert werden.
public abstract class Account{
    private int accnum;
    private double balance;
    //constructor for account
    public Account(int accnum, double balance){
        this.accnum = accnum;
        this.balance = balance;
    }
    //getters for account number and balance
    public int getAccnum() {
        return accnum;
    }

    public double getBalance() {
        return balance;
    }
    //methods for depositing and withdrawing
    public double deposite(double amount){
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return balance;
        }
        else {
            balance += amount;
            return balance;
        }
    }
    public double withdraw(double amount){
        if (amount <= 0 || amount > balance) {
            System.out.println("You are broke :( you have only : " + balance + " in your account and you want to withdraw : " + amount + " from it");
            return balance;
        }
        else {
            balance -= amount;
            System.out.println("You have successfully withdrawn : " + amount + " from your account, your new balance is : " + balance);
            return balance;
        }
        
    }
    //abstract method for updating the account, abstract because the implementation is different for savings and current accounts
    public abstract void update();
    //setter for balance
    protected void setBalance(double balance) {
        this.balance = balance;
    }
}