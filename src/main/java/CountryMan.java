import java.lang.reflect.Array;
import java.util.ArrayList;

public class CountryMan extends Seller{
    private final float wear = 15F;
    private final float tax = 2F;
    private final byte MAXITEMS = 5;

    public CountryMan(String name) {
        super(name);
    }

    public float getWear() {
        return wear;
    }

    public float getTax() {
        return tax;
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
