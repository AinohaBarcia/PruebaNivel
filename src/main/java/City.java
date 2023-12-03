import java.util.ArrayList;

public class City {

    private String name;
    private ArrayList<Seller> listSeller;
    private ArrayList<Buyer> listBuyer;

    public City(String name) {
        this.name = name;
        listSeller = new ArrayList<>();
        listBuyer = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Seller> getListSeller() {
        return listSeller;
    }

    public ArrayList<Buyer> getListBuyer() {
        return listBuyer;
    }

    public ArrayList<Seller> createSeller (byte typeSeller, String name){

        int position = saerchSeller(listSeller,name);

        if (position == -1) {
            switch (typeSeller){
                case 1:
                    Merchant merchant = new Merchant(name);
                    listSeller.add(merchant);
                    System.out.println("El vendedor " + name+ " ya está dado de alta");
                    break;
                case 2:
                    Thief thief = new Thief(name);
                    listSeller.add(thief);
                    System.out.println("El vendedor" + name+ " ya está dado de alta");
                    break;
                case 3:
                    CountryMan countryMan = new CountryMan(name);
                    listSeller.add(countryMan);
                    System.out.println("El vendedor" + name+ " ya está dado de alta");
                    break;

            }

        } else {
            System.out.println("Este vendedor ya existe");
        }

        return listSeller;
    }

    public void addItemSeller ( String nameSeller,String typeItem,String nameProduct, Float price) throws TooMuchProductsException {

        int position = saerchSeller(listSeller, nameSeller);

        if (position >= 0){
           try {
               Items item = new Items(nameProduct, typeItem, price);
               listSeller.get(position).addItem(item);
               System.out.println(" El producto " + nameProduct + " ha sido añadido al inventario");
           }catch (TooMuchProductsException e){
               System.out.println(e.getMessage());
           }
        }else {
            System.out.println("El vendedro " + nameSeller + " no existe");
        }

    }
    public void showLowerItemPrice(){
        Items menor = listSeller.get(0).showLowerItemPrice();
        for (int i=1;i<listSeller.size();i++){
            Items item = listSeller.get(i).showLowerItemPrice();
            if (item != null) {
                if (item.getPrice() <= menor.getPrice()) menor = item;
            }
        }

        System.out.println("El item menor es: "+ menor);
    }
    public void viewItemsSeller(String name){
        int position = saerchSeller(listSeller, name);
        if (position>=0){
            if (listSeller.get(position).listaItems.size() >=0) {
                listSeller.get(position).listaItems.forEach(e -> System.out.println(e));
            }else{
                System.out.println("La lista está vacia");
            }
        }else{
            System.out.println("No existe el vendedor");
        }
    }
    public void createBuyer (String name){

        int position = searchBuyer (listBuyer,name);

        if (position == -1) {
            Buyer buyer = new Buyer(name);
            listBuyer.add(buyer);
            System.out.println("El comprador con nombre " + name + " yq ha sido creado");
        }else {
            System.out.println("Este comprador ya existe");
        }
    }
  /* public void buyItem ( String name){
       int position = saerchSeller(listSeller,name);

       viewItemsSeller(name);

       String nameProduct = Utils.pideString("Que producto quieres comprar?");

       int positionItem = listSeller.get(position).searchItem(name);

       float price = listSeller.get(position).listaItems.get(positionItem).getPrice();

       float priceAfterTax= price + listSeller.get(position).listaItems.get(positionItem).
               taxPrice(listSeller.get(position).tax);

       float priceAfterWear = priceAfterTax - listSeller.get(position).listaItems.get(positionItem).
               porcentajeDeDesgaste(listSeller.get(position).wear);

       listSeller.get(position).listaItems.removeIf(elemento -> elemento.equals("nameProduct"));
       System.out.println("Has comprado " + nameProduct + " por un precio de " + priceAfterTax + " con impuestos");
    }*/

    public void viewItemsComprador (String name){
        int position = searchBuyer(listBuyer, name);
        if (position>=0){
            if (listBuyer.get(position).getItemsList() .size() >=0) {
                listBuyer.get(position).getItemsList().forEach(e -> System.out.println(e));
            }else{
                System.out.println("La lista está vacia");
            }
        }else{
            System.out.println("No existe el vendedor");
        }
    }
    public void showSellersfromCity(){
        if (listSeller.isEmpty()){
            System.out.println("No hay ningún vendedor en la ciudad");
        }else{
            getListSeller().forEach(e-> System.out.println(e));
        }
    }

    public void showBuyersFromCity(){
        if (listBuyer.isEmpty()){
            System.out.println("No hay ningún comprador en la ciudad");
        }else{
            getListBuyer().forEach(e-> System.out.println(e));
        }
    }
    /*public void showTypeItemsByAscPrice (String type){
        listSeller.
    }*/
    public  int searchBuyer(ArrayList<Buyer> listBuyer, String name) {

        boolean found = false;

        int position = -1;
        int index = 0;

        while (index < listBuyer.size() && !found) {

            if (listBuyer.get(index).getName().equals(name)) {
                position = index;
                found = true;
            }
            index++;
        }

        return position;
    }
    public static int saerchSeller(ArrayList<Seller> listSeller, String name) {

        boolean found = false;

        int position = -1;
        int index = 0;

        while (index <listSeller.size() && !found) {

            if (listSeller.get(index).getName().equals(name)) {
                position = index;
                found = true;
            }
            index++;
        }

        return position;
    }

}
