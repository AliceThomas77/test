package tests;

import items.Book;
import library.ContactInfo;
import library.Customer;

import java.util.Calendar;


public class TestMain {

    public static Customer createCustomer(){
        ContactInfo ci = new ContactInfo("HillView", "Land", null, "Shropshire",
                "TN764SA","21234124");

        Calendar DOB = Calendar.getInstance();
        DOB.set(Calendar.YEAR, 1990);
        return new Customer("A name", DOB.getTime(), ci);
    }

    public static Book createBook(){
        return new Book(10, 20, 9.99, "Blah", "Author", 273);
    }

}
