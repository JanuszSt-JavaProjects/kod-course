package supply;

import java.util.List;

public class ShippingProcessor implements AdditionalActionProcessor {

    private final Producer producer;
    private Package packToSend;

    private boolean isAdditionalActionRequired;
    private String additionalActionDescription;

    private boolean isSendingSuccessful = false;

    public ShippingProcessor(Producer producer) {
        this.producer = producer;
    }

    public ShippingProcessor(Producer producer, boolean isAdditionalActionRequired, String additionalActionDescription) {
        this.producer = producer;
        this.isAdditionalActionRequired = isAdditionalActionRequired;
        this.additionalActionDescription = additionalActionDescription;
    }

    public void process(String destination, List<Product> productsList) {
        System.out.println("\n- Starting preparation process! \n");
        packagePreparation(producer, destination, productsList);
        packageSending();
        if (isAdditionalActionRequired) additionalAction(additionalActionDescription);
        isSendingSuccessful();
    }


    private void packagePreparation(Producer producer, String destination, List<Product> productsList) {
        packToSend = new Package(producer, destination, productsList);
        System.out.println("- New Package prepared!");
        System.out.println("- Package details: " + packToSend);
    }

    private void packageSending() {
        // sending logic
        System.out.println("\n- Package send!");
        isSendingSuccessful = true;
    }

    private void isSendingSuccessful() {
        System.out.println("- Is sending successful ?  : " + isSendingSuccessful);
    }

    @Override
    public void additionalAction(String additionalActionDescription) {

        // needed action and:
        System.out.println("\nNeeded additional action:  " + additionalActionDescription);
    }

}
