package Fly_company;

public class Main {
    public static void main(String[] args) {

        ConnectionFinder finder = new ConnectionFinder();

        System.out.println("\nall connections to WARSZAWA: ");
        finder.connectionToCity(new City("WARSZAWA"));

        System.out.println("\nall connections FROM KATOWICE: ");
        finder.connectionFromCity(new City("KATOWICE"));

        System.out.println("\ndirect connection from WARSZAWA to OPOLE: ");
        finder.directConnectionFind(new City("WARSZAWA"), new City("OPOLE"));

        System.out.println("\nindirect connections:");
        finder.indirectConnectionFind(new City("GDYNIA"), new City("KRAKOW"));
        finder.indirectConnectionFind(new City("WARSZAWA"), new City("KATOWICE"));
    }
}
