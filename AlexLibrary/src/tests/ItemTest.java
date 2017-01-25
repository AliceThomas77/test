package tests;

import items.Book;
import items.Camera;
import items.Item;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 20/12/2016.
 */
public class ItemTest {

    Book b;
    Camera c;


    @Before
    public void setUp() throws Exception {
        c = new Camera(5, 3, 19.99, "casio", "FX-950", 13);
        b = new Book(30, 20, 9.99, "Blah", "Author", 273);

    }

    @After
    public void teardown(){
        c.resetNumProducts();
    }

    @Test
    public void getNumProducts() throws Exception {
        Assert.assertEquals(2, Item.getNumProducts());
    }

    @Test
    public void getProductID() throws Exception {
        Assert.assertEquals(1, c.getProductID());
        Assert.assertEquals(2, b.getProductID());
    }

    @Test
    public void getNumInStock() throws Exception {
        Assert.assertEquals(5, c.getNumInStock());
        Assert.assertEquals(30, b.getNumInStock());

    }

    @Test
    public void getNumRented() throws Exception {
        Assert.assertEquals(3, c.getNumRented());
        Assert.assertEquals(20, b.getNumRented());
    }

    @Test
    public void getPrice() throws Exception {
        Assert.assertEquals(19.99, c.getPrice(), 0.005);
        Assert.assertEquals(9.99, b.getPrice(), 0.005);
    }

    @Test
    public void startRental() throws Exception {
        c.startRental();
        b.startRental();

        Assert.assertEquals(4, c.getNumInStock());
        Assert.assertEquals(4, c.getNumRented());
        Assert.assertEquals(29, b.getNumInStock());
        Assert.assertEquals(21, b.getNumRented());
    }

}