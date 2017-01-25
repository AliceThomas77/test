package library.input_managers;

import library.Library;

/**
 * Created by Administrator on 22/12/2016.
 */
public class RentalMenu implements userInteraction {

    Library lib;

    RentalMenu(Library lib) {
        this.lib = lib;
        showMainMenu();
    }

    @Override
    public void showMainMenu() {

        boolean isValid = false;

        while (!isValid) {
            System.out.println("Please choose what to do: ");
            System.out.println("1 - Rent Item");
            System.out.println("2 - View All Rentals");
            System.out.println("3 - View Overdue Rentals");
            System.out.println("4 - Return an Item");
            System.out.println("5 - Go Back");

            switch (scanner.nextInt()) {
                case 1:
                    isValid = true;
                    rentItem();
                    showMainMenu();
                    break;
                case 2:
                    isValid = true;
                    lib.showRentals();
                    showMainMenu();
                    break;
                case 3:
                    isValid = true;
                    lib.showOverdueRentals();
                    showMainMenu();
                    break;
                case 4:
                    isValid = true;
                    itemReturned();
                    showMainMenu();
                    break;
                case 5:
                    isValid = true;
                    goBack();
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;

            }
        }
    }

    @Override
    public void goBack() {

    }

    private void rentItem() {

        System.out.print("Please enter the customer ID: ");
        int cID = scanner.nextInt();
        System.out.print("Please enter the item ID: ");
        int iID = scanner.nextInt();

        String result = (lib.rentItem(iID, cID)) ? "Rental started." : "Rental could not be started";
        System.out.println(result);

    }
    private void itemReturned(){
        System.out.print("Please input the customer ID: " );
        int cID = scanner.nextInt();
        System.out.print("please input the item ID: ");
        int iID = scanner.nextInt();

        if(lib.itemReturned(iID, cID)) System.out.println("Rental returned successfully.");
        else System.out.println("Error returning rental");
    }
}
