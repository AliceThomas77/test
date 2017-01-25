package library;

import items.Item;

import java.io.*;
import java.util.LinkedList;
import java.util.List;


/**
 * Handles reading and writing text files containing items in the library
 */
class FileHandler {

    private final String FILENAME = "library_items.ser";
    private String encodedPassword;


    FileHandler() {
    }

    /**
     * reads from the file and initializes objects
     *
     * @return - a List of Item objects for the library
     */
    List<Item> readFromFile() throws IOException, ClassNotFoundException {

        List<Item> itemList = new LinkedList<>();

        FileInputStream fileIn = new FileInputStream(FILENAME);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        itemList = (List<Item>) in.readObject();

        in.close();
        fileIn.close();

        return itemList;

    }

    boolean isFileEmpty(){
        File file = new File(FILENAME);
        return (file.length() == 0);
    }

    void writeToFile(List<Item> items) throws IOException {
        FileOutputStream fileOut =
                new FileOutputStream(FILENAME);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(items);
        out.close();
        fileOut.close();
    }



    void getEncodedPassword(){

        try{
            FileInputStream fileIn = new FileInputStream("p");
            ObjectInputStream in = new ObjectInputStream(fileIn);
        } catch (IOException e){
            System.out.println("Unable to load password");
        }
    }

}
