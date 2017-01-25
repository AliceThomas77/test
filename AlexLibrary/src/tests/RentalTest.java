package tests;

import items.Book;
import library.Customer;
import library.Rental;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created by Administrator on 20/12/2016.
 */
public class RentalTest {

    private Book b;
    private Customer c;

    private Rental ok, overdue;


    @Before
    public void setup() throws Exception {

        c = TestMain.createCustomer();
        b = TestMain.createBook();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, -8);

        ok = new Rental(c.getCustomerID(), b.getProductID(), Calendar.getInstance().getTime());
        overdue = new Rental(c.getCustomerID(), b.getProductID(), cal.getTime());
    }

    @After
    public void teardown(){
        ok.resetNumRentals();
    }

    @Test
    public void getRentalID() throws Exception {
        Assert.assertEquals(ok.getRentalID(), 1);
        Assert.assertEquals(overdue.getRentalID(), 2);
    }

    @Test
    public void getCustomerID() throws Exception {
        Assert.assertEquals(ok.getCustomerID(), c.getCustomerID());
        Assert.assertEquals(overdue.getCustomerID(), c.getCustomerID());
    }

    @Test
    public void getProductID() throws Exception {
        Assert.assertEquals(ok.getProductID(), b.getProductID());
        Assert.assertEquals(overdue.getProductID(), b.getProductID());
    }

    @Test
    public void getDateOut() throws Exception {
        Assert.assertEquals(ok.getDateOut(), Calendar.getInstance().getTime());
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, -8);
        Assert.assertEquals(overdue.getDateOut(), cal.getTime());
    }

    @Test
    public void isItemOverdue() throws Exception {
        Assert.assertEquals(ok.isItemOverdue(), false);
        Assert.assertEquals(overdue.isItemOverdue(), true);
    }

    @Test
    public void setDateReturned() throws Exception {
        ok.setDateReturned(Calendar.getInstance().getTime());
        overdue.setDateReturned(Calendar.getInstance().getTime());
    }

    @Test
    public void getDateReturned() throws Exception {
        ok.setDateReturned(Calendar.getInstance().getTime());
        overdue.setDateReturned(Calendar.getInstance().getTime());

        Assert.assertEquals(ok.getDateReturned(), Calendar.getInstance().getTime());
        Assert.assertEquals(overdue.getDateReturned(), Calendar.getInstance().getTime());
    }


}