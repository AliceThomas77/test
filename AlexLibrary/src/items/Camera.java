package items;

/**
 * Created by Administrator on 20/12/2016.
 */
public class Camera extends MediaResource {

    private int megaPx;

    public Camera(int numInStock, int numRented, double price, String make, String model, int megaPx) {
        super(numInStock, numRented, price, make, model);
        this.megaPx = megaPx;
    }

    public int getMegaPx() {
        return megaPx;
    }

    @Override
    public String itemInfo() {
        return "Camera: " + megaPx + " mega-pixels";
    }
}
