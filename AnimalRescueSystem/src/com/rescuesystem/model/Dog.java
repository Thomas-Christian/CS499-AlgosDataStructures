package com.rescuesystem.model;

/**
 * Dog class representing rescue dogs
 */
public class Dog extends RescueAnimal {

    // Instance variable
    private String breed;
    
    // Constants for breeds
    public static final String[] DOG_BREEDS = {
        "Unknown", "German Shepherd", "Labrador Retriever", "Golden Retriever", 
        "Border Collie", "Belgian Malinois", "Poodle", "Cavalier King Charles Spaniel", 
        "Great Dane", "Saint Bernard", "Newfoundland", "Chihuahua", "Beagle", 
        "Bulldog", "Boxer", "Dachshund", "Siberian Husky", "Shih Tzu",
        "Yorkshire Terrier", "Doberman Pinscher"
    };
    
    private static final String[] SERVICE_BREEDS = {
        "German Shepherd", "Labrador Retriever", "Golden Retriever", 
        "Border Collie", "Belgian Malinois"
    };
    
    private static final String[] THERAPY_BREEDS = {
        "Poodle", "Cavalier King Charles Spaniel", "Great Dane",
        "Saint Bernard", "Newfoundland"
    };

    // Constructor
    public Dog(String name, String breed, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
    String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setBreed(breed);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setAnimalType("Dog");
    }

    // Accessor Method
    public String getBreed() {
        return breed;
    }

    // Mutator Method
    public void setBreed(String dogBreed) {
        breed = dogBreed;
    }
    
    // Check if the dog is a service breed
    public boolean isServiceBreed() {
        for (String serviceBreed : SERVICE_BREEDS) {
            if (serviceBreed.equalsIgnoreCase(breed)) {
                return true;
            }
        }
        return false;
    }
    
    // Check if the dog is a therapy breed
    public boolean isTherapyBreed() {
        for (String therapyBreed : THERAPY_BREEDS) {
            if (therapyBreed.equalsIgnoreCase(breed)) {
                return true;
            }
        }
        return false;
    }
    
    // Additional search method for breed matching
    public boolean matchesBreed(String breedQuery) {
        return breed.toLowerCase().contains(breedQuery.toLowerCase());
    }
    
    // Get all available dog breeds
    public static String[] getBreeds() {
        return DOG_BREEDS;
    }
    
    // Check if a breed is valid
    public static boolean isValidBreed(String breed) {
        for (String validBreed : DOG_BREEDS) {
            if (validBreed.equalsIgnoreCase(breed)) {
                return true;
            }
        }
        return true; // Accept any breed, even if not in our predefined list
    }
    
    // toString method including breed
    @Override
    public String toString() {
        return super.toString() + ", Breed: " + breed;
    }
}
