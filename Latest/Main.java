package Latest;

import java.util.Scanner;
import java.time.LocalTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserRepository repo = new UserRepository();
        UserService service = new UserService(repo);

        System.out.println("Welcome to Smart Journal!");
        
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                signup(sc, service);
            }
            else if (choice == 2) {
                login(sc, service);
            }
            else {
                System.out.println("Bye!");
                break;
            }
        }

        sc.close();
    }
}
