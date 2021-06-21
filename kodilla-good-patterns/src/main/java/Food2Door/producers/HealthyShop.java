package Food2Door.producers;

import Food2Door.Producer;

public class HealthyShop extends Producer {

    private final String producerData = "HealthyShop";

    @Override
    protected boolean process(String producerData) {
        System.out.println("Order from " + getProducerData() + " is being proceed ...");
        return true;
    }

    @Override
    protected String getProducerData() {
        return producerData;
    }

    @Override
    public String toString() {
        return getProducerData();
    }
}
