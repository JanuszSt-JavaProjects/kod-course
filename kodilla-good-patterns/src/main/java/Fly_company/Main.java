package Fly_company;

public class Main {
    public static void main(String[] args) {

        ConnectionFinder finder = new ConnectionFinder();

        System.out.println("\nall connections to WARSZAWA: ");
        System.out.println(finder.connectionToCity(new City("WARSZAWA")).size());

        System.out.println("\nall connections FROM KATOWICE: ");
        finder.connectionFromCity(new City("KATOWICE"));

        System.out.println("\ndirect connection from WARSZAWA to OPOLE: ");
        finder.findDirectConnection(new City("WARSZAWA"), new City("OPOLE"));

        System.out.println("\nindirect connections:");
        finder.findIndirectConnection(new City("GDYNIA"), new City("KRAKOW"));
        System.out.println(finder.findIndirectConnection(new City("WARSZAWA"), new City("KATOWICE")).size());
    }
}
