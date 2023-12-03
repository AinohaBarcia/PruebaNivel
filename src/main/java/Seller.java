import java.util.ArrayList;
import java.util.*;

public abstract class Seller {

    protected String name;
    protected ArrayList<Items> listaItems;

    protected float wear;
    protected float tax;

    protected byte MAXITEMS;


    public Seller(String name) {
        this.name = name;
        listaItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public ArrayList<Items> getListaItems() {
        return listaItems;
    }

    public abstract ArrayList addItem(Items item) throws TooMuchProductsException;

    public Items showLowerItemPrice() {
        try {
            Items cheapestItem = listaItems.stream().min(Items::compareTo).get();
            return cheapestItem;
        }catch(Exception e){
            return null;
        }
    }
    public int searchItem (String name){

        boolean found = false;

        int position = -1;
        int index = 0;

        while (index < listaItems.size() && !found) {

            if (listaItems.get(index).getName().equals(name)) {
                position = index;
                found = true;
            }
            index++;
        }
        return position;
    }

    @Override
    public String toString() {
        return "Vendedor con nombre " + name ;
    }
}
