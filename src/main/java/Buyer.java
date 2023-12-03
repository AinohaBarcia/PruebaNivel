import java.util.ArrayList;

public class Buyer {
    private String name;
    private ArrayList<Items> itemsList;

    public Buyer(String name) {
        this.name = name;
        itemsList = new ArrayList<Items>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayList<Items> itemsList) {
        this.itemsList = itemsList;
    }

    @Override
    public String toString() {
        return "Comprador con nombre " + name;

    }
}
