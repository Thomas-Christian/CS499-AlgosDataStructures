package com.rescuesystem.operations;

import java.util.*;

import com.rescuesystem.data.AnimalManager;
import com.rescuesystem.model.Bird;
import com.rescuesystem.model.Cat;
import com.rescuesystem.model.Dog;
import com.rescuesystem.model.Monkey;
import com.rescuesystem.model.RescueAnimal;
import com.rescuesystem.ui.InputHandler;

/**
 * ManagementOperations - Handles all animal management operations
 */
public class ManagementOperations {
    private AnimalManager animalManager;
    private InputHandler inputHandler;
    private Scanner scanner;
    
    // Constructor
    public ManagementOperations(AnimalManager animalManager, InputHandler inputHandler) {
        this.animalManager = animalManager;
        this.inputHandler = inputHandler;
        this.scanner = inputHandler.getScanner();
    }
    
    // Reserve an animal
    public void reserveAnimal() {
        System.out.println("Enter the animal's name you want to reserve:");
        String name = scanner.nextLine();
        
        RescueAnimal animal = animalManager.getAnimal(name);
        
        if (animal == null) {
            System.out.println("Animal not found. Would you like to see available animals? (y/n)");
            String response = scanner.nextLine();
            
            if (response.equalsIgnoreCase("y")) {
                ViewOperations viewOps = new ViewOperations(animalManager, inputHandler);
                viewOps.printAvailableAnimals();
            }
            return;
        }
        
        if (animal.getReserved()) {
            System.out.println("This animal is already reserved.");
            inputHandler.waitForEnter();
            return;
        }
        
        System.out.println("Found " + animal.getAnimalType() + ": " + animal.getName());
        System.out.println("Status: " + animal.getTrainingStatus());
        System.out.println("Service country: " + animal.getInServiceLocation());
        
        System.out.println("Do you want to reserve this animal? (y/n)");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("y")) {
            if (animalManager.reserveAnimal(name, animal.getInServiceLocation())) {
                System.out.println(animal.getName() + " has been reserved successfully.");
            } else {
                System.out.println("Failed to reserve the animal.");
            }
        }
        
        inputHandler.waitForEnter();
    }
    
    // Update animal training status
    public void updateAnimalTraining() {
        System.out.println("Enter the name of the animal to update:");
        String name = scanner.nextLine();
        
        RescueAnimal animal = animalManager.getAnimal(name);
        
        if (animal != null) {
            System.out.println("Current training status: " + animal.getTrainingStatus());
            System.out.println("Enter new training status:");
            String newStatus = scanner.nextLine();
            
            if (animalManager.updateTrainingStatus(name, newStatus)) {
                System.out.println("Training status updated successfully!");
            } else {
                System.out.println("Failed to update training status.");
            }
        } else {
            System.out.println("Animal not found.");
        }
        
        inputHandler.waitForEnter();
    }
    
    // Animal relationship management
    public void manageRelationships() {
        boolean subMenuActive = true;
        
        while (subMenuActive) {
            System.out.println("\nAnimal Relationship Management");
            System.out.println("--------------------------------");
            System.out.println("[1] Find animals with similar characteristics");
            System.out.println("[b] Back to management menu");
            System.out.println();
            System.out.println("Enter a selection:");
            
            String option = scanner.nextLine();
            
            switch (option) {
                case "1":
                    findSimilarAnimals();
                    break;
                    
                case "b":
                    subMenuActive = false;
                    break;
                    
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
    
    // Find animals with similar characteristics
    private void findSimilarAnimals() {
        System.out.println("Enter animal name to find similar animals:");
        String name = scanner.nextLine();
        
        RescueAnimal animal = animalManager.getAnimal(name);
        
        if (animal != null) {
            List<RescueAnimal> similarAnimals = animalManager.findSimilarAnimals(animal);
            
            if (!similarAnimals.isEmpty()) {
                String similarityType = "";
                if (animal instanceof Dog) {
                    similarityType = "breed (" + ((Dog) animal).getBreed() + ")";
                } else if (animal instanceof Cat) {
                    similarityType = "breed (" + ((Cat) animal).getBreed() + ")";
                } else if (animal instanceof Monkey) {
                    similarityType = "species (" + ((Monkey) animal).getSpecies() + ")";
                } else if (animal instanceof Bird) {
                    similarityType = "species (" + ((Bird) animal).getSpecies() + ")";
                }
                
                System.out.println("\nAnimals with the same " + similarityType + ":");
                System.out.println("----------------------------------------------------------");
                System.out.printf("%-15s %-15s %-15s %-15s\n", "Name", "Status", "Reserved", "Location");
                System.out.println("----------------------------------------------------------");
                
                for (RescueAnimal similarAnimal : similarAnimals) {
                    System.out.printf("%-15s %-15s %-15s %-15s\n", 
                        similarAnimal.getName(), 
                        similarAnimal.getTrainingStatus(), 
                        similarAnimal.getReserved() ? "Yes" : "No", 
                        similarAnimal.getInServiceLocation());
                }
            } else {
                System.out.println("No similar animals found.");
            }
        } else {
            System.out.println("Animal not found.");
        }
        
        inputHandler.waitForEnter();
    }
}