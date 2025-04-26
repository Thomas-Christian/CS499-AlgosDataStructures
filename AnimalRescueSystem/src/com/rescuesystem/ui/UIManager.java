package com.rescuesystem.ui;

import java.util.*;

import com.rescuesystem.data.AnimalManager;

/**
 * UIManager - Manages all user interface interactions
 */
public class UIManager {
    private AnimalManager animalManager;
    private Scanner scanner;
    private MenuSystem menuSystem;
    private InputHandler inputHandler;
    private boolean isRunning;
    
    // Constructor
    public UIManager(AnimalManager animalManager) {
        this.animalManager = animalManager;
        this.scanner = new Scanner(System.in);
        this.inputHandler = new InputHandler(scanner);
        this.menuSystem = new MenuSystem(this);
        this.isRunning = true;
    }
    
    // Start the UI
    public void start() {
        while (isRunning) {
            menuSystem.displayMainMenu();
            String input = scanner.nextLine();
            menuSystem.processMainMenu(input);
        }
    }
    
    // Exit the application
    public void exit() {
        isRunning = false;
        System.out.println("Goodbye!");
    }
    
    // Getters
    public AnimalManager getAnimalManager() {
        return animalManager;
    }
    
    public Scanner getScanner() {
        return scanner;
    }
    
    public InputHandler getInputHandler() {
        return inputHandler;
    }
}