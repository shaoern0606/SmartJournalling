package Latest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserRepository {
    private ArrayList<User> users = new ArrayList<>();

    public UserRepository() {
        loadUsersFromFile();
    }

    private void loadUsersFromFile() {
        try {
            File file = new File("UserData.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String email = sc.nextLine().trim();
                String displayName = sc.nextLine().trim();
                String password = sc.nextLine().trim();

                // Create user object and add to list
                User user = new User(email, displayName, password);
                users.add(user);
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("UserData.txt not found!");
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}