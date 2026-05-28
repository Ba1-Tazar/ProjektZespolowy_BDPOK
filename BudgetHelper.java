import java.util.Scanner;

public class BudgetHelper {
    public static void displayMenu() {
        System.out.println("\n--- Personal Budget Helper ---");
        System.out.println("1. Display current balance");
        // Future features will be added here
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 1000.0; // Starting balance

        while (true) {
            displayMenu();
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Your current balance is: $" + balance);
            } else if (choice.equals("0")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
