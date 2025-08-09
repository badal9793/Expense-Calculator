import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String description;
    double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return description + " - ₹" + amount;
    }
}

public class SmartExpenseTracker {
    public static void main(String[] args) {
        ArrayList<Expense> expenses = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== SMART EXPENSE TRACKER ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expense");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter amount: ₹");
                    double amt = sc.nextDouble();
                    expenses.add(new Expense(desc, amt));
                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Your Expenses ---");
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded.");
                    } else {
                        for (Expense e : expenses) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:
                    double total = 0;
                    for (Expense e : expenses) {
                        total += e.amount;
                    }
                    System.out.println("Total Expense: ₹" + total);
                    break;

                case 4:
                    System.out.println("Exiting... Thank you for using Smart Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
