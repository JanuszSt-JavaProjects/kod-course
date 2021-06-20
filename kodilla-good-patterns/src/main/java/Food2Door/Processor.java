package Food2Door;

import java.util.List;

public class Processor {
    private final Producer producer;
    private final Order order;
    private final Dispatch dispatch;

    public Processor(Producer producer, List<Product> productList, String destination) {
        this.producer = producer;
        order = new Order(producer, productList);
        dispatch = new Dispatch(destination, order);
    }

    void execute() {
        System.out.println(order);
        if (producer.process(producer.getProducerData())) {
            System.out.println("Order Confirmed !");
            ;
        } else {
            System.out.println("Order UNREALIZED !");
        }
        dispatcher();
    }


    private void dispatcher() {
        System.out.println(
                order + "\nhas been sent to: " + dispatch.getDestination()
        );
    }

}
