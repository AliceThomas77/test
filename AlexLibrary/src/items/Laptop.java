package items;

/**
 * Created by Administrator on 20/12/2016.
 */
public class Laptop extends MediaResource {

    private int ram, storage;
    private String processor;

    public Laptop(int numInStock, int numRented, double price, String make,
                  String model, int ram, int storage, String processor) {
        super(numInStock, numRented, price, make, model);
        this.ram = ram;
        this.storage = storage;
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getProcessor() {
        return processor;
    }

    @Override
    public String itemInfo() {
        return String.format("Laptop: %s %s", getMake(), getModel());
    }
}
