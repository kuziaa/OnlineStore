package consoleApp;

import storeApp.StoreApp;
import java.util.Scanner;

public class consoleApp {
    public static void main(String[] args) {
        StoreApp myStoreApp = new StoreApp();
        Scanner sc = new Scanner(System.in);

        myStoreApp.executeComand("Fill");
        while (true) {
            String newCommand = sc.nextLine();
            if (newCommand.equals("quit")) {
                break;
            }
            if (!myStoreApp.executeComand(newCommand)) {
                System.out.println("Incorrect command " + newCommand);
                myStoreApp.executeComand("Help");
                continue;
            }
        }
    }
}
