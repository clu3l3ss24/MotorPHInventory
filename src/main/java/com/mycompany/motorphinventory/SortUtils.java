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
}
