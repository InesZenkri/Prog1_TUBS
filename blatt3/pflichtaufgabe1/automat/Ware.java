package automat;

//Ab hier soll die Ware implementiert werden
public class Ware{
    private int id; //atributes sind alles private
    private String name;
    private int price;
    //meine konstruktor
    public Ware(int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    //set methoden
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(int price){
        this.price = price;
    }
    //get methoden 
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    //tostring funktion \' dient um '' zu schreiben 
    @Override
    public String toString() {
        return "Ware{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}