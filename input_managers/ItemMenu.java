package library.input_managers;

import items.*;
import library.Library;
import library.Verification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ItemMenu implements userInteraction, Verification {

    private Library lib;

    ItemMenu(Library lib) {
        this.lib = lib;

        showMainMenu();
    }

    @Override
    public void showMainMenu() {

        boolean isValid = false;

        while (!isValid) {
            System.out.println("Please choose what to do: ");
            System.out.println("1 - Add Item");
            System.out.println("2 - View Items");
            System.out.println("3 - Delete Item");
            System.out.println("4 - Go Back");

            switch (scanner.nextInt()) {
                case 1:
                    isValid = true;
                    addItem();
                    goBack();
                    break;
                case 2:
                    isValid = true;
                    lib.showItems();
                    goBack();
                    break;
                case 3:
                    isValid = true;
                    deleteItem();
                    goBack();
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
        new MainMenu(lib);
    }


    @Override
    public boolean verify(String attempt, String password) {
        return attempt.matches(password);
    }

    @Override
    public boolean verify(String attempt, String password, int numTries) {
        if (numTries == 0) {
            System.out.println("Authentication failed. You have been locked out!");
            return false;
        } else {
            if (verify(attempt, password)) return true;
            else {
                System.out.println(numTries - 1 + "attempts remaining.");
                return (verify(attempt, password)) || verify(attempt, password, numTries - 1);
            }

        }
    }


    private void deleteItem() {
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Please enter the itemID: ");
            if (lib.deleteItem(scanner.nextInt())) {
                isValid = true;
                System.out.println("Item Deleted");
            } else {
                isValid = true;
                System.out.println("Unable to find item");
                new ItemMenu(lib);
            }
        }
    }
    private void addItem() {
        boolean isValid = false;

        while (!isValid) {
            System.out.println("What Item are you making ");
            System.out.println("1 - Book");
            System.out.println("2 - Newspaper");
            System.out.println("3 - Laptop (Media Resource)");
            System.out.println("4 - Camera (Media Resource)");
            System.out.println("5 - Go Back");

            int input = scanner.nextInt();
            int numInStock = 0, numRented = 0;
            double price = 0;

            if (input == 1 || input == 2 || input == 3 || input == 4) {
                isValid = true;

                System.out.print("Please enter the number delivered: ");
                numInStock = scanner.nextInt();
                System.out.print("Please enter the price of renting the item: ");
                price = scanner.nextDouble();
            }
            switch (input) {
                case 1:
                    System.out.print("Please enter the book title: ");
                    String title = scanner.next();
                    System.out.print("Please enter the authors name: ");
                    String author = scanner.next();
                    System.out.print("Please enter the number of pages in the book: ");
                    int numPages = scanner.nextInt();

                    Book b = new Book(numInStock, numRented, price, title, author, numPages);
                    lib.addItem(b);
                    System.out.println("Book Added.");
                    break;

                case 2:
                    System.out.print("Please enter the title: ");
                    String newspaperTitle = scanner.next();
                    System.out.print("Please enter the issueDate (dd-mm-yyyy): ");
                    String dateString = scanner.next();
                    try {
                        Date issueDate = (new SimpleDateFormat("dd-MM-yyyy")).parse(dateString);
                        lib.addItem(new Newspaper(numInStock, numRented, price, issueDate, newspaperTitle));
                        System.out.println("Newspaper Added.");
                    } catch (ParseException e) {
                        System.out.println("Error parsing date. Please try again");
                        showMainMenu();
                    }
                    break;

                case 3:
                    System.out.print("Please enter the make: ");
                    String laptopMake = scanner.next();
                    System.out.print("Please enter the model: ");
                    String laptopModel = scanner.next();
                    System.out.print("Please enter the processor name: ");
                    String processor = scanner.next();
                    System.out.print("Please enter the amount of RAM: ");
                    int ram = scanner.nextInt();
                    System.out.print("Please enter the HDD size: ");
                    int storage = scanner.nextInt();
                    lib.addItem(new Laptop(numInStock, numRented, price, laptopMake, laptopModel, ram, storage, processor));
                    System.out.println("Laptop Added");
                    break;

                case 4:
                    System.out.print("Please enter the make: ");
                    String cameraMake = scanner.next();
                    System.out.print("Please enter the model: ");
                    String cameraModel = scanner.next();
                    System.out.print("Please enter the number of mega-pixels: ");
                    int megaPx = scanner.nextInt();
                    lib.addItem(new Camera(numInStock, numRented, price, cameraMake, cameraModel, megaPx));
                    System.out.println("Camera Added");
                    break;

                case 5:
                    new ItemMenu(lib);
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }

    }


}
