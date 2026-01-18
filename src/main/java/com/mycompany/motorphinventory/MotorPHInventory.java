package com.mycompany.motorphinventory;

import java.util.ArrayList;

/**
 * Main inventory manager class.
 */
public class MotorPHInventory {
    private ArrayList<Stock> inventory = new ArrayList<>();

    public void addStock(Stock stock) {
        inventory.add(stock);
    }

    public void deleteStock(String engineNumber) {
        Stock toDelete = SearchUtils.searchByEngineNumber(inventory, engineNumber);
        if (toDelete != null) {
            inventory.remove(toDelete);
            System.out.println("Deleted stock: " + engineNumber);
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
}
