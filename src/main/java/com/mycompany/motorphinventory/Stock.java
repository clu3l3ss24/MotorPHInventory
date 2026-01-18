package com.mycompany.motorphinventory;

/**
 * Represents a single stock item in MotorPH's inventory.
 */
public class Stock {
    private String dateEntered;
    private String stockLabel;
    private String brand;
    private String engineNumber;
    private String status;

    public Stock(String dateEntered, String stockLabel, String brand, String engineNumber, String status) {
        this.dateEntered = dateEntered;
        this.stockLabel = stockLabel;
        this.brand = brand;
        this.engineNumber = engineNumber;
        this.status = status;
    }

    public String getDateEntered() { return dateEntered; }
    public String getStockLabel() { return stockLabel; }
    public String getBrand() { return brand; }
    public String getEngineNumber() { return engineNumber; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return dateEntered + " | " + stockLabel + " | " + brand + " | " + engineNumber + " | " + status;
    }
}
