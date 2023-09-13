package phase1.project.com;

import java.io.File;

import phase1.project.exception.ProperOptionValue;
import phase1.project.utility.*;

public class LockedMeApp {
	private static final String rootpath = new File("").getAbsolutePath();

    public static void main(String[] args) throws ProperOptionValue {
        System.out.println("Welcome to LockedMe.com Virtual Key");
        System.out.println("Developer: André Bessa");

        MainMenu mainMenu = new MainMenu(rootpath); //object creation
        mainMenu.run();  //calls run method from MainMenu class

        System.out.println("Goodbye!");
    }
}
