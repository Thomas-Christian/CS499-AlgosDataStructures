package com.rescuesystem.operations;

import java.util.*;

import com.rescuesystem.data.AnimalManager;
import com.rescuesystem.model.Bird;
import com.rescuesystem.model.Cat;
import com.rescuesystem.model.Dog;
import com.rescuesystem.model.Monkey;
import com.rescuesystem.ui.InputHandler;

/**
 * IntakeOperations - Handles all animal intake operations
 */
public class IntakeOperations {
    private AnimalManager animalManager;
    private InputHandler inputHandler;
    private Scanner scanner;
    
    // Constructor
    public IntakeOperations(AnimalManager animalManager, InputHandler inputHandler) {
        this.animalManager = animalManager;
        this.inputHandler = inputHandler;
        this.scanner = inputHandler.getScanner();
    }
    
    // Intake a new dog
    public void intakeNewDog() {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        
        // Check if dog already exists
        if (animalManager.getAnimal(name) != null) {
            System.out.println("\n\nThis dog is already in our system\n\n");
            inputHandler.waitForEnter();
            return;
        }
        
        // Get breed
        String breed = inputHandler.getBreedSelection(Dog.DOG_BREEDS);
        
        // Get other dog information
        System.out.println("What is the dog's gender (male/female)?");
        String gender = inputHandler.validateInput("gender", Arrays.asList("male", "female"));
        
        System.out.println("What is the dog's age?");
        String age = inputHandler.validateNumericInput("age");
        
        System.out.println("What is the dog's weight?");
        String weight = inputHandler.validateNumericInput("weight");
        
        System.out.println("When was the dog acquired? Please enter: (MM/DD/YYYY)");
        String acquisitionDate = inputHandler.validateDateInput();
        
        System.out.println("Where was the dog acquired?");
        String acquisitionLocation = scanner.nextLine();
        
        System.out.println("What is the dog's training status?");
        String trainingStatus = scanner.nextLine();
        
        System.out.println("Is the dog reserved? (yes/no)");
        String isReservedStr = inputHandler.validateInput("reservation status", Arrays.asList("yes", "no"));
        boolean reserved = isReservedStr.equalsIgnoreCase("yes");
        
        System.out.println("What is the dog's service country?");
        String serviceCountry = scanner.nextLine();
        
        // Create and add the dog
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionLocation, 
                          trainingStatus, reserved, serviceCountry);
        animalManager.addAnimal(newDog);
        
