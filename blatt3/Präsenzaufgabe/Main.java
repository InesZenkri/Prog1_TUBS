package Präsenzaufgabe;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Door door1 = new Door("Front Door");
        Door door2 = new Door("Back Door");

        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            int action = rand.nextInt(4);

            switch (action) {
                case 0:
                    door1.open();
                    door2.open();
                    break;
                case 1:
                    door1.close();
                    door2.close();
                    break;
                case 2:
                    door1.lock();
                    door2.lock();
                    break;
                case 3:
                    door1.unlock();
                    door2.unlock();
                    break;
            }
        }
    }
}

