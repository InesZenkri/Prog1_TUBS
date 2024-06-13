package bank;
import bank.Account;
//Ab hier soll die Klasse Bank implementiert werden.
public class Bank {
    //setting attributes
    private static final int max_accounts = 30;
    private Account[] accounts = new Account[0];
    private int next_acc_num = 0;
    //constructor for bank
    public int open (boolean isSavingsAcount){
        if(accounts.length >= max_accounts){
            System.out.println("Bank is full, can't open more accounts");
            return -1;
        }
        Account acc;
        if (isSavingsAcount){
            acc = new SavingsAccount(next_acc_num, 100.0);// Initial balance 100.0 for savings
        }
        else {
            acc = new CurrentAccount(next_acc_num, 0.0); //Initial balance 0.0 for current
        }
        //add account to the array by using a temparray and copying the elements of the old array to it and then adding the new account
        Account[] temp = new Account[accounts.length + 1];
        for (int i = 0; i < accounts.length; i++) {
            temp[i] = accounts[i];
        }
        temp[accounts.length] = acc;
        accounts = temp;

        return next_acc_num++;
    }
    //close account method
    public boolean close(int accum){
        if (accum < 1 || accum > next_acc_num){
            System.out.println("Invalid account number");
            return false;
        }
        if (accounts[accum - 1] == null){
            System.out.println("Account already closed");
            return false;
        }
        accounts[accum - 1] = null;
        return true;
    }
    //deposit method to deposit to an account
    public boolean deposite(int accum, double amount){
        if (accum < 1 || accum > next_acc_num){
            System.out.println("Invalid account number");
            return false;
        }
        if (accounts[accum - 1] == null){
            System.out.println("Account is closed");
            return false;
        }
        return accounts[accum - 1].deposite(amount) > 0;
    }
    //withdraw method to withdraw from an account
    public boolean withdraw(int accum, double amount){
        if (accum < 1 || accum > next_acc_num){
            System.out.println("Invalid account number");
            return false;
        }
        if (accounts[accum - 1] == null){
            System.out.println("Account is closed");
            return false;
        }
        return accounts[accum - 1].withdraw(amount) > 0;
    }
    //update method to update all accounts in the bank
    public void update(){
        for (Account account : accounts) {
            if (account != null){
                account.update();
            }
        }
    }
    //print method to print all accounts in the bank
    public void print(){
        for (Account account : accounts) {
            if (account != null){
                System.out.println("Account number : " + account.getAccnum() + " has a balance of : " + account.getBalance());
            }
        }
    }
    //getter for accounts
    public Account[] getAccounts() {
        return accounts;
    }
    //getter for next_acc_num
    public int getNext_acc_num() {
        return next_acc_num;
    }
}