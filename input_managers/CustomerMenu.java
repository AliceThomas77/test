package library.input_managers;

import library.ContactInfo;
import library.Customer;
import library.Library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 21/12/2016.
 */
public class CustomerMenu implements userInteraction {

    private Library lib;

    public CustomerMenu(Library lib){
        this.lib = lib;

        showMainMenu();
    }

    @Override
    public void showMainMenu() {

        boolean isValid = false;


        while(!isValid) {
            System.out.println("Please choose what to do: ");
            System.out.println("1 - Add Customer");
            System.out.println("2 - View Customer");
            System.out.println("3 - Delete Customer");
            System.out.println("4 - Go Back");

            switch (scanner.nextInt()) {
                case 1:
                    isValid = true;
                    addCustomer();
                    showMainMenu();
                    break;
                case 2:
                    isValid = true;
                    showCustomer();
                    showMainMenu();
                    break;
                case 3:
                    isValid = true;
                    deleteCustomer();
                    showMainMenu();
                    break;
                case 4:
                    isValid = true;
                    goBack();
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;

            }
        }
    }


    private void addCustomer(){
        System.out.print("Please input customer name: ");
        String name = scanner.next();
        System.out.print("Please enter a customer DOB (dd-mm-yyyy): ");
        Date DOB = null;
        try {
           DOB = new SimpleDateFormat("dd-MM-yyyy").parse(scanner.next());
        }catch (ParseException e){
            System.out.println("Invalid Date Format");
            new CustomerMenu(lib);
        }
        System.out.print("Please enter the customers phone number: ");
        String phoneString = scanner.next();

        System.out.print("Pleas enter the customers address, separated by commas (e.g House Number, Street, Town, County, Postcode");
        scanner.nextLine();
        String[] addressArray = scanner.nextLine().split("\\s*,\\s*");

        try {
            ContactInfo ci = new ContactInfo(addressArray[0], addressArray[1], addressArray[2], addressArray[3], addressArray[4], phoneString);
            Customer c = new Customer(name, DOB, ci);
            lib.addCustomer(c);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error in address.");
            new CustomerMenu(lib);
        }

    }
    private void showCustomer(){
        System.out.print("Please enter the customer ID");
        lib.showCustomer(scanner.nextInt());
    }
    private void deleteCustomer(){
        System.out.print("Please enter the customer ID");
        lib.deleteCustomer(scanner.nextInt());
    }



    @Override
    public void goBack() {
        new MainMenu(lib);
    }
}
