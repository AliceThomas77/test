package items;

/**
 * Created by Administrator on 20/12/2016.
 */
public class MediaResource extends Item {

    private double deposit = 50.00;
    private String make, model;

    public MediaResource(int numInStock, int numRented, double price, String make, String model) {
        super(numInStock, numRented, price);
        this.make = make;
        this.model = model;
    }

    public double getDeposit() {
        return deposit;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public String itemInfo() {
        return "A media item";
    }
}
