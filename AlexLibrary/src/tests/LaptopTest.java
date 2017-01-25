package tests;

import items.Laptop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 20/12/2016.
 */
public class LaptopTest {

    Laptop l;

    @Before
    public void setUp() throws Exception {
        l = new Laptop(15, 7, 29.99,
                "Toshiba", "MK234", 6, 500, "i5-2430M");
    }

    @Test
    public void getRam() throws Exception {
        Assert.assertEquals(6, l.getRam());
    }

    @Test
    public void getStorage() throws Exception {
        Assert.assertEquals(500, l.getStorage());
    }

    @Test
    public void getProcessor() throws Exception {
        Assert.assertEquals("i5-2430M", l.getProcessor());
    }

}