package Fly_company;

import java.util.HashSet;
import java.util.Set;

public class TemporaryDatabase_Connections implements Connections {


    @Override
    public Set<Connection> getConnections() {

        City warszawa = new City("WARSZAWA");
        City warszawa2 = new City("WARSZAWA2");
        City gdansk = new City("GDANSK");
        City gdynia = new City("GDYNIA");
        City szczecin = new City("SZCZECIN");
        City opole = new City("OPOLE");
        City krakow = new City("KRAKOW");
        City wroclaw = new City("WROCLAW");
        City katowice = new City("KATOWICE");

        Set<Connection> connections = new HashSet<>();

        connections.add(new Connection(warszawa2, opole));

        connections.add(new Connection(warszawa, opole));
        connections.add(new Connection(opole, katowice));

        connections.add(new Connection(gdynia, katowice));
        connections.add(new Connection(katowice, krakow));

        connections.add(new Connection(wroclaw, katowice));
        connections.add(new Connection(katowice, gdansk));

        connections.add(new Connection(opole, szczecin));
        connections.add(new Connection(opole, warszawa));
        connections.add(new Connection(gdynia, warszawa));


        return new HashSet<>(connections);
    }

}
