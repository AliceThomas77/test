package library;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Customer {

    private static int customerCount;

    private String name;
    private int customerID;
    private Date DOB;
    private ContactInfo contactInfo;

    public Customer(String name, Date DOB, ContactInfo contactInfo) {
        this.name = name;
        this.DOB = DOB;
        this.contactInfo = contactInfo;

        customerCount++;
        customerID = customerCount;
    }

    public String getName() {
        return name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public Date getDOB() {
        return DOB;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public String getInfo(){
        return String.format("ID: %d\tName: %s\t\t\t\tDOB: %s", customerID, name, new SimpleDateFormat("dd:MM:yyyy").format(DOB));
    }
}
