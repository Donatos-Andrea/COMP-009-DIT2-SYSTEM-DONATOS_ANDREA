import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

class Sale {
    private String customerName;
    private String date;
    private int quantity;
    private double price;

    public Sale(String customerName, int quantity, double price) {
        this.customerName = customerName;
        this.quantity = quantity;
        this.price = price;
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Customer: " + customerName + ", Quantity: " + quantity + ", Price: $" + price + ", Total: $" + getTotal();
    }
}

class SalesLedger {
    private List<Sale> sales;

    public SalesLedger() {
        sales = new ArrayList<>();
    }

    public void addSale(Sale sale) {
        sales.add(sale);
    }

    public List<Sale> getSales() {
        return sales;
    }

    public double getTotalIncome() {
        double totalIncome = 0;
        for (Sale sale : sales) {
            totalIncome += sale.getTotal();
        }
        return totalIncome;
    }

    public void generateReport() {
        System.out.println("Sales Report");
        System.out.println("============");
        for (Sale sale : sales) {
            System.out.println(sale);
        }
        System.out.println("============");
        System.out.println("Total Income: $" + getTotalIncome());
    }
}

public class Aquatrack {
    private static SalesLedger ledger = new SalesLedger();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Aquatrack: Water Refilling Station Sales Ledger System");
            System.out.println("1. Record Sale");
            System.out.println("2. View Sales Report");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    recordSale();
                    break;
                case 2:
                    ledger.generateReport();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void recordSale() {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price per unit: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        Sale sale = new Sale(customerName, quantity, price);
        ledger.addSale(sale);
        System.out.println("Sale recorded successfully.");
    }
}
