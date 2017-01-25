package tests;

import items.Camera;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 20/12/2016.
 */
public class CameraTest {

    Camera c;

    @Before
    public void setUp() throws Exception {
        c = new Camera(5, 3, 19.99, "casio", "FX-950", 13);
    }

    @Test
    public void getMegaPx() throws Exception {
        Assert.assertEquals(13, c.getMegaPx());
    }

}