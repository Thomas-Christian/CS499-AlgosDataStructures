package com.rescuesystem.data;

import com.rescuesystem.model.Bird;
import com.rescuesystem.model.Cat;
import com.rescuesystem.model.Dog;
import com.rescuesystem.model.Monkey;

/**
 * DataInitializer - Initializes sample data for the application
 */
public class DataInitializer {
    private AnimalManager animalManager;
    
    // Constructor
    public DataInitializer(AnimalManager animalManager) {
        this.animalManager = animalManager;
    }
    
    // Initialize all animal types
    public void initializeAllAnimals() {
        initializeDogs();
        initializeMonkeys();
        initializeCats();
        initializeBirds();
    }
    
    // Initialize dogs
    private void initializeDogs() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05/12/2019", "United States", "intake",
                false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02/03/2020", "United States", "Phase I", false,
                "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12/12/2019", "Canada", "in service", true,
                "Canada");
        Dog dog4 = new Dog("Max", "Labrador Retriever", "male", "2", "32.1", "06/15/2020", "United States", "in service", false,
                "United States");
        Dog dog5 = new Dog("Scout", "Unknown", "male", "5", "28.3", "07/12/2021", "Mexico", "in service", false,
                "United States");

        animalManager.addAnimal(dog1);
        animalManager.addAnimal(dog2);
        animalManager.addAnimal(dog3);
        animalManager.addAnimal(dog4);
        animalManager.addAnimal(dog5);
    }
    
    // Initialize monkeys
    private void initializeMonkeys() {
        Monkey monkey1 = new Monkey("Meep", "male", "1", "15.2", "05/12/2019", "United States", "in service", false,
                "United States", "12.1", "18.2", "17.0", "Tamarin");
        
        Monkey monkey2 = new Monkey("Coco", "female", "3", "12.1", "03/15/2020", "Brazil", "Phase I", false,
                "United States", "13.2", "16.5", "15.7", "Capuchin");
                
        Monkey monkey3 = new Monkey("George", "male", "2", "14.5", "07/22/2020", "Indonesia", "in service", false,
                "Canada", "11.8", "17.2", "16.1", "Tamarin");
                
        Monkey monkey4 = new Monkey("Curious", "male", "1", "10.8", "09/03/2021", "Unknown", "intake", false,
                "United States", "10.5", "14.7", "13.2", "Unknown");

        animalManager.addAnimal(monkey1);
        animalManager.addAnimal(monkey2);
        animalManager.addAnimal(monkey3);
        animalManager.addAnimal(monkey4);
    }
    
    // Initialize cats
    private void initializeCats() {
        Cat cat1 = new Cat("Whiskers", "Siamese", "female", "3", "8.5", "06/10/2020", 
                      "United States", "in service", false, "United States", true, false);
        
        Cat cat2 = new Cat("Oliver", "Maine Coon", "male", "4", "15.2", "09/21/2019", 
                      "United States", "Phase I", false, "United States", true, false);
        
        Cat cat3 = new Cat("Luna", "Ragdoll", "female", "2", "10.1", "03/15/2021", 
                      "Canada", "in service", true, "Canada", true, false);
                      
        Cat cat4 = new Cat("Shadow", "Unknown", "male", "5", "9.3", "04/18/2020", 
                      "United States", "in service", false, "United States", true, true);

        animalManager.addAnimal(cat1);
        animalManager.addAnimal(cat2);
        animalManager.addAnimal(cat3);
        animalManager.addAnimal(cat4);
    }
    
    // Initialize birds
    private void initializeBirds() {
        Bird bird1 = new Bird("Polly", "African Grey", "female", "5", "1.2", "04/10/2019", 
                         "United States", "in service", false, "United States", true, 21.5);
        
        Bird bird2 = new Bird("Blue", "Macaw", "male", "3", "2.1", "07/22/2020", 
                         "Brazil", "Phase I", false, "United States", true, 31.2);
        
        Bird bird3 = new Bird("Sunny", "Canary", "male", "1", "0.4", "02/14/2021", 
                         "United States", "in service", false, "Canada", true, 8.5);
                         
        Bird bird4 = new Bird("Feathers", "Unknown", "female", "2", "0.6", "05/30/2020", 
                         "Unknown", "intake", false, "United States", true, 10.2);

        animalManager.addAnimal(bird1);
        animalManager.addAnimal(bird2);
        animalManager.addAnimal(bird3);
        animalManager.addAnimal(bird4);
    }
}
