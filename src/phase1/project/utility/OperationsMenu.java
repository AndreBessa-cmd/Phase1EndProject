package phase1.project.utility;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import phase1.project.exception.*;


public class OperationsMenu {
    private final String rootPath;
    private final Scanner scanner = new Scanner(System.in);

    public OperationsMenu(String rootPath) {  //constructor
        this.rootPath = rootPath;
    }

    public void run() throws ProperOptionValue { //run method
        String con;
        do {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addFile();
                    break;
                case 2:
                    deleteFile();
                    break;
                case 3:
                    searchFile();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
               
            con = getUserInput("OperationsMenu: Do you want to display options again? (y)");
            
              
        } while ("y".equalsIgnoreCase(con));
    }
    

    private void displayMenu() {  // display operation menu options
        System.out.println("Operations Menu Options:");
        System.out.println("1. Add a file to the directory list");
        System.out.println("2. Delete a file from the directory list");
        System.out.println("3. Search for a file in the directory");
        System.out.println("4. Navigate back to the main context");
        System.out.println("Please enter your choice");
    }

    private int getUserChoice() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    private void addFile() throws ProperOptionValue {  //add file method
        String filename = getUserInput("Please enter the file name").toLowerCase(); // Convert to lowercase to ignore case sensitivity
        File file = new File(rootPath + File.separator + filename);

        if (file.exists()) {   //validates if file already exists
            System.out.println("File already exists");
        } else {
            try {
                if (file.createNewFile()) {  // creates the file
                    System.out.println("New file created with name: " + filename);
                } else {
                    System.out.println("Failed to create the file");
                }
            } catch (Exception e) {
            	throw new ProperOptionValue("An error occurred: " + e.getMessage());
            }
        }
    }

    private void deleteFile() {  //delete file method
        String filename = getUserInput("Please enter the file name");
        File file = new File(rootPath + File.separator + filename);

        if (file.exists() && file.delete()) {  //validates if file exists and deletes it, return true
            System.out.println("File deleted");
        } else {
            System.out.println("File not present with the name: " + filename);
        }
    }

    private void searchFile() { //method to search file
        String filename = getUserInput("Please enter the file name");
        File file = new File(rootPath + File.separator + filename);

        if (file.exists()) {//check if file exists
            System.out.println("File exists");
        } else {
            System.out.println("File not present");
        }
    }

    private String getUserInput(String prompt) {  //reads the user inputs
        System.out.println(prompt);
        return scanner.next();
    }
}
