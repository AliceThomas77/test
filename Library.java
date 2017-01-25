package library;

import items.Book;
import items.Camera;
import items.Item;
import items.Newspaper;
import library.input_managers.MainMenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Library {

    private String ADMIN_PASSWORD = "superSecret";

    private List<Customer> customers = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();

    private FileHandler fileHandler;

    public Library() {
        fileHandler = new FileHandler();


        //if the file is empty populate items
        try {
            if (fileHandler.isFileEmpty()) populateLibrary();
            else {
                items = fileHandler.readFromFile();
            }

            init();
        } catch (FileNotFoundException f) {
            System.out.println("No file found");
        } catch (IOException | ClassNotFoundException io) {
            System.out.println("I/O Exception");
        }

        IMS ims = new IMS();

        new MainMenu(this);
    }


    /**
     * creates customers and rental
     */
    private void init() {
        addCustomer(new Customer("NameName", new Date(1996, 12, 24),
                new ContactInfo("blah", "place", "somewhere", "Land",
                        "1213", "1231214")));
        addCustomer(new Customer("Boo Hoo", new Date(1996, 12, 24),
                new ContactInfo("blah", "place", "somewhere", "Land",
                        "1213", "1231214")));
        addCustomer(new Customer("MrMisses", new Date(1996, 12, 24),
                new ContactInfo("blah", "place", "somewhere", "Land",
                        "1213", "1231214")));
        addCustomer(new Customer("LucyLoo", new Date(1996, 12, 24),
                new ContactInfo("blah", "place", "somewhere", "Land",
                        "1213", "1231214")));

        rentItem(items.get(0), customers.get(0));
        rentItem(items.get(0), customers.get(1));
        rentItem(items.get(2), customers.get(3));
    }

    /**
     * adds initial items to the library
     */
    private void populateLibrary() {
        addItem(new Book(12, 3, 9.99, "A title", "An author", 253));
        addItem(new Book(107, 124, 15.99, "The best book", "The worst author", 1));
        addItem(new Camera(12, 23, 15.99, "casio", "FX320", 12));
        addItem(new Camera(2, 3, 25.99, "Fujitsu", "SP2", 18));
        addItem(new Camera(5, 1, 5.99, "casio", "SL ProShoot", 4));
        addItem(new Newspaper(3, 5, 1.49, new Date(1995, 6, 30), "Daily Mail"));
        addItem(new Newspaper(1, 0, 4.99, new Date(1987, 9, 12), "Daily Express"));
    }


    public boolean addItem(Item i) {
        items.add(i);
        writeItemsToFile();
        return true;
    }

    public boolean deleteItem(Item i) {
        if(items.remove(i)) {
            writeItemsToFile();
            return true;
        }

        return false;
    }
    public boolean deleteItem(int itemID) {
        for(Item item : items){
            if(item.getProductID() == itemID){
                items.remove(item);
                return true;
            }
        }
        return false;
    }
    public void showItems(){
        for(Item i : items) System.out.println(i.itemInfo());
    }

    public void addCustomer(Customer c) {

        customers.add(c);
        System.out.println("Customer Added.");
    }

    public boolean deleteCustomer(Customer c) {
        if (customers.remove(c)) {
            System.out.println("Customer Deleted.");
            return true;
        }

        return false;
    }
    public boolean deleteCustomer(int customerID) {
        for(Customer c : customers){
            if(c.getCustomerID() == customerID){
                customers.remove(c);
                return true;
            }
        }
        return false;
    }

    public void showCustomer(int customerID){
        printTitle("customer: " + customerID);
        for(Customer c : customers){
            if(c.getCustomerID() == customerID) System.out.println(c.getInfo());
        }
    }

    public boolean rentItem(Item i, Customer c) {
        if (i.getNumInStock() > 0) {
            rentals.add(new Rental(c.getCustomerID(), i.getProductID(), Calendar.getInstance().getTime()));
            i.startRental();
            System.out.println("That will cost £" + i.getPrice());
            return true;
        } else {
            System.out.println("Item out of stock.");
            return false;
        }
    }
    public boolean rentItem(int itemID, int customerID){
        Item toRent = null;
        Customer c = null;

        for(Item item : items){
            if (item.getProductID() == itemID){
                toRent = item;
                break;
            }
        }
        for(Customer cust : customers){
            if(cust.getCustomerID() == customerID){
                c = cust;
                break;
            }
        }

        //returns false if customer or item aren't found in list.
        //Else returns output of rentItem(Item, Customer) which checks stock levels
        return !(c == null || toRent == null) && rentItem(toRent, c);
    }

    public void showRentals(){
        printTitle("Rentals");
        for(Rental r : rentals) System.out.println(r.rentalInfo());
    }
    public void showOverdueRentals(){
        printTitle("Overdue rentals");
        for(Rental r : rentals) {
            if(r.isItemOverdue()) System.out.println(r.rentalInfo());
        }
    }

    public boolean itemReturned(Item i, Customer c, Date date) {
        for (Rental r : rentals) {
            if ((r.getCustomerID() == c.getCustomerID()) && r.getProductID() == i.getProductID()) {
                if (r.isItemOverdue()) {
                    System.out.println("This item is overdue!");
                }
                r.setDateReturned(date);
                i.itemReturned();
                rentals.remove(r);
                return true;
            }
        }

        return false;
    }
    public boolean itemReturned(int itemID, int customerID) {
        Item toReturn = null;
        Customer c = null;

        for (Rental r : rentals) {
            if (r.getProductID() == itemID && r.getCustomerID() == customerID) {

                for (Item item : items) {
                    if (item.getProductID() == itemID) {
                        toReturn = item;
                        break;
                    }
                }
                for (Customer customer : customers) {
                    if (customer.getCustomerID() == customerID) {
                        c = customer;
                        break;
                    }
                }

                break;
            }
        }

        return toReturn != null && c != null && itemReturned(toReturn, c, Calendar.getInstance().getTime());
    }

    public int getNumCustomers() {
        return customers.size();
    }

    public int getNumItems() {
        return items.size();
    }

    public int getNumRentals() {
        return rentals.size();
    }

    private void writeItemsToFile() {
        try {
            fileHandler.writeToFile(items);
        } catch (IOException e) {
            System.out.println("Error updating file.");
        }
    }

    private void printTitle(String title){
        System.out.println("------------------" + title.toUpperCase() + "------------------");
    }

}
