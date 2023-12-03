import java.lang.reflect.Array;
import java.util.ArrayList;

public class Merchant extends Seller {
    private final float TAX = 4F;
    private final byte MAXITEMS = 7;

    public Merchant(String name) {
        super(name);
        //TODO COMPROBAR QUE SE INICIALIZA EL ARRAY
    }

    public float getTAX() {
        return TAX;
    }

    @Override
    public ArrayList addItem(Items item) throws TooMuchProductsException {
        if (listaItems.size() <= MAXITEMS) {
            listaItems.add(item);
        } else {
            throw new TooMuchProductsException("El inventario no admite mas productos. Vende antes de añadir nuevos");
        }
        return listaItems;
    }
}


