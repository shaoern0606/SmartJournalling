package backend;

import java.io.*;
import java.util.*;

public class UserManager {
    private static final String FILE_NAME = "UserData.txt";
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
        loadUsers();
    }

    // Load users from file
    private void loadUsers() {
        try (Scanner sc = new Scanner(new File(FILE_NAME))) {
            // Check if there are at least 3 lines remaining before reading
            while (sc.hasNextLine() && sc.hasNextLine() && sc.hasNextLine()) { 
                // NOTE: The 'hasNextLine()' call doesn't consume the line, so it's safe to check it three times.

                // It's safer to use an auxiliary check method for cleaner code:
                if (!sc.hasNextLine()) return; // Check 1: email
                String email = sc.nextLine().trim();
                
                if (!sc.hasNextLine()) return; // Check 2: displayName
                String displayName = sc.nextLine().trim();
                
                if (!sc.hasNextLine()) return; // Check 3: password
                String password = sc.nextLine().trim();
                
                users.add(new User(email, displayName, password));
            }
        } catch (FileNotFoundException e) {
            System.out.println("UserData.txt not found. Starting with empty user list.");
        }
    }
    // Save new user to file
    private void saveUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(user.getEmail());
            writer.newLine();
            writer.write(user.getDisplayName());
            writer.newLine();
            writer.write(user.getPassword());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Register a new user
    public void registerUser(String email, String displayName, String password) {
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                System.out.println("Email already exists!");
                return;
            }
        }
        User newUser = new User(email, displayName, password);
        users.add(newUser);
        saveUser(newUser);
        System.out.println("User registered successfully!");
    }

    // Login method
    public User login(String email, String password) {
        for (User u : users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    // For testing: list all users
    public void listUsers() {
        for (User u : users) {
            System.out.println(u.getEmail() + " | " + u.getDisplayName());
        }
    }
}