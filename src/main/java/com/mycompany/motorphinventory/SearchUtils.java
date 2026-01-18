package com.mycompany.motorphinventory;

import java.util.ArrayList;

/**
 * Utility class for searching operations on inventory.
 */
public class SearchUtils {

    public static void searchByBrand(ArrayList<Stock> inventory, String brand) {
        boolean found = false;
        for (Stock s : inventory) {
            if (s.getBrand().equalsIgnoreCase(brand)) {
                System.out.println("Found: " + s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No stocks found for brand: " + brand);
        }
    }

    public static Stock searchByEngineNumber(ArrayList<Stock> inventory, String engineNumber) {
        for (Stock s : inventory) {
            if (s.getEngineNumber().equalsIgnoreCase(engineNumber)) {
                return s;
            }
        }
        return null;
    }
}
