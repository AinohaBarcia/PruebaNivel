import java.util.*;
public class Items implements Comparable <Items>{
    private String name;
    private String type;
    private float price;

    public Items(String name, String type, float price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float taxPrice(float tax){
        float totalTax;
        totalTax=(tax*price)/100;
        float totalprice;
        totalprice = price + totalTax;

        return totalprice;
    }
    public float porcentajeDeDesgaste ( float wear) {
       float discount = (wear*price)/100;
       float finalPrice = price - discount;
        return finalPrice;

    }
    public int compareTo(Items item) {
        return (int)(this.price*100 - item.getPrice()*100);
    }

    @Override
    public String toString() {
        return "El producto " +
                "'" + name + '\'' +
                ", es de tipo'" + type + '\'' +
                " y tiene un precio de: " + price + " €";
    }
}
