package tests;

import items.Item;
import library.Customer;
import library.Library;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created by Administrator on 20/12/2016.
 */
public class LibraryTest {

    private Library lib;
    private Customer c;
    private Item b;



    @Before
    public void setUp() throws Exception {
        c = TestMain.createCustomer();
        b = TestMain.createBook();

        lib = new Library();
    }

    @Test
    public void addItem() throws Exception {
        lib.addItem(b);
        Assert.assertEquals(1, lib.getNumItems());

    }

    @Test
    public void deleteItem() throws Exception {
        lib.deleteItem(b);
        Assert.assertEquals(0, lib.getNumItems());
    }

    @Test
    public void addCustomer() throws Exception {
        lib.addCustomer(c);
        Assert.assertEquals(1, lib.getNumCustomers());
    }

    @Test
    public void deleteCustomer() throws Exception {
        lib.deleteCustomer(c);
        Assert.assertEquals(0, lib.getNumCustomers());

    }

    @Test
    public void rentItem() throws Exception {

        lib.rentItem(b, c);
        Assert.assertEquals(1, lib.getNumRentals());
    }

    @Test
    public void itemReturned() throws Exception {
        lib.itemReturned(b, c, Calendar.getInstance().getTime());
        Assert.assertEquals(0, lib.getNumRentals());
    }
}