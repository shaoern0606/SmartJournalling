package backend;

import java.util.Scanner;
import java.time.LocalTime;
import java.time.ZoneId;

public class WelcomePage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Simulate login by asking user name
        System.out.print("Enter your display name: ");
        String username = sc.nextLine();

        // Get current hour in GMT+8
        LocalTime now = LocalTime.now(ZoneId.of("Asia/Kuala_Lumpur"));
        int hour = now.getHour();

        String greeting;
        if (hour >= 0 && hour < 12)
            greeting = "Good Morning";
        else if (hour >= 12 && hour < 17)
            greeting = "Good Afternoon";
        else
            greeting = "Good Evening";

        // Print greeting with user name
        System.out.println(greeting + ", " + username + "!\n");

        // Show menu
        System.out.println("Please choose an option:");
        System.out.println("1. Create / Edit / View Journals");
        System.out.println("2. View Weekly Mood Summary");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = sc.nextInt();

        // Handle choice
        switch (choice) {
            case 1 -> System.out.println("You chose: Create/Edit/View Journals (functionality coming soon)");
            case 2 -> System.out.println("You chose: Weekly Mood Summary (functionality coming soon)");
            default -> System.out.println("Invalid choice");
        }

        sc.close();
    }
}