package library.input_managers;

import library.Library;


public class MainMenu implements userInteraction {

    private Library lib;

    public MainMenu(Library lib) {
        this.lib = lib;

        showMainMenu();
    }

    @Override
    public void showMainMenu() {
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Please choose what to do: ");
            System.out.println("1 - Customers");
            System.out.println("2 - Items");
            System.out.println("3 - Rentals");
            System.out.println("4 - Exit");

            switch (scanner.nextInt()) {
                case 1:
                    isValid = true;
                    new CustomerMenu(lib);
                    break;
                case 2:
                    isValid = true;
                    new ItemMenu(lib);
                    break;
                case 3:
                    isValid = true;
                    new RentalMenu(lib);
                    break;
                case 4:
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
        System.out.println("Thank you for using the ALS (Amazing Library System)");
    }
}
