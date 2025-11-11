package backend;

import java.util.Scanner;
import java.time.LocalTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager userManager = new UserManager();

        System.out.println("Welcome to Smart Journal!");

        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();
                    User loggedIn = userManager.login(email, password);

                    if (loggedIn != null) {
                        // Login successful → show time-based greeting
                        String greeting = getGreeting(loggedIn.getDisplayName());
                        System.out.println(greeting);

                        // Show menu for journals / weekly summary
                        showMenu(sc);
                    } else {
                        System.out.println("Invalid email or password.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Email: ");
                    String newEmail = sc.nextLine();
                    System.out.print("Enter Display Name: ");
                    String displayName = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String newPassword = sc.nextLine();
                    userManager.registerUser(newEmail, displayName, newPassword);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Function to get greeting based on GMT+8
    public static String getGreeting(String username) {
        LocalTime now = LocalTime.now(ZoneId.of("Asia/Kuala_Lumpur"));
        int hour = now.getHour();
        String greeting;

        if(hour >= 0 && hour < 12) greeting = "Good Morning";
        else if(hour >= 12 && hour < 17) greeting = "Good Afternoon";
        else greeting = "Good Evening";

        return greeting + ", " + username + "!";
    }

    // Function to show menu
    public static void showMenu(Scanner sc) {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Create/Edit/View Journals");
        System.out.println("2. View Weekly Mood Summary");
        System.out.print("Enter your choice: ");
        int menuChoice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch(menuChoice) {
            case 1 -> System.out.println("Journal feature coming soon!");
            case 2 -> System.out.println("Weekly Mood Summary coming soon!");
            default -> System.out.println("Invalid choice!");
        }
    }
}