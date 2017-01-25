package tests;

import items.Newspaper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created by Administrator on 21/12/2016.
 */
public class NewspaperTest {

    private Newspaper n;

    @Before
    public void setUp() throws Exception {
        n = new Newspaper(12, 13, 1.99, Calendar.getInstance().getTime(), "Daily Mail");
    }

    @Test
    public void getReleaseDate() throws Exception {
        Assert.assertEquals(Calendar.getInstance().getTime(), n.getReleaseDate());
    }

    @Test
    public void getTitle() throws Exception {
        Assert.assertEquals("Daily Mail", n.getTitle());
    }

}