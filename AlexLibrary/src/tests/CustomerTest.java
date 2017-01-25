package tests;

import library.ContactInfo;
import library.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;


/**
 * Created by Administrator on 20/12/2016.
 */
public class CustomerTest {

    private Customer test;
    final String name = "Billy Bob";
    private Calendar DOB;
    private ContactInfo ci;

    @Before
    public void setup() {
        ci = new ContactInfo("HillView", "Land", null, "Shropshire",
                "TN764SA","21234124");

        DOB = Calendar.getInstance();
        DOB.set(Calendar.YEAR, 1990);
        test = new Customer(name, DOB.getTime(), ci);

    }

    @Test
    public void getName() throws Exception {
        Assert.assertEquals(test.getName(), name);
    }

    @Test
    public void getCustomerID() throws Exception {
        Assert.assertEquals(test.getCustomerID(), 1);

    }

    @Test
    public void getDOB() throws Exception {
        Assert.assertEquals(test.getDOB(), DOB.getTime());
    }

    @Test
    public void getContactInfo() throws Exception {
        Assert.assertEquals(test.getContactInfo().toString(), ci.toString());
    }

}