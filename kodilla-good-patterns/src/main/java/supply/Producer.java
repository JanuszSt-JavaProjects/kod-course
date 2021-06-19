package supply;

public class Producer {

    private String producerData;

    public Producer(String producerData) {
        this.producerData = producerData;
    }


    @Override
    public String toString() {
        return "Producer{" +
                "producerData='" + producerData + '\'' +
                '}';
    }
}