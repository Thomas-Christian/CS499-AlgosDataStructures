package com.rescuesystem.ui;

import java.util.*;

import com.rescuesystem.data.AnimalManager;
import com.rescuesystem.operations.IntakeOperations;
import com.rescuesystem.operations.ManagementOperations;
import com.rescuesystem.operations.SearchOperations;
import com.rescuesystem.operations.ViewOperations;

/**
 * MenuSystem - Manages the display and processing of all menus
 */
public class MenuSystem {
    private UIManager uiManager;
    private AnimalManager animalManager;
    private Scanner scanner;
    private InputHandler inputHandler;
    
    // Operation handlers
    private IntakeOperations intakeOps;
    private ViewOperations viewOps;
    private ManagementOperations managementOps;
    private SearchOperations searchOps;
    
    // Constructor
    public MenuSystem(UIManager uiManager) {
        this.uiManager = uiManager;
        this.animalManager = uiManager.getAnimalManager();
        this.scanner = uiManager.getScanner();
        this.inputHandler = uiManager.getInputHandler();
        
        // Initialize operation handlers
        this.intakeOps = new IntakeOperations(animalManager, inputHandler);
        this.viewOps = new ViewOperations(animalManager, inputHandler);
        this.managementOps = new ManagementOperations(animalManager, inputHandler);
        this.searchOps = new SearchOperations(animalManager, inputHandler);
    }
    
    // Display main menu
    public void displayMainMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System");
        System.out.println("=======================================================");
        System.out.println("[1] Animal Intake");
        System.out.println("[2] View Animals");
        System.out.println("[3] Animal Management");
        System.out.println("[4] Search Options");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }
    
    // Process main menu selection
    public void processMainMenu(String input) {
        switch (input) {
            case "1":
                handleIntakeMenu();
                break;
                
            case "2":
                handleViewMenu();
                break;
                
            case "3":
                handleManagementMenu();
                break;
                
            case "4":
                handleSearchMenu();
                break;
                
            case "q":
                uiManager.exit();
                break;
                
            default:
                System.out.println("That's not a valid option!");
                break;
        }
    }
    
    // Handle intake menu
    private void handleIntakeMenu() {
        boolean subMenuActive = true;
        
        while (subMenuActive) {
            displayIntakeMenu();
            String input = scanner.nextLine();
            
            if (input.equals("b")) {
                subMenuActive = false;
            } else {
                processIntakeMenu(input);
            }
        }
    }
    
    // Display intake menu
    private void displayIntakeMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tAnimal Intake Menu");
        System.out.println("=======================================================");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Intake a new cat");
        System.out.println("[4] Intake a new bird");
        System.out.println("[b] Back to main menu");
        System.out.println();
        System.out.println("Enter a menu selection");
    }
    
    // Process intake menu selection
    private void processIntakeMenu(String input) {
        switch (input) {
            case "1":
                intakeOps.intakeNewDog();
                break;
                
            case "2":
                intakeOps.intakeNewMonkey();
                break;
                
            case "3":
                intakeOps.intakeNewCat();
                break;
                
            case "4":
                intakeOps.intakeNewBird();
                break;
                
            default:
                System.out.println("That's not a valid option!");
                break;
        }
    }
    
    // Handle view menu
    private void handleViewMenu() {
        boolean subMenuActive = true;
        
        while (subMenuActive) {
            displayViewMenu();
            String input = scanner.nextLine();
            
            if (input.equals("b")) {
                subMenuActive = false;
            } else {
                processViewMenu(input);
            }
        }
    }
    
    // Display view menu
    private void displayViewMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tView Animals Menu");
        System.out.println("=======================================================");
        System.out.println("[1] View all dogs");
        System.out.println("[2] View all monkeys");
        System.out.println("[3] View all cats");
        System.out.println("[4] View all birds");
        System.out.println("[5] View all available animals");
        System.out.println("[6] View all therapy animals");
        System.out.println("[b] Back to main menu");
        System.out.println();
        System.out.println("Enter a menu selection");
    }
    
    // Process view menu selection
    private void processViewMenu(String input) {
        switch (input) {
            case "1":
                viewOps.printAnimals("Dog");
                break;
                
            case "2":
                viewOps.printAnimals("Monkey");
                break;
                
            case "3":
                viewOps.printAnimals("Cat");
                break;
                
            case "4":
                viewOps.printAnimals("Bird");
                break;
                
            case "5":
                viewOps.printAvailableAnimals();
                break;
                
            case "6":
                viewOps.printTherapyAnimals();
                break;
                
            default:
                System.out.println("That's not a valid option!");
                break;
        }
    }
    
    // Handle management menu
    private void handleManagementMenu() {
        boolean subMenuActive = true;
        
        while (subMenuActive) {
            displayManagementMenu();
            String input = scanner.nextLine();
            
            if (input.equals("b")) {
                subMenuActive = false;
            } else {
                processManagementMenu(input);
            }
        }
    }
    
    // Display management menu
    private void displayManagementMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tAnimal Management Menu");
        System.out.println("=======================================================");
        System.out.println("[1] Reserve an animal");
        System.out.println("[2] Update animal training status");
        System.out.println("[3] Animal relationship management");
        System.out.println("[b] Back to main menu");
        System.out.println();
        System.out.println("Enter a menu selection");
    }
    
    // Process management menu selection
    private void processManagementMenu(String input) {
        switch (input) {
            case "1":
                managementOps.reserveAnimal();
                break;
                
            case "2":
                managementOps.updateAnimalTraining();
                break;
                
            case "3":
                managementOps.manageRelationships();
                break;
                
            default:
                System.out.println("That's not a valid option!");
                break;
        }
    }
    
    // Handle search menu
    private void handleSearchMenu() {
        boolean subMenuActive = true;
        
        while (subMenuActive) {
            displaySearchMenu();
            String input = scanner.nextLine();
            
            if (input.equals("b")) {
                subMenuActive = false;
            } else {
                processSearchMenu(input);
            }
        }
    }
    
    // Display search menu
    private void displaySearchMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tSearch Options Menu");
        System.out.println("=======================================================");
        System.out.println("[1] Search by name (fuzzy search)");
        System.out.println("[2] Search by type and country");
        System.out.println("[3] Search by multiple criteria");
        System.out.println("[4] Search by date range");
        System.out.println("[b] Back to main menu");
        System.out.println();
        System.out.println("Enter a menu selection");
    }
    
    // Process search menu selection
    private void processSearchMenu(String input) {
        switch (input) {
            case "1":
                searchOps.searchByName();
                break;
                
            case "2":
                searchOps.searchByTypeAndCountry();
                break;
                
            case "3":
                searchOps.searchByMultipleCriteria();
                break;
                
            case "4":
                searchOps.searchByDateRange();
                break;
                
            default:
                System.out.println("That's not a valid option!");
                break;
        }
    }
}