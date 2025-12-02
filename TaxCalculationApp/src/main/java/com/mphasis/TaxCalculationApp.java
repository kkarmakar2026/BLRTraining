package com.mphasis;

import com.mphasis.assets.Property;
import com.mphasis.assets.Vehicle;
import com.mphasis.data.TempData;
import com.mphasis.exceptions.InvalidInputException;
import com.mphasis.util.InputUtils;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * TaxCalculationApp
 * Console-based Tax Calculation Application for Properties and Vehicles.
 *
 * Features:
 * - Add Property / Vehicle with validation
 * - Calculate taxes per given formulas
 * - Store in-memory and optionally serialize to temporary file (temp_data.ser)
 * - List items, totals, search, and sorting
 * - Navigation & graceful exit
 *
 * Developer: Koushik Karmakar
 */
public class TaxCalculationApp {
    // --- Temporary storage file name ---
    private static final String TEMP_FILE = "temp_data.ser";

    // Collections for storing assets
    private final List<Property> properties = new ArrayList<>();
    private final List<Vehicle> vehicles = new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);
    private final InputUtils input = new InputUtils(scanner, vehicles);
    private final DecimalFormat df = new DecimalFormat("#0.00");

    // Entry point
    public static void main(String[] args) {
        TaxCalculationApp app = new TaxCalculationApp();
        app.start();
    }

    private void start() {
        showWelcomeScreen();
        // On start, ask user if they want to load saved data if file exists
        File f = new File(TEMP_FILE);
        if (f.exists()) {
            System.out.print("Saved session found. Load data from previous session? (Y/N): ");
            String ans = scanner.nextLine().trim();
            if (ans.equalsIgnoreCase("Y")) {
                loadFromTemp();
            }
        }
        mainMenuLoop();
    }

    private void showWelcomeScreen() {
        System.out.println("==============================================");
        System.out.println("|        TAX CALCULATION APPLICATION         |");
        System.out.println("|        Developer: Koushik Karmakar         |");
        System.out.println("|       Email: koushik.karmakar26@gmail.com  |");
        System.out.println("==============================================");
        System.out.println("This application helps calculate tax on Properties and Vehicles.");
        System.out.println("Choose options using numeric menu choices. Follow input validations.");
        System.out.println();
    }

    private void mainMenuLoop() {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Property Management (Add / List)");
            System.out.println("2. Vehicle Management (Add / List)");
            System.out.println("3. Display Summary (All assets & totals)");
            System.out.println("4. Exit Application");
            System.out.print("Enter choice (1-4): ");

            int choice = input.readIntInRange(1, 4);
            switch (choice) {
                case 1:
                    propertyMenu();
                    break;
                case 2:
                    vehicleMenu();
                    break;
                case 3:
                    displaySummaryMenu();
                    break;
                case 4:
                    System.out.println("Exiting application. Goodbye!");
                    scanner.close();
                    return;
            }
        }
    }

    // --------------------
    // Property flows
    // --------------------
    private void propertyMenu() {
        while (true) {
            System.out.println("\nProperty Menu:");
            System.out.println("1. Add Property");
            System.out.println("2. List Properties");
            System.out.println("3. Search Property by ID");
            System.out.println("4. Sort Properties by Tax (desc)");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice (1-5): ");
            int ch = input.readIntInRange(1, 5);
            switch (ch) {
                case 1:
                    addPropertyFlow();
                    break;
                case 2:
                    listProperties();
                    break;
                case 3:
                    searchProperty();
                    break;
                case 4:
                    sortPropertiesByTaxDesc();
                    break;
                case 5:
                    return;
            }
        }
    }

    private void addPropertyFlow() {
        System.out.println("\n-- Add Property --");
        try {
            String id = UUID.randomUUID().toString().substring(0, 8); // short unique ID
            double builtUpArea = input.readDoublePositive("Built-up area (in sq units): ");
            double baseValue = input.readDoublePositive("Base value of land (positive, non-zero): ");
            System.out.print("Is property in main city? (Y/N): ");
            char cityChar = input.readYesNoChar();
            int age = input.readIntPositive("Age of construction (years, positive non-zero): ");

            // Age factor formula — adjust here if instructor gives explicit factor table.
            double ageFactor = input.computeAgeFactor(age);

            Property prop = new Property(id, builtUpArea, baseValue, cityChar, age, ageFactor);
            properties.add(prop);

            System.out.println("Property added with ID: " + id);
            System.out.println("Calculated property tax: " + df.format(prop.calculateTax()));

            System.out.print("Save this property to temporary storage? (Y/N): ");
            if (input.readYesNo()) {
                saveToTemp();
            }
        } catch (InvalidInputException ex) {
            System.out.println("Invalid input: " + ex.getMessage());
        }
    }

    private void listProperties() {
        System.out.println("\n-- Properties List --");
        if (properties.isEmpty()) {
            System.out.println("No Data Present at This Moment (Properties).");
            return;
        }

        String line = "+----------+--------------+--------------+--------+------+--------------+";
        System.out.println(line);
        System.out.printf("| %-8s | %-12s | %-12s | %-6s | %-4s | %-12s |\n",
                "PropID", "BuiltUpArea", "BaseValue", "City", "Age", "Tax");
        System.out.println(line);

        double sumTax = 0;
        for (Property p : properties) {
            double tax = p.calculateTax();
            sumTax += tax;
            System.out.printf("| %-8s | %-12.2f | %-12.2f | %-6s | %-4d | %-12s |\n",
                    p.getId(),
                    p.getBuiltUpArea(),
                    p.getBaseValue(),
                    p.isInMainCity() ? "Y" : "N",
                    p.getAge(),
                    df.format(tax));
        }

        System.out.println(line);
        System.out.println("Total properties: " + properties.size());
        System.out.println("Sum of property taxes: " + df.format(sumTax));
    }

    private void searchProperty() {
        if (properties.isEmpty()) {
            System.out.println("No Data Present at This Moment (Properties).");
            return;
        }
        System.out.print("Enter property ID to search: ");
        String id = scanner.nextLine().trim();
        Optional<Property> opt = properties.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (opt.isPresent()) {
            Property p = opt.get();
            System.out.printf("Found: ID=%s, BuiltUp=%.2f, BaseValue=%.2f, City=%s, Age=%d, Tax=%s\n",
                    p.getId(), p.getBuiltUpArea(), p.getBaseValue(), p.isInMainCity()? "Y":"N", p.getAge(), df.format(p.calculateTax()));
        } else {
            System.out.println("Property not found with ID: " + id);
        }
    }

    private void sortPropertiesByTaxDesc() {
        if (properties.isEmpty()) {
            System.out.println("No Data Present at This Moment (Properties).");
            return;
        }
        properties.sort(Comparator.comparingDouble(Property::calculateTax).reversed());
        System.out.println("Properties sorted by tax (descending). Use List option to view.");
    }

    // --------------------
    // Vehicle flows
    // --------------------
    private void vehicleMenu() {
        while (true) {
            System.out.println("\nVehicle Menu:");
            System.out.println("1. Add Vehicle");
            System.out.println("2. List Vehicles");
            System.out.println("3. Search Vehicle by Registration Number");
            System.out.println("4. Sort Vehicles by Tax (desc)");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice (1-5): ");
            int ch = input.readIntInRange(1, 5);
            switch (ch) {
                case 1:
                    addVehicleFlow();
                    break;
                case 2:
                    listVehicles();
                    break;
                case 3:
                    searchVehicle();
                    break;
                case 4:
                    sortVehiclesByTaxDesc();
                    break;
                case 5:
                    return;
            }
        }
    }

    private void addVehicleFlow() {
        System.out.println("\n-- Add Vehicle --");
        try {
            String regNum = input.readFourDigitRegistration();
            System.out.print("Brand: ");
            String brand = scanner.nextLine().trim();
            if (brand.isEmpty()) throw new InvalidInputException("Brand cannot be empty.");
            double purchaseCost = input.readDoubleInRange("Purchase cost (50,000 - 1,000,000): ", 50000, 1000000);
            int velocity = input.readIntInRange("Maximum velocity (120 - 300 kmph): ", 120, 300);
            int capacity = input.readIntInRange("Capacity (number of seats 2 - 50): ", 2, 50);
            System.out.println("Vehicle Type: 1=Petrol, 2=Diesel, 3=CNG/LPG");
            int type = input.readIntInRange("Enter type (1-3): ", 1, 3);

            Vehicle vehicle = new Vehicle(regNum, brand, purchaseCost, velocity, capacity, type);
            vehicles.add(vehicle);

            System.out.println("Vehicle added: RegNo=" + regNum);
            System.out.println("Calculated vehicle tax: " + df.format(vehicle.calculateTax()));

            System.out.print("Save this vehicle to temporary storage? (Y/N): ");
            if (input.readYesNo()) {
                saveToTemp();
            }
        } catch (InvalidInputException ex) {
            System.out.println("Invalid input: " + ex.getMessage());
        }
    }

    private void listVehicles() {
        System.out.println("\n-- Vehicles List --");
        if (vehicles.isEmpty()) {
            System.out.println("No Data Present at This Moment (Vehicles).");
            return;
        }

        String line = "+----------+--------------+------------+----------+----------+----------+";
        System.out.println(line);
        System.out.printf("| %-8s | %-12s | %-10s | %-8s | %-8s | %-8s |\n",
                "RegNo", "Brand", "Cost", "Vel", "Seats", "Tax");
        System.out.println(line);

        double sumTax = 0;
        for (Vehicle v : vehicles) {
            double tax = v.calculateTax();
            sumTax += tax;
            System.out.printf("| %-8s | %-12s | %-10.2f | %-8d | %-8d | %-8s |\n",
                    v.getRegistrationNumber(),
                    v.getBrand(),
                    v.getPurchaseCost(),
                    v.getMaxVelocity(),
                    v.getCapacity(),
                    df.format(tax));
        }

        System.out.println(line);
        System.out.println("Total vehicles: " + vehicles.size());
        System.out.println("Sum of vehicle taxes: " + df.format(sumTax));
    }

    private void searchVehicle() {
        if (vehicles.isEmpty()) {
            System.out.println("No Data Present at This Moment (Vehicles).");
            return;
        }
        System.out.print("Enter 4-digit registration number (leading zeros allowed): ");
        String reg = scanner.nextLine().trim();
        Optional<Vehicle> opt = vehicles.stream().filter(v -> v.getRegistrationNumber().equals(reg)).findFirst();
        if (opt.isPresent()) {
            Vehicle v = opt.get();
            System.out.printf("Found: Reg=%s, Brand=%s, Cost=%.2f, Vel=%d, Seats=%d, Tax=%s\n",
                    v.getRegistrationNumber(), v.getBrand(), v.getPurchaseCost(), v.getMaxVelocity(), v.getCapacity(), df.format(v.calculateTax()));
        } else {
            System.out.println("Vehicle not found with RegNo: " + reg);
        }
    }

    private void sortVehiclesByTaxDesc() {
        if (vehicles.isEmpty()) {
            System.out.println("No Data Present at This Moment (Vehicles).");
            return;
        }
        vehicles.sort(Comparator.comparingDouble(Vehicle::calculateTax).reversed());
        System.out.println("Vehicles sorted by tax (descending). Use List option to view.");
    }

    // --------------------
    // Summary menu: totals and combined
    // --------------------
    private void displaySummaryMenu() {
        while (true) {
            System.out.println("\nSummary Menu:");
            System.out.println("1. Display Properties and totals");
            System.out.println("2. Display Vehicles and totals");
            System.out.println("3. Display Combined Total Tax");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice (1-4): ");
            int ch = input.readIntInRange(1, 4);
            switch (ch) {
                case 1:
                    listProperties();
                    break;
                case 2:
                    listVehicles();
                    break;
                case 3:
                    displayCombinedTotals();
                    break;
                case 4:
                    return;
            }
        }
    }

    private void displayCombinedTotals() {
        double propSum = properties.stream().mapToDouble(Property::calculateTax).sum();
        double vehSum = vehicles.stream().mapToDouble(Vehicle::calculateTax).sum();
        int propCount = properties.size();
        int vehCount = vehicles.size();

        if (propCount == 0 && vehCount == 0) {
            System.out.println("No Data Present at This Moment (Neither properties nor vehicles).");
            return;
        }

        System.out.println("\n--- Combined Summary ---");

        String line = "+----------------+----------+----------------------+";
        System.out.println(line);
        System.out.printf("| %-14s | %-8s | %-20s |\n", "Category", "Quantity", "Tax");
        System.out.println(line);

        System.out.printf("| %-14s | %-8d | %-20s |\n",
                "Properties", propCount, df.format(propSum));
        System.out.printf("| %-14s | %-8d | %-20s |\n",
                "Vehicles", vehCount, df.format(vehSum));

        System.out.println(line);
        System.out.printf("| %-14s | %-8d | %-20s |\n",
                "Total", (propCount + vehCount), df.format(propSum + vehSum));
        System.out.println(line);
    }

    // --------------------
    // Persistence (serialize/deserialize)
    // --------------------
    private void saveToTemp() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TEMP_FILE))) {
            TempData td = new TempData(properties, vehicles);
            oos.writeObject(td);
            System.out.println("Saved session to temporary storage (" + TEMP_FILE + ").");
        } catch (IOException e) {
            System.out.println("Failed to save: " + e.getMessage());
        }
    }

    private void loadFromTemp() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TEMP_FILE))) {
            TempData td = (TempData) ois.readObject();
            properties.clear();
            properties.addAll(td.properties);
            vehicles.clear();
            vehicles.addAll(td.vehicles);
            System.out.println("Loaded " + properties.size() + " properties and " + vehicles.size() + " vehicles from temporary storage.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load temp data: " + e.getMessage());
        }
    }
}
