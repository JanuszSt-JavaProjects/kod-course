package supply;

import java.util.List;

public class Package {
    private Producer producer;
    private String destination;
    private List<Product> productsList;

    public Package(Producer producer, String destination, List<Product> productsList) {
        this.producer = producer;
        this.destination = destination;
        this.productsList = productsList;
    }


    @Override
    public String toString() {
        return "Package{" +
                "producer=" + producer +
                ", destination='" + destination + '\'' +
                ", productsList=" + productsList +
                '}';
    }
}
