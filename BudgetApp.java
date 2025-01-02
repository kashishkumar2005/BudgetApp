import java.util.*;

class Expense {
    String description;
    double amount;

    Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }
}

public class BudgetApp {

    public static void addExpense(ArrayList<Expense> expenses, String description, double amount) {
        if (amount <= 0) {
            System.out.println("Amount should be greater than zero!");
        } else {
            expenses.add(new Expense(description, amount));
            System.out.println("Added: " + description + " - Rs" + amount);
        }
    }

    public static double calculateTotalSpent(ArrayList<Expense> expenses) {
        double totalSpent = 0;
        for (Expense expense : expenses) {
            totalSpent += expense.amount;
        }
        return totalSpent;
    }

    public static void showBudgetDetails(double budget, ArrayList<Expense> expenses) {
        System.out.println("\nTotal Budget: Rs" + budget);
        System.out.println("Expenses:");
        for (Expense expense : expenses) {
            System.out.println("- " + expense.description + ": Rs" + expense.amount);
        }
        double totalSpent = calculateTotalSpent(expenses);
        System.out.println("Total Spent: Rs" + totalSpent);
        System.out.println("Remaining Budget: Rs" + (budget - totalSpent));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        System.out.println("Welcome to the Budget App!");
        System.out.print("Enter your total budget: Rs");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add an expense");
            System.out.println("2. Show budget details");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Expense description: ");
                    String description = scanner.nextLine();
                    System.out.print("Expense amount: Rs");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    addExpense(expenses, description, amount);
                    break;
                case "2":
                    showBudgetDetails(budget, expenses);
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, try again!");
            }
        }
    }
}
