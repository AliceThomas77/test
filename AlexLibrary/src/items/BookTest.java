package tests;

import items.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class BookTest {
	//Hellooo

    private Book book;
    private final int numInStock = 10, numRented = 7, numPages = 243;
    private final double price = 9.99;
    private final String title = "title", author = "author";


    @Before
    public void setup(){
        book = new Book(numInStock,  numRented, price, title, author, numPages);

    }

    @Test
    public void getTitle() throws Exception {
        Assert.assertEquals(book.getTitle(), title);
    }

    @Test
    public void getAuthor() throws Exception {
        Assert.assertEquals(book.getAuthor(), author);
    }

    @Test
    public void getNumPages() throws Exception {
        Assert.assertEquals(book.getNumPages(), numPages);
    }

}