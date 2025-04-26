package com.rescuesystem;

import com.rescuesystem.data.AnimalManager;
import com.rescuesystem.data.DataInitializer;
import com.rescuesystem.ui.UIManager;

/**
 * Main driver class - bootstraps the application
 */
public class Main {
    public static void main(String[] args) {
        // Initialize the application
        AnimalManager animalManager = new AnimalManager();
        
        // Initialize sample data
        DataInitializer initializer = new DataInitializer(animalManager);
        initializer.initializeAllAnimals();
        
        // Create the UI manager
        UIManager uiManager = new UIManager(animalManager);
        
        // Start the application
        uiManager.start();
    }
}