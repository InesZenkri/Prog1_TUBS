//import automat.Automat; //Diese Stelle auskommentieren, wenn man Automat-Methoden aufrufen bzw Objekte erzeugen möchte
import automat.*;
public class main{
    
    public static void main(String[] args){
        // (i) Automaten mit mindestens 5 Waren erstellen
        String[] warenNamen = {"Schokolade", "Chips", "Gezouz","Wasser","Club mate"};
        int[] warenPreise = {100, 150, 200, 50, 250};
        Automat automat = new Automat(warenNamen, warenPreise);
        // (ii) Waren auf der Konsole ausgeben
        automat.printWare();
        // (iii) Mindestens 3 Münzen einwerfen (inkl. ungültige Münze)
        automat.insert(10); // gültige Münze
        automat.insert(50); // gültige Münze
        automat.insert(500); // ungültige Münze
        // (iv) Reset anfordern, um gültig eingeworfene Münzen zurückzuerhalten
        automat.reset();
        // (v) Genügend gültige Münzen einwerfen, um eine Ware zu kaufen
        automat.insert(100); // gültige Münze
        automat.insert(50); // gültige Münze
        automat.select(1); // Kauf der ersten Ware
    }
}
