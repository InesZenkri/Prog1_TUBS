package automat;

//Ab hier soll das Muenzsystem implementiert werden
public class Muenzsystem {
    private int[] validCoins;// my atributes 
    private int[] currentCoins;
    //my konstructer 
    public Muenzsystem(){
        this.validCoins = new int[]{1,2,5,10,20,50,100,200};
        this.currentCoins = new int[validCoins.length];
    }
    //get methoden
    public int[] getValidCoins(){
        return validCoins;
    }
    public int[] getCurrentCoins(){
        return currentCoins;
    }
    //printCoins methode 
    public void printCoins(){
        for (int i = 0; i < validCoins.length; i++) {
            System.out.println("Münze mit Wert " + validCoins[i] + " wurde " + currentCoins[i] + " mal eingeworfen.");
        }
    }
    //Insert function
    public boolean insert(int coin){
        for (int i = 0; i < validCoins.length; i++) {
            if (validCoins[i] == coin) {
                currentCoins[i]++;
                System.out.println("Münze mit Wert " + coin + " eingeworfen.");
                return true;
            }
        }
        int insertedAmount = calculateInsertedAmount();
        System.out.println(coin + " ist eine ungültige Münze! Bitte nur Münzen mit den Werten 1, 2, 5, 10, 20, 50, 100 und 200 verwenden.");
        System.out.println( insertedAmount + " Cent werden zuruckgegeben :)");
        return false;

    }
    //buy function
    public boolean buy(int price){
        int insertedAmount = calculateInsertedAmount();
        if (insertedAmount >= price) {
            System.out.println("Kauf erfolgreich :) Ihr Wechselgeld beträgt: " + (insertedAmount - price));
            reset();
            return true;
        } else {
            System.out.println("Kauf unerfolgreich :( \nsie haben " + insertedAmount + " Cent eingeworfen, aber Ihr gewählter Artikel kostet " + price + " Cent, sie brauchen noch " + (price - insertedAmount) + " Cent.");
            return false;
        }
    }
    //to calculate how much money the buyer already inserted
    // i will use this function in the buy function, in order to check if the buyer inserted enough money
    // i will use it in the insert function, to inform the buyer how much money the machine will give him back if he inserted an invalid coin
    // i will also use it in Automat.java to inform the buyer how much money he already inserted thats why it has public access modifier and not private
    public  int calculateInsertedAmount(){
        int sum = 0;
        for (int i = 0; i < validCoins.length; i++) {
            sum += validCoins[i] * currentCoins[i];
        }
        return sum;
    }
    //reset method
    public void reset(){
        for (int i = 0; i < validCoins.length; i++) {
            currentCoins[i] = 0;
        }
    }
}