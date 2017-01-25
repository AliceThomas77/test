package tests;

import items.Laptop;
import items.MediaResource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 20/12/2016.
 */
public class MediaResourceTest {

    MediaResource mr;

    @Before
    public void setup(){
        mr = new Laptop(15, 7, 29.99,
                "Toshiba", "MK234", 6, 500, "i5-2430M");
    }

    @Test
    public void getDeposit() throws Exception {
        Assert.assertEquals(50.00, mr.getDeposit(), 0.005);
    }

    @Test
    public void getMake() throws Exception {
        Assert.assertEquals("Toshiba", mr.getMake());
    }

    @Test
    public void getModel() throws Exception {
        Assert.assertEquals("MK234", mr.getModel());
    }

    @Test
    public void setDeposit() throws Exception {
        mr.setDeposit(49.99);
        Assert.assertEquals(49.99, mr.getDeposit(), 0.005);
    }

}