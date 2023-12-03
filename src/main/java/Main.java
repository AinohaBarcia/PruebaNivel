import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {


        ArrayList<City> listCity = new ArrayList<>();
        City city = new City("Barcelona");
        City city2 = new City("London");
        listCity.add(city);
        listCity.add(city2);


        Merchant merchant =new Merchant("Ana");
        Merchant merchant1 = new Merchant("Pedro");
        Thief thief = new Thief("Emma");

        listCity.get(0).getListSeller().add(merchant);
        listCity.get(0).getListSeller().add(merchant1);
        listCity.get(0).getListSeller().add(thief);

        Items items = new Items("sarten","cocina", 22);
        Items items1 = new Items("pala","cocina", 5);
        Items items2 = new Items("vela", "bazar", 7);
        try {
            listCity.get(0).getListSeller().get(0).addItem(items);
            listCity.get(0).getListSeller().get(0).addItem(items1);
            listCity.get(0).getListSeller().get(1).addItem(items2);
        } catch (TooMuchProductsException e) {
            throw new RuntimeException(e);
        }
        Buyer buyer = new Buyer("Maria");
        listCity.get(0).getListBuyer().add(buyer);

        int cityIWant =  chooseCity(listCity);

        Menu menu = new Menu();
        try {
            menu.playMenu(cityIWant,listCity);
        } catch (TooMuchProductsException e) {
            throw new RuntimeException(e);
        }

    }

    public static void addCity (ArrayList<City> listCity,City city){
        listCity.add(city);
    }
    public static int chooseCity (ArrayList <City> listCity){
        String cityName = Utils.pideString("Con que ciudad quieres jugar hoy? Barcelona o London ");
        OptionalInt foundIndex = foundCityIndex(listCity, cityName);
        int index=0;

            if (foundIndex.isPresent()) {
                 index = foundIndex.getAsInt();
                System.out.println("Perfecto juguemos con " + cityName);

            } else {
                System.out.println("La ciudad con la que quieres jugar no existe");
            }
//todo capturar si ponene una ciudad que no existe

        return index;

    }
    public static OptionalInt foundCityIndex (ArrayList<City> listCity, String cityName){
        return IntStream.range(0, listCity.size())
                .filter(i -> listCity.get(i).getName().equals(cityName))
                .findFirst();
    }
}
