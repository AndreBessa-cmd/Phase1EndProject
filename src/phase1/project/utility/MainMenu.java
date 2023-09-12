package phase1.project.utility;

import java.io.File;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import phase1.project.exception.ProperOptionValue;

public class MainMenu {
    private final String rootPath;
    private final Scanner scanner = new Scanner(System.in);

    public MainMenu(String rootPath) {
        this.rootPath = rootPath;
    }

    public void run() throws ProperOptionValue {
        String con;
        do {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    listFilesAscendingOrder();
                    break;
                case 2:
                    OperationsMenu operationsMenu = new OperationsMenu(rootPath);
                    operationsMenu.run();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

            con = getUserInput("MainMenu: Do you want to continue? (y/n)");
        } while ("y".equalsIgnoreCase(con));
    }

    private void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. List files in ascending order");
        System.out.println("2. Navigate to the Operations Menu");
        System.out.println("3. Close the application");
        System.out.println("Please enter your choice");
    }

    private int getUserChoice() throws ProperOptionValue {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
            	scanner.nextLine();  // Consume the invalid input
                throw new ProperOptionValue("Invalid input. Please enter a valid number.");
                
            }
        }
    }

    private void listFilesAscendingOrder() {
        File rootDirectory = new File(rootPath);
        String[] listOfFiles = rootDirectory.list();
        Arrays.sort(listOfFiles);
        for (String name : listOfFiles) {
            System.out.println(name);
        }
    }

    private String getUserInput(String prompt) {
        System.out.println(prompt);
        return scanner.next().toLowerCase();
    }
}
