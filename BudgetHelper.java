import java.util.Scanner;
import java.util.ArrayList;

public class BudgetHelper {
    public static void displayMenu() {
        System.out.println("\n--- Personal Budget Helper ---");
        System.out.println("1. Display current balance");
        System.out.println("2. Add Income");
        System.out.println("3. Add Expense");
        System.out.println("4. View History");
        System.out.println("5. Set Savings Goal");
        System.out.println("6. View Balance in EUR");
        System.out.println("7. Filter History by Category"); // Dodane dla BUD-8
        // Future features will be added here
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 1000.0; // Starting balance
        double savingsGoal = 0.0; 
        ArrayList<String> transactions = new ArrayList<String>();

        while (true) {
            displayMenu();
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.printf("Your current balance is: $%.2f\n", balance);
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
                
                System.out.print("Enter expense category (e.g., Food, Bills): ");
                String category = scanner.nextLine();
                
                balance -= expense;
                
                transactions.add(String.format("[%s] Spent: $%.2f", category, expense));
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
                System.out.print("Enter your financial savings goal: ");
                savingsGoal = Double.parseDouble(scanner.nextLine());
                System.out.printf("Savings goal set to $%.2f successfully!\n", savingsGoal);
            } else if (choice.equals("6")) {
                double euroExchangeRate = 0.92;
                double balanceInEur = balance * euroExchangeRate;
                System.out.printf("Your current balance in EUR is: €%.2f\n", balanceInEur);
            } else if (choice.equals("7")) {
                // BUD-8: Logika filtrowania historii według podanej kategorii
                System.out.print("Enter category to filter by: ");
                String filterCategory = scanner.nextLine();
                
                System.out.printf("\n--- Filtered History for [%s] ---\n", filterCategory);
                boolean found = false;
                
                // Przygotowujemy wzorzec do szukania, np. "[Food]"
                String searchPattern = "[" + filterCategory + "]";
                
                for (String transaction : transactions) {
                    if (transaction.contains(searchPattern)) {
                        System.out.println("- " + transaction);
                        found = true;
                    }
                }
                
                if (!found) {
                    System.out.println("No transactions found for this category.");
                }
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
