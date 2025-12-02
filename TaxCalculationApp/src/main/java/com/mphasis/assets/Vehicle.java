package com.mphasis.assets;

public class Vehicle extends Asset {
    private final String registrationNumber; // 4-digit string
    private final String brand;
    private final double purchaseCost;
    private final int maxVelocity;
    private final int capacity;
    private final int type; // 1=Petrol,2=Diesel,3=CNG/LPG

    public Vehicle(String registrationNumber, String brand, double purchaseCost, int maxVelocity, int capacity, int type) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.purchaseCost = purchaseCost;
        this.maxVelocity = maxVelocity;
        this.capacity = capacity;
        this.type = type;
    }

    public String getRegistrationNumber() { return registrationNumber; }
    public String getBrand() { return brand; }
    public double getPurchaseCost() { return purchaseCost; }
    public int getMaxVelocity() { return maxVelocity; }
    public int getCapacity() { return capacity; }

    @Override
    public double calculateTax() {
        double pct;
        if (type == 1) pct = 0.10;
        else if (type == 2) pct = 0.11;
        else pct = 0.12;
        // as per formula: velocity + capacity + (pct * purchaseCost)
        return maxVelocity + capacity + (pct * purchaseCost);
    }
}