        System.out.println("Dog added successfully!");
        inputHandler.waitForEnter();
    }
    
    // Intake a new monkey
    public void intakeNewMonkey() {
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();
        
        // Check if monkey already exists
        if (animalManager.getAnimal(name) != null) {
            System.out.println("\n\nThis monkey is already in our system\n\n");
            inputHandler.waitForEnter();
            return;
        }
        
        System.out.println("What is the monkey's gender (male/female)?");
        String gender = inputHandler.validateInput("gender", Arrays.asList("male", "female"));
        
        System.out.println("What is the monkey's age?");
        String age = inputHandler.validateNumericInput("age");
        
        System.out.println("What is the monkey's weight?");
        String weight = inputHandler.validateNumericInput("weight");
        
        System.out.println("When was the monkey acquired? Please enter: (MM/DD/YYYY)");
        String acquisitionDate = inputHandler.validateDateInput();
        
        System.out.println("Where was the monkey acquired?");
        String acquisitionLocation = scanner.nextLine();
        
        System.out.println("What is the monkey's training status?");
        String trainingStatus = scanner.nextLine();
        
        System.out.println("Is the monkey reserved? (yes/no)");
        String isReservedStr = inputHandler.validateInput("reservation status", Arrays.asList("yes", "no"));
        boolean reserved = isReservedStr.equalsIgnoreCase("yes");
        
        System.out.println("What is the monkey's service country?");
        String serviceCountry = scanner.nextLine();
        
        System.out.println("What is the monkey's tail length (in inches)?");
        String tailLength = inputHandler.validateNumericInput("tail length");
        
        System.out.println("What is the monkey's height (in inches)?");
        String height = inputHandler.validateNumericInput("height");
        
        System.out.println("What is the monkey's body length (in inches)?");
        String bodyLength = inputHandler.validateNumericInput("body length");
        
        // Get species
        String species = inputHandler.getSpeciesSelection(Monkey.returnSpecies());
        
        // Create and add the monkey
        Monkey newMonkey = new Monkey(name, gender, age, weight, acquisitionDate, acquisitionLocation, 
                                    trainingStatus, reserved, serviceCountry, tailLength, height, 
                                    bodyLength, species);
        animalManager.addAnimal(newMonkey);
        
        System.out.println("Monkey added successfully!");
        inputHandler.waitForEnter();
    }
    
    // Intake a new cat
    public void intakeNewCat() {
        System.out.println("What is the cat's name?");
        String name = scanner.nextLine();
        
        // Check if cat already exists
        if (animalManager.getAnimal(name) != null) {
            System.out.println("\n\nThis cat is already in our system\n\n");
            inputHandler.waitForEnter();
            return;
        }
        
        // Get breed
        String breed = inputHandler.getBreedSelection(Cat.CAT_BREEDS);
        
        System.out.println("What is the cat's gender (male/female)?");
        String gender = inputHandler.validateInput("gender", Arrays.asList("male", "female"));
        
        System.out.println("What is the cat's age?");
        String age = inputHandler.validateNumericInput("age");
        
        System.out.println("What is the cat's weight?");
        String weight = inputHandler.validateNumericInput("weight");
        
        System.out.println("When was the cat acquired? Please enter: (MM/DD/YYYY)");
        String acquisitionDate = inputHandler.validateDateInput();
        
        System.out.println("Where was the cat acquired?");
        String acquisitionLocation = scanner.nextLine();
        
        System.out.println("What is the cat's training status?");
        String trainingStatus = scanner.nextLine();
        
        System.out.println("Is the cat reserved? (yes/no)");
        String isReservedStr = inputHandler.validateInput("reservation status", Arrays.asList("yes", "no"));
        boolean reserved = isReservedStr.equalsIgnoreCase("yes");
        
        System.out.println("What is the cat's service country?");
        String serviceCountry = scanner.nextLine();
        
        System.out.println("Is the cat house trained? (yes/no)");
        String isHouseTrainedStr = inputHandler.validateInput("house trained status", Arrays.asList("yes", "no"));
        boolean houseTrained = isHouseTrainedStr.equalsIgnoreCase("yes");
        
        System.out.println("Is the cat declawed? (yes/no)");
        String isDeclawedeStr = inputHandler.validateInput("declawed status", Arrays.asList("yes", "no"));
        boolean declawed = isDeclawedeStr.equalsIgnoreCase("yes");
        
        // Create and add the cat
        Cat newCat = new Cat(name, breed, gender, age, weight, acquisitionDate, acquisitionLocation, 
                           trainingStatus, reserved, serviceCountry, houseTrained, declawed);
        animalManager.addAnimal(newCat);
        
        System.out.println("Cat added successfully!");
        inputHandler.waitForEnter();
    }
    
    // Intake a new bird
    public void intakeNewBird() {
        System.out.println("What is the bird's name?");
        String name = scanner.nextLine();
        
        // Check if bird already exists
        if (animalManager.getAnimal(name) != null) {
            System.out.println("\n\nThis bird is already in our system\n\n");
            inputHandler.waitForEnter();
            return;
        }
        
        // Get species
        String species = inputHandler.getSpeciesSelection(Bird.getValidSpecies());
        
        System.out.println("What is the bird's gender (male/female)?");
        String gender = inputHandler.validateInput("gender", Arrays.asList("male", "female"));
        
        System.out.println("What is the bird's age?");
        String age = inputHandler.validateNumericInput("age");
        
        System.out.println("What is the bird's weight?");
        String weight = inputHandler.validateNumericInput("weight");
        
        System.out.println("When was the bird acquired? Please enter: (MM/DD/YYYY)");
        String acquisitionDate = inputHandler.validateDateInput();
        
        System.out.println("Where was the bird acquired?");
        String acquisitionLocation = scanner.nextLine();
        
        System.out.println("What is the bird's training status?");
        String trainingStatus = scanner.nextLine();
        
        System.out.println("Is the bird reserved? (yes/no)");
        String isReservedStr = inputHandler.validateInput("reservation status", Arrays.asList("yes", "no"));
        boolean reserved = isReservedStr.equalsIgnoreCase("yes");
        
        System.out.println("What is the bird's service country?");
        String serviceCountry = scanner.nextLine();
        
        System.out.println("Can the bird fly? (yes/no)");
        String canFlyStr = inputHandler.validateInput("flying capability", Arrays.asList("yes", "no"));
        boolean canFly = canFlyStr.equalsIgnoreCase("yes");
        
        System.out.println("What is the bird's wingspan (in inches)?");
        double wingspan = Double.parseDouble(inputHandler.validateNumericInput("wingspan"));
        
        // Create and add the bird
        Bird newBird = new Bird(name, species, gender, age, weight, acquisitionDate, acquisitionLocation, 
                             trainingStatus, reserved, serviceCountry, canFly, wingspan);
        animalManager.addAnimal(newBird);
        
        System.out.println("Bird added successfully!");
        inputHandler.waitForEnter();
    }
}