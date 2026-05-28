import java.util.Scanner;
import java.util.ArrayList;

public class BudgetHelper {
    public static void displayMenu() {
        System.out.println("\n--- Personal Budget Helper ---");
        System.out.println("1. Display current balance");
        System.out.println("2. Add Income");
        System.out.println("3. Add Expense");
        System.out.println("4. View History");
        System.out.println("5. Set Savings Goal"); // Dodane dla BUD-5
        // Future features will be added here
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 1000.0; // Starting balance
        double savingsGoal = 0.0; // BUD-5: Inicjalizacja zmiennej celu oszczędnościowego
        ArrayList<String> transactions = new ArrayList<String>();

        while (true) {
            displayMenu();
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.printf("Your current balance is: $%.2f\n", balance);
                // BUD-5: Modyfikacja opcji 1, aby wyświetlała pozostałą kwotę do celu
                System.out.printf("Remaining to goal: $%.2f\n", (savingsGoal - balance));
            } else if (choice.equals("2")) {
                System.out.print("Enter income amount: ");
                double income = Double.parseDouble(scanner.nextLine());
                balance += income;
                
                transactions.add(String.format("Added income: $%.2f", income));
                System.out.println("Income added successfully!");
            } else if (choice.equals("3")) {
                System.out.print("Enter expense amount: ");
                double expense = Double.parseDouble(scanner.nextLine());
                balance -= expense;
                
                transactions.add(String.format("Added expense: $%.2f", expense));
                System.out.println("Expense added successfully!");
            } else if (choice.equals("4")) {
                System.out.println("\n--- Transaction History ---");
                if (transactions.isEmpty()) {
                    System.out.println("No transactions recorded yet.");
                } else {
                    for (String transaction : transactions) {
                        System.out.println("- " + transaction);
                    }
                }
            } else if (choice.equals("5")) {
                // BUD-5: Obsługa nowej opcji menu do ustawiania celu
                System.out.print("Enter your financial savings goal: ");
                savingsGoal = Double.parseDouble(scanner.nextLine());
                System.out.printf("Savings goal set to $%.2f successfully!\n", savingsGoal);
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