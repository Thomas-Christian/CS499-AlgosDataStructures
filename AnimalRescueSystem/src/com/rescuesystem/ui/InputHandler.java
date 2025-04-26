package com.rescuesystem.ui;

import java.util.*;

/**
 * InputHandler - Validates and processes user input
 */
public class InputHandler {
    private Scanner scanner;
    
    // Constructor
    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }
    
    // Get scanner
    public Scanner getScanner() {
        return scanner;
    }
    
    // Validate input against list of valid options
    public String validateInput(String field, List<String> validOptions) {
        String input = scanner.nextLine();
        
        while (!validOptions.contains(input.toLowerCase())) {
            System.out.println("Invalid " + field + ". Please enter one of: " + validOptions);
            input = scanner.nextLine();
        }
        
        return input;
    }
    
    // Validate numeric input
    public String validateNumericInput(String field) {
        String input = scanner.nextLine();
        
        while (!input.matches("\\d+(\\.\\d+)?")) {
            System.out.println("Invalid " + field + ". Please enter a number:");
            input = scanner.nextLine();
        }
        
        return input;
    }
    
    // Validate date input
    public String validateDateInput() {
        String input = scanner.nextLine();
        
        while (!input.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Invalid date format. Please use MM/DD/YYYY format:");
            input = scanner.nextLine();
        }
        
        return input;
    }
    
    // Get breed selection from list
    public String getBreedSelection(String[] breeds) {
        // Display available breeds
        System.out.println("Available breeds:");
        for (int i = 0; i < breeds.length; i++) {
            System.out.println((i + 1) + ". " + breeds[i]);
        }
        
        System.out.println("Enter breed (or number):");
        String input = scanner.nextLine();
        
        // Handle numeric input
        try {
            int index = Integer.parseInt(input) - 1;
            if (index >= 0 && index < breeds.length) {
                return breeds[index];
            }
        } catch (NumberFormatException e) {
            // Not a number, use input as-is
        }
        
        return input;
    }
    
    // Get species selection from list
    public String getSpeciesSelection(List<String> species) {
        // Display available species
        System.out.println("Available species:");
        for (int i = 0; i < species.size(); i++) {
            System.out.println((i + 1) + ". " + species.get(i));
        }
        
        System.out.println("Enter species (or number):");
        String input = scanner.nextLine();
        
        // Handle numeric input
        try {
            int index = Integer.parseInt(input) - 1;
            if (index >= 0 && index < species.size()) {
                return species.get(index);
            }
        } catch (NumberFormatException e) {
            // Not a number, use input as-is
        }
        
        return input;
    }
    
    // Wait for user to press Enter
    public void waitForEnter() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
