import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public Menu() {

    }

    public  void  playMenu(int cityIwant, ArrayList<City>listCity) throws TooMuchProductsException {

        byte eleccion;
        boolean out = false;
        final byte MINIMO = 0;
        final byte MAXIMO = 10;

        do{
            System.out.println("\nMENU");
            eleccion = Utils.pideByte("1.-Crear vendedor\n2.-Añadir item de un vendedor\n3.-Mostrar el ítem más barato de " +
                    "todos los vendedores de una ciudad\n4.-Consultar los ítems de un vendedor\n" +
                    "5.-Crear un comprador\n6.-Realizar la compra de un ítem\n7.-Consultar los ítems de un Comprador"
                    + "\n8.- Consultar todos los vendedores que hay en una ciudad\n9.-Consultar todos los compradores " +
                    "que hay en una ciudad\n10.-Mostrar todos los ítems de un determinado tipo ordenados por precio " +
                    "(asc)\n0.-Salir de la aplicación");


            if(eleccion < MINIMO || eleccion > MAXIMO){
                System.out.println("Escoje una opcioón valida");
            }
            switch(eleccion){
                case 1:listCity.get(cityIwant).createSeller(Utils.pideByte("Que tipo de vendedor quieres crear:\n" +
                        "1.-Mercader\n2.-Ladrón\n3.-Granjero"), Utils.pideString("Dime el nombre del vendedor"));
                    break;
                case 2:listCity.get(cityIwant).addItemSeller(Utils.pideString("A que vendedor pertenece el producto"),
                        Utils.pideString("Que tipo de producto es?"), Utils.pideString("Dime el nombre del producto"),
                        Utils.pideFloat("Que precio tiene "));
                    break;
               case 3: listCity.get(cityIwant).showLowerItemPrice();
                    break;
                case 4: listCity.get(cityIwant).viewItemsSeller(Utils.pideString("De que vendedor quieres ver los productos"));
                    break;
                case 5:listCity.get(cityIwant).createBuyer(Utils.pideString("Dime el nombre del comprador"));
                    break;
             /*  case 6: listCity.get(cityIwant).buyItem(Utils.pideString("A que comprador quieres comprar?"));
                    break;*/
                case 7: listCity.get(cityIwant).viewItemsComprador(Utils.pideString("De quien quieres ver las compras"));
                    break;
                case 8: listCity.get(cityIwant).showSellersfromCity();
                    break;
                case 9: listCity.get(cityIwant).showBuyersFromCity();
                    break;
               /* case 10: listCity.get(cityIwant).showTypeItemsByAscPrice(Utils.pideString("De que tipo de producto" +
                        " quieres la información?"));
                    break;*/
                case 0: System.out.println("Thanks for playing");
                    out = true;
                    break;
            }


        }while(eleccion < MINIMO || eleccion > MAXIMO || !out);

    }
    public void createSeller (String name,String city,Byte maxItems, Float price, String type,float wear, ArrayList <Buyer> listaCompradores){
        //Thief thief = new Seller (name,city, maxItems ,price,wear,listaCompradores);
    }

    }



