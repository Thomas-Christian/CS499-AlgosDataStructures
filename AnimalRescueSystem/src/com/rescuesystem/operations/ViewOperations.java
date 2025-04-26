package com.rescuesystem.operations;

import java.util.*;

import com.rescuesystem.data.AnimalManager;
import com.rescuesystem.model.RescueAnimal;
import com.rescuesystem.ui.InputHandler;

/**
 * ViewOperations - Handles all animal viewing operations
 */
public class ViewOperations {
    private AnimalManager animalManager;
    private InputHandler inputHandler;
    
    // Constructor
    public ViewOperations(AnimalManager animalManager, InputHandler inputHandler) {
        this.animalManager = animalManager;
        this.inputHandler = inputHandler;
    }
    
    // Print animals by type
    public void printAnimals(String animalType) {
        List<RescueAnimal> animals = animalManager.getAnimalsByType(animalType);
        
        if (!animals.isEmpty()) {
            System.out.println("\nAll " + animalType + "s:");
            System.out.println("-------------------------------------------------");
            System.out.printf("%-15s %-15s %-15s %-10s\n", "Name", "Status", "Reserved", "Location");
            System.out.println("-------------------------------------------------");
            
            for (RescueAnimal animal : animals) {
                System.out.printf("%-15s %-15s %-15s %-10s\n", 
                    animal.getName(), 
                    animal.getTrainingStatus(), 
                    animal.getReserved() ? "Yes" : "No", 
                    animal.getInServiceLocation());
            }
        } else {
            System.out.println("No " + animalType + "s found.");
        }
        
        inputHandler.waitForEnter();
    }
    
    // Print available animals
    public void printAvailableAnimals() {
        List<RescueAnimal> availableAnimals = animalManager.getAvailableAnimals();
        
        if (!availableAnimals.isEmpty()) {
            System.out.println("\nAvailable Animals (in service and not reserved):");
            System.out.println("----------------------------------------------------------");
            System.out.printf("%-15s %-10s %-15s %-15s\n", "Name", "Type", "Status", "Location");
            System.out.println("----------------------------------------------------------");
            
            for (RescueAnimal animal : availableAnimals) {
                System.out.printf("%-15s %-10s %-15s %-15s\n", 
                    animal.getName(), 
                    animal.getAnimalType(), 
                    animal.getTrainingStatus(), 
                    animal.getInServiceLocation());
            }
        } else {
            System.out.println("No available animals found.");
        }
        
        inputHandler.waitForEnter();
    }
    
    // Print therapy animals
    public void printTherapyAnimals() {
        List<RescueAnimal> therapyAnimals = animalManager.getTherapyAnimals();
        
        if (!therapyAnimals.isEmpty()) {
            System.out.println("\nTherapy Animals:");
            System.out.println("----------------------------------------------------------");
            System.out.printf("%-15s %-10s %-15s %-15s\n", "Name", "Type", "Status", "Location");
            System.out.println("----------------------------------------------------------");
            
            for (RescueAnimal animal : therapyAnimals) {
                System.out.printf("%-15s %-10s %-15s %-15s\n", 
                    animal.getName(), 
                    animal.getAnimalType(), 
                    animal.getTrainingStatus(), 
                    animal.getInServiceLocation());
            }
        } else {
            System.out.println("No therapy animals found.");
        }
        
        inputHandler.waitForEnter();
    }
}
