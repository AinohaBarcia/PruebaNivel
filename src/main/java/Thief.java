import java.lang.reflect.Array;
import java.util.ArrayList;
public class Thief extends Seller{

    private final float wear = 25F;
    private final byte MAXITEMS = 3;
    public Thief(String name) {
        super(name);
    }

    public float getWear() {
        return wear;
    }

    public byte getMAXITEMS() {
        return MAXITEMS;
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


