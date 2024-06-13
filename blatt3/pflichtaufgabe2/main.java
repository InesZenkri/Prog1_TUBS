
import java.util.Random;
import bank.Bank;
import bank.Account;
public class Main{
    
    public static void main(String[] args){
        /*
         * Ab hier soll die main-Methode, wie auf dem Aufgabenblatt beschrieben, implementiert werden.
         */
        //create a bank
        Bank bank = new Bank();
        bank.print(); //print the bank
        Random rand = new Random();//create a random object
        //cteate 20 accounts
        for (int i = 0; i < 20; i++) {
            boolean isSavings = rand.nextBoolean();
            bank.open(isSavings);
        }
        //deposit 1000 to each account (3 times)
        for (int i = 0; i < 3; i++) {
            for (Account account : bank.getAccounts()) {
                if (account != null) {
                    double amount = 1000 * rand.nextDouble();
                    bank.deposite(account.getAccnum(), amount);
                }
            }
       
        //withdraw 3 times from each account
            for (Account account : bank.getAccounts()) {
                if (account != null) {
                    double amount = 500 * rand.nextDouble();
                    bank.withdraw(account.getAccnum(), amount);
                }
            }
        }
        //update all accounts
        bank.update();
        //print the bank
        bank.print();
        //close 2 accounts
        if (bank.getAccounts()[0] != null){ //check if the account exists
            bank.close(1); 
        if (bank.getAccounts()[1] != null) {
            bank.close(2); 
        }
        bank.print();
    }
    }
}