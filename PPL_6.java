import java.util.*;
import java.time.*;

class Expense {
    int id;
    LocalDate date;
    String category;
    double amount;
    String description;

    Expense(int id, LocalDate date, String category, double amount, String description) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    void display() {
        System.out.println(id + " | " + date + " | " + category + " | ₹" + amount + " | " + description);
    }
}

public class ExpenseManagerSystem {

    static ArrayList<Expense> expenses = new ArrayList<>();

    public static void addExpense(int id, LocalDate date, String category, double amount, String description) {
        Expense e = new Expense(id, date, category, amount, description);
        expenses.add(e);
        System.out.println("Expense Added Successfully.");
    }

    public static void deleteExpense(int id) {
        Iterator<Expense> it = expenses.iterator();

        while (it.hasNext()) {
            Expense e = it.next();

            if (e.id == id) {
                it.remove();
                System.out.println("Expense Deleted.");
                return;
            }
        }

        System.out.println("Expense Not Found.");
    }

    public static void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No Expenses Found.");
            return;
        }

        System.out.println("\nID | Date | Category | Amount | Description");

        for (Expense e : expenses) {
            e.display();
        }
    }

    public static void totalExpenses() {

        double total = 0;

        for (Expense e : expenses) {
            total += e.amount;
        }

        System.out.println("Total Expenses: ₹" + total);
    }

    public static void categoryReport() {

        HashMap<String, Double> map = new HashMap<>();

        for (Expense e : expenses) {
            map.put(e.category, map.getOrDefault(e.category, 0.0) + e.amount);
        }

        System.out.println("\nCategory Wise Report");

        for (String cat : map.keySet()) {
            System.out.println(cat + " : ₹" + map.get(cat));
        }
    }

    public static void monthlyReport(int month) {

        double total = 0;
        HashMap<String, Double> map = new HashMap<>();

        for (Expense e : expenses) {

            if (e.date.getMonthValue() == month) {

                total += e.amount;

                map.put(e.category,
                        map.getOrDefault(e.category, 0.0) + e.amount);
            }
        }

        System.out.println("\nMonthly Report (Month " + month + ")");
        System.out.println("Total Expense: ₹" + total);

        for (String cat : map.keySet()) {
            System.out.println(cat + " : ₹" + map.get(cat));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n----- Personal Expense Manager -----");
            System.out.println("1. Add Expense");
            System.out.println("2. Delete Expense");
            System.out.println("3. View Expenses");
            System.out.println("4. Total Expenses");
            System.out.println("5. Category Report");
            System.out.println("6. Monthly Report");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Date (yyyy-mm-dd): ");
                    String dateInput = sc.next();
                    LocalDate date = LocalDate.parse(dateInput);

                    System.out.print("Enter Category: ");
                    String category = sc.next();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    System.out.print("Enter Description: ");
                    String desc = sc.next();

                    addExpense(id, date, category, amount, desc);
                    break;

                case 2:
                    System.out.print("Enter Expense ID to Delete: ");
                    int del = sc.nextInt();
                    deleteExpense(del);
                    break;

                case 3:
                    viewExpenses();
                    break;

                case 4:
                    totalExpenses();
                    break;

                case 5:
                    categoryReport();
                    break;

                case 6:
                    System.out.print("Enter Month (1-12): ");
                    int month = sc.nextInt();
                    monthlyReport(month);
                    break;

                case 7:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 7);

        sc.close();
    }
}
