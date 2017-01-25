package library.input_managers;

import java.util.Scanner;

/**
 * Created by Administrator on 21/12/2016.
 */
public interface userInteraction {

    Scanner scanner = new Scanner(System.in);

    void showMainMenu();
    void goBack();
}
