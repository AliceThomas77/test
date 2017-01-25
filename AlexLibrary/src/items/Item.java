package items;

import java.io.Serializable;

public abstract class Item implements Serializable {

    private static int numProducts;

    private int productID, numInStock, numRented;
    private double price;

    protected Item(int numInStock, int numRented, double price) {
        this.numInStock = numInStock;
        this.numRented = numRented;
        this.price = price;

        numProducts++;
        productID = numProducts;
    }

    public static int getNumProducts() {
        return numProducts;
    }

    public int getProductID() {
        return productID;
    }

    public int getNumInStock() {
        return numInStock;
    }

    public int getNumRented() {
        return numRented;
    }

    public double getPrice() {
        return price;
    }

    public void startRental(){
        numInStock--;
        numRented++;
    }

    public void itemReturned(){
        numInStock++;
        numRented--;
    }

    public void resetNumProducts(){
        numProducts = 0;
    }

    public abstract String itemInfo();

}
