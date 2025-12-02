package com.mphasis.util;

import com.mphasis.assets.Vehicle;
import com.mphasis.exceptions.InvalidInputException;

import java.util.List;
import java.util.Scanner;

public class InputUtils {
    private final Scanner scanner;
    private final List<Vehicle> vehiclesForUniqueness;

    // vehicles list is injected for registration uniqueness check
    public InputUtils(Scanner scanner, List<Vehicle> vehiclesForUniqueness) {
        this.scanner = scanner;
        this.vehiclesForUniqueness = vehiclesForUniqueness;
    }

    // Overload without prompt used in main menus
    public int readIntInRange(int min, int max) {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                int val = Integer.parseInt(line);
                if (val < min || val > max) throw new NumberFormatException();
                return val;
            } catch (NumberFormatException ex) {
                System.out.print("Please enter a numeric choice between " + min + " and " + max + ": ");
            }
        }
    }

    public int readIntInRange(String prompt, int min, int max) throws InvalidInputException {
        System.out.print(prompt);
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                int val = Integer.parseInt(line);
                if (val < min || val > max) throw new InvalidInputException("Value out of range.");
                return val;
            } catch (InvalidInputException e) {
                System.out.print("Invalid value. " + prompt);
            } catch (NumberFormatException nfe) {
                System.out.print("Enter a valid integer. " + prompt);
            }
        }
    }

    public int readIntPositive(String prompt) throws InvalidInputException {
        System.out.print(prompt);
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                int val = Integer.parseInt(line);
                if (val <= 0) throw new InvalidInputException("Value must be positive and non-zero.");
                return val;
            } catch (NumberFormatException nfe) {
                System.out.print("Enter a valid positive integer. " + prompt);
            }
        }
    }

    public double readDoublePositive(String prompt) throws InvalidInputException {
        System.out.print(prompt);
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                double val = Double.parseDouble(line);
                if (val <= 0) throw new InvalidInputException("Value must be positive and non-zero.");
                return val;
            } catch (NumberFormatException nfe) {
                System.out.print("Enter a valid positive number. " + prompt);
            }
        }
    }

    public double readDoubleInRange(String prompt, double min, double max) throws InvalidInputException {
        System.out.print(prompt);
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                double val = Double.parseDouble(line);
                if (val < min || val > max) throw new InvalidInputException("Value out of allowed range.");
                return val;
            } catch (NumberFormatException nfe) {
                System.out.print("Enter a valid number. " + prompt);
            }
        }
    }

    public boolean readYesNo() {
        while (true) {
            String s = scanner.nextLine().trim();
            if (s.equalsIgnoreCase("Y")) return true;
            if (s.equalsIgnoreCase("N")) return false;
            System.out.print("Enter Y or N: ");
        }
    }

    public char readYesNoChar() {
        while (true) {
            String s = scanner.nextLine().trim();
            if (s.length() == 1 && (s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("N"))) {
                return s.charAt(0);
            }
            System.out.print("Invalid. Enter single character Y or N: ");
        }
    }

    public String readFourDigitRegistration() throws InvalidInputException {
        System.out.print("Registration number (4 digits, leading zeros allowed, 0000 invalid): ");
        while (true) {
            String reg = scanner.nextLine().trim();
            if (reg.length() == 4 && reg.matches("\\d{4}") && !reg.equals("0000")) {
                boolean exists = vehiclesForUniqueness.stream()
                        .anyMatch(v -> v.getRegistrationNumber().equals(reg));
                if (exists) {
                    System.out.print("Registration exists. Enter a unique 4-digit registration: ");
                } else {
                    return reg;
                }
            } else {
                System.out.print("Invalid registration. Please enter 4 digits (e.g., 0010): ");
            }
        }
    }

    // Example of an age factor computation — change as needed for your assignment
    public double computeAgeFactor(int age) {
        // Simple example: 1.0 + age/100. Older structures slightly increase factor.
        // If your teacher expects a different formula, modify this method.
        return 1.0 + (age / 100.0);
    }
}
