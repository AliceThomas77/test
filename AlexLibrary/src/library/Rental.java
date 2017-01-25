package library;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Rental {

    private static int numRentals = 0;


    private int rentalID, customerID, productID;
    private Date dateOut, dateReturned = null;

    public Rental(int customerID, int productID, Date dateOut) {
        this.customerID = customerID;
        this.productID = productID;
        this.dateOut = dateOut;

        numRentals++;
        this.rentalID = numRentals;
    }

    public void resetNumRentals(){
        numRentals=0;
    }

    public int getRentalID() {
        return rentalID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getProductID() {
        return productID;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Date date){
        this.dateReturned = date;
    }

    public boolean isItemOverdue(){
        //rental period is 7 days
        final long RENTAL_MILLIS = 7 * 24 * 60 * 60 * 1000;

        if(dateReturned == null &&
                (Calendar.getInstance().getTimeInMillis() >  dateOut.getTime() + RENTAL_MILLIS)){
            return true;
        }
        return false;
    }

    String rentalInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");

        return String.format("Customer: %d, Product: %d, Out: %s, Returned: %s",
                customerID, productID, sdf.format(dateOut), (dateReturned == null) ? "null" : sdf.format(dateReturned));
    }
}
