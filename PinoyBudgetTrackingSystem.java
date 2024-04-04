package systembudget;


	import java.util.ArrayList;
	import java.util.Scanner;

	class Expense {
	    private String description;
	    private double amount;

	    public Expense(String description, double amount) {
	        this.description = description;
	        this.amount = amount;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public double getAmount() {
	        return amount;
	    }
	}

	public class PinoyBudgetTrackingSystem {
	    private double budget;
	    private double totalExpenses;
	    private ArrayList<Expense> expenses;

	    public PinoyBudgetTrackingSystem(double budget) {
	        this.budget = budget;
	        totalExpenses = 0;
	        expenses = new ArrayList<>();
	    }

	    public void addExpense(String description, double amount) {
	        expenses.add(new Expense(description, amount));
	        totalExpenses += amount;
	    }

	    public void viewTotalExpenses() {
	        System.out.println("Total expenses: 1" + totalExpenses);
	    }

	    public void viewRemainingBudget() {
	        double remainingBudget = budget - totalExpenses;
	        System.out.println("Remaining budget: ₱" + remainingBudget);
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter your budget: ₱");
	        double budget = scanner.nextDouble();
	        PinoyBudgetTrackingSystem budgetTracker = new PinoyBudgetTrackingSystem(budget);

	        while (true) {
	            System.out.println("\n1. Add Expense");
	            System.out.println("2. View Total Expenses");
	            System.out.println("3. View Remaining Budget");
	            System.out.println("4. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter description: ");
	                    scanner.nextLine(); // Consume newline character
	                    String description = scanner.nextLine();
	                    System.out.print("Enter amount: ₱");
	                    double amount = scanner.nextDouble();
	                    budgetTracker.addExpense(description, amount);
	                    break;
	                case 2:
	                    budgetTracker.viewTotalExpenses();
	                    break;
	                case 3:
	                    budgetTracker.viewRemainingBudget();
	                    break;
	                case 4:
	                    System.out.println("Exiting...");
	                    System.exit(0);
	                default:
	                    System.out.println("Please choose again.");
	            }
	        }
	    }
	}
	
	
	
	

