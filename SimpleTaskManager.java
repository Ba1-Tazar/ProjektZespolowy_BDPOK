import java.util.ArrayList;
import java.util.Scanner;

public class SimpleTaskManager {
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("!!! System Zarządzania Zadaniami !!!");

        while (running) {
            System.out.println("\n1. Pokaż zadania");
            System.out.println("2. Dodaj zadanie");
            System.out.println("3. Usuń zadanie");
            System.out.println("4. Wyjdź");
            System.out.print("Wybierz opcję: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showTasks();
                    break;
                case "2":
                    System.out.print("Treść zadania: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("Dodano!");
                    break;
                case "3":
                    showTasks();
                    System.out.print("Numer zadania do usunięcia: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine());
                        tasks.remove(index - 1);
                        System.out.println("Usunięto.");
                    } catch (Exception e) {
                        System.out.println("Błąd: Niepoprawny numer.");
                    }
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Nieznana opcja.");
            }
        }
        scanner.close();
        System.out.println("Do zobaczenia!");
    }

    private static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Lista jest pusta.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
