package com.mycompany.motorphinventory;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Main inventory manager class.
 * Automatically updates CSV whenever stocks are added or deleted.
 */
public class MotorPHInventory {
    private ArrayList<Stock> inventory = new ArrayList<>();
    private final String csvFilePath = "src/main/resources/data/MotorPH Inventory Data.csv";

    // Used only for loading from CSV at startup (no save)
    public void loadStock(Stock stock) {
        inventory.add(stock);
    }

    // Used when user adds a new stock (saves automatically)
    public void addStock(Stock stock) {
        inventory.add(stock);
        saveInventoryToCSV(); // ✅ automatically update CSV
    }

    public void deleteStock(String engineNumber) {
        Stock toDelete = SearchUtils.searchByEngineNumber(inventory, engineNumber);
        if (toDelete != null) {
            inventory.remove(toDelete);
            System.out.println("Deleted stock successfully!");
            saveInventoryToCSV(); // ✅ automatically update CSV
        } else {
            System.out.println("Stock not found: " + engineNumber);
        }
    }

    public void sortByBrand() {
        SortUtils.insertionSortByBrand(inventory);
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("(No inventory data loaded)");
        } else {
            for (Stock s : inventory) {
                System.out.println(s);
            }
        }
    }

    public ArrayList<Stock> getInventory() {
        return inventory;
    }

    // ✅ Private method to always keep CSV in sync (no console message)
    private void saveInventoryToCSV() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            writer.writeNext(new String[]{"Date Entered", "Stock Label", "Brand", "Engine Number", "Status"});
            for (Stock s : inventory) {
                writer.writeNext(new String[]{
                    s.getDateEntered(),
                    s.getStockLabel(),
                    s.getBrand(),
                    s.getEngineNumber(),
                    s.getStatus()
                });
            }
            // Removed the println here
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
