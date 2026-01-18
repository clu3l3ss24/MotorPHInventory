package com.mycompany.motorphinventory;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;

public class InventoryApp {
    public static void main(String[] args) {
        MotorPHInventory inv = new MotorPHInventory();

        // ✅ Load CSV from classpath (src/main/resources/data)
        try (InputStream is = InventoryApp.class.getResourceAsStream("/data/MotorPH Inventory Data.csv");
             CSVReader reader = new CSVReader(new InputStreamReader(is))) {

            String[] values;
            reader.readNext(); // skip header
            while ((values = reader.readNext()) != null) {
                if (values.length == 5) {
                    Stock stock = new Stock(values[0], values[1], values[2], values[3], values[4]);
                    inv.loadStock(stock); // ✅ load without saving
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- MotorPH Inventory Menu ---");
            System.out.println("1. Display inventory");
            System.out.println("2. Sort inventory by brand");
            System.out.println("3. Search by brand");
            System.out.println("4. Delete stock by engine number");
            System.out.println("5. Add new stock");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    inv.displayInventory();
                    break;
                case 2:
                    inv.sortByBrand();
                    System.out.println("Inventory sorted by brand.");
                    break;
                case 3:
                    System.out.print("Enter brand to search: ");
                    String brand = sc.nextLine();
                    SearchUtils.searchByBrand(inv.getInventory(), brand);
                    break;
                case 4:
                    System.out.print("Enter engine number to delete: ");
                    String engineNo = sc.nextLine();
                    inv.deleteStock(engineNo); // ✅ automatically updates CSV
                    break;
                case 5:
                    System.out.println("Enter new stock details:");
                    System.out.print("Date Entered: ");
                    String date = sc.nextLine();
                    System.out.print("Stock Label: ");
                    String label = sc.nextLine();
                    System.out.print("Brand: ");
                    String newBrand = sc.nextLine();
                    System.out.print("Engine Number: ");
                    String engine = sc.nextLine();
                    System.out.print("Status: ");
                    String status = sc.nextLine();

                    Stock newStock = new Stock(date, label, newBrand, engine, status);
                    inv.addStock(newStock); // ✅ automatically updates CSV
                    System.out.println("New stock added successfully!");
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
