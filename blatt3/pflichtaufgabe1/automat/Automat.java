package automat;
//Ab hier soll der Automat implementiert werden.
public class Automat{
    private Muenzsystem ms ;
    private Ware[] waren;
    public Automat(String[] warenNamen, int[] warenPreise){
        ms = new Muenzsystem();
        waren = new Ware[warenNamen.length];
        for(int i = 0; i < warenNamen.length; i++){
            waren[i] = new Ware(i, warenNamen[i], warenPreise[i]);
        }
    }
    public void printWare(){
        System.out.println("Verfügbare Waren:");
        for(int i = 0; i < waren.length; i++){
            System.out.println(waren[i].toString());
        }
    }
    public boolean select(int id){
        for (Ware ware : waren) {
            if (ware.getId() == id) {
                System.out.println("Sir haben " + ware.getName() + " ausgewählt, es kostet " + ware.getPrice() + " Cent und sie haben " + ms.calculateInsertedAmount() + " Cent eingeworfen.");
                return ms.buy(ware.getPrice());
            }
        }
        System.out.println("Ware mit der ID " + id + " nicht gefunden.");
        return false;
    }

    public boolean insert(int coin){
        return ms.insert(coin);
    }
    public void reset(){
        ms.reset();
    }
}
