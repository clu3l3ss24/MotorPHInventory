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

        // Load CSV from classpath
        try (InputStream is = InventoryApp.class.getResourceAsStream("/data/MotorPH Inventory Data.csv");
             CSVReader reader = new CSVReader(new InputStreamReader(is))) {

            String[] values;
            reader.readNext(); // skip header
            while ((values = reader.readNext()) != null) {
                if (values.length == 5) {
                    Stock stock = new Stock(values[0], values[1], values[2], values[3], values[4]);
                    inv.addStock(stock);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        // Interactive menu
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- MotorPH Inventory Menu ---");
            System.out.println("1. Display inventory");
            System.out.println("2. Sort inventory by brand");
            System.out.println("3. Search by brand");
            System.out.println("4. Delete stock by engine number");
            System.out.println("5. Exit");
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
                    inv.deleteStock(engineNo);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
