package com.rescuesystem.operations;

import java.util.*;

import com.rescuesystem.data.AnimalManager;
import com.rescuesystem.model.RescueAnimal;
import com.rescuesystem.ui.InputHandler;

/**
 * SearchOperations - Handles all search operations
 */
public class SearchOperations {
    private AnimalManager animalManager;
    private InputHandler inputHandler;
    private Scanner scanner;
    
    // Constructor
    public SearchOperations(AnimalManager animalManager, InputHandler inputHandler) {
        this.animalManager = animalManager;
        this.inputHandler = inputHandler;
        this.scanner = inputHandler.getScanner();
    }
    
    // Search by name
    public void searchByName() {
        System.out.println("Enter partial name to search:");
        String nameFragment = scanner.nextLine();
        
        List<RescueAnimal> fuzzyResults = animalManager.fuzzyNameSearch(nameFragment);
        
        if (!fuzzyResults.isEmpty()) {
            System.out.println("\nMatching animals:");
            System.out.println("----------------------------------------------------------");
            System.out.printf("%-15s %-10s %-15s %-15s\n", "Name", "Type", "Status", "Location");
            System.out.println("----------------------------------------------------------");
            
            for (RescueAnimal animal : fuzzyResults) {
                System.out.printf("%-15s %-10s %-15s %-15s\n", 
                    animal.getName(), 
                    animal.getAnimalType(), 
                    animal.getTrainingStatus(), 
                    animal.getInServiceLocation());
            }
        } else {
            System.out.println("No animals found matching that name.");
        }
        
        inputHandler.waitForEnter();
    }
    
    // Search by type and country
    public void searchByTypeAndCountry() {
        Map<String, String> criteria = new HashMap<>();
        
        System.out.println("Enter animal type (Dog/Monkey/Cat/Bird):");
        String type = scanner.nextLine();
        
        System.out.println("Enter country:");
        String country = scanner.nextLine();
        
        criteria.put("type", type);
        criteria.put("inServiceCountry", country);
        
        List<RescueAnimal> typeCountryResults = animalManager.multiCriteriaSearch(criteria);
        
        if (!typeCountryResults.isEmpty()) {
            System.out.println("\nMatching animals:");
            System.out.println("----------------------------------------------------------");
            System.out.printf("%-15s %-15s %-15s\n", "Name", "Status", "Reserved");
            System.out.println("----------------------------------------------------------");
            
            for (RescueAnimal animal : typeCountryResults) {
                System.out.printf("%-15s %-15s %-15s\n", 
                    animal.getName(), 
                    animal.getTrainingStatus(), 
                    animal.getReserved() ? "Yes" : "No");
            }
        } else {
            System.out.println("No animals found matching those criteria.");
        }
        
        inputHandler.waitForEnter();
    }
    
    // Search by multiple criteria
    public void searchByMultipleCriteria() {
        Map<String, String> criteria = new HashMap<>();
        
        System.out.println("Enter search criteria (leave blank to skip):");
        
        System.out.println("Type (Dog/Monkey/Cat/Bird):");
        String multiType = scanner.nextLine();
        if (!multiType.isEmpty()) criteria.put("type", multiType);
        
        System.out.println("Training Status:");
        String status = scanner.nextLine();
        if (!status.isEmpty()) criteria.put("trainingStatus", status);
        
        System.out.println("Country:");
        String multiCountry = scanner.nextLine();
        if (!multiCountry.isEmpty()) criteria.put("inServiceCountry", multiCountry);
        
        System.out.println("Reserved (true/false):");
        String reserved = scanner.nextLine();
        if (!reserved.isEmpty()) criteria.put("reserved", reserved);
        
        // Handle breed/species-specific criteria
        if (multiType.equalsIgnoreCase("Dog")) {
            System.out.println("Breed:");
            String breed = scanner.nextLine();
            if (!breed.isEmpty()) criteria.put("breed", breed);
        } else if (multiType.equalsIgnoreCase("Cat")) {
            System.out.println("Breed:");
            String breed = scanner.nextLine();
            if (!breed.isEmpty()) criteria.put("breed", breed);
            
            System.out.println("House Trained (true/false):");
            String houseTrained = scanner.nextLine();
            if (!houseTrained.isEmpty()) criteria.put("houseTrained", houseTrained);
        } else if (multiType.equalsIgnoreCase("Monkey") || multiType.equalsIgnoreCase("Bird")) {
            System.out.println("Species:");
            String species = scanner.nextLine();
            if (!species.isEmpty()) criteria.put("species", species);
        }
        
        List<RescueAnimal> multiResults = animalManager.multiCriteriaSearch(criteria);
        
        if (!multiResults.isEmpty()) {
            System.out.println("\nMatching animals:");
            for (RescueAnimal animal : multiResults) {
                System.out.println(animal);
            }
        } else {
            System.out.println("No animals found matching those criteria.");
        }
        
        inputHandler.waitForEnter();
    }
    
    // Search by date range
    public void searchByDateRange() {
        System.out.println("Enter start date (MM/DD/YYYY):");
        String startDate = inputHandler.validateDateInput();
        
        System.out.println("Enter end date (MM/DD/YYYY):");
        String endDate = inputHandler.validateDateInput();
        
        List<RescueAnimal> animals = animalManager.findAnimalsByDateRange(startDate, endDate);
        
        if (!animals.isEmpty()) {
            System.out.println("\nAnimals acquired between " + startDate + " and " + endDate + ":");
            System.out.println("----------------------------------------------------------");
            System.out.printf("%-15s %-10s %-15s %-15s\n", "Name", "Type", "Date", "Location");
            System.out.println("----------------------------------------------------------");
            
            for (RescueAnimal animal : animals) {
                System.out.printf("%-15s %-10s %-15s %-15s\n", 
                    animal.getName(), 
                    animal.getAnimalType(), 
                    animal.getAcquisitionDate(), 
                    animal.getAcquisitionLocation());
            }
        } else {
            System.out.println("No animals found in that date range.");
        }
        
        inputHandler.waitForEnter();
    }
}
