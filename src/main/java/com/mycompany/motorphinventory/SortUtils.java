package com.mycompany.motorphinventory;

import java.util.ArrayList;

/**
 * Utility class for sorting operations on inventory.
 */
public class SortUtils {

    public static void insertionSortByBrand(ArrayList<Stock> inventory) {
        for (int i = 1; i < inventory.size(); i++) {
            Stock key = inventory.get(i);
            int j = i - 1;
            while (j >= 0 && inventory.get(j).getBrand().compareToIgnoreCase(key.getBrand()) > 0) {
                inventory.set(j + 1, inventory.get(j));
                j--;
            }
            inventory.set(j + 1, key);
        }
    }

    public static void bubbleSortByBrand(ArrayList<Stock> inventory) {
        int n = inventory.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (inventory.get(j).getBrand().compareToIgnoreCase(inventory.get(j + 1).getBrand()) > 0) {
                    Stock temp = inventory.get(j);
                    inventory.set(j, inventory.get(j + 1));
                    inventory.set(j + 1, temp);
                }
            }
        }
    }
}
