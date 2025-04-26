package com.rescuesystem.model;

import java.util.*;

/**
 * Bird class for rescue service birds
 */
public class Bird extends RescueAnimal {

    // Instance variables
    private String species;
    private boolean canFly;
    private double wingspan;
    private boolean talkingCapable;
    
    // List of species
    private static final Set<String> VALID_SPECIES = new HashSet<>(Arrays.asList(
        "Unknown", "Parrot", "Cockatoo", "Macaw", "Cockatiel", 
        "African Grey", "Parakeet", "Canary", "Finch", "Lovebird",
        "Budgerigar", "Conure", "Dove", "Amazon", "Eclectus", "Pionus"
    ));
    
    // Species known for talking ability
    private static final Set<String> TALKING_SPECIES = new HashSet<>(Arrays.asList(
        "Parrot", "Cockatoo", "Macaw", "African Grey", "Amazon", "Eclectus"
    ));

    // Constructor
    public Bird(String name, String species, String gender, String age,
                String weight, String acquisitionDate, String acquisitionCountry,
                String trainingStatus, boolean reserved, String inServiceCountry,
                boolean canFly, double wingspan) {
        
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setCanFly(canFly);
        setWingspan(wingspan);
        
        // Automatically set talking capability based on species
        setTalkingCapable(TALKING_SPECIES.contains(species));
        
        setAnimalType("Bird");
    }

    // Accessor Methods
    public String getSpecies() {
        return species;
    }
    
    public boolean canFly() {
        return canFly;
    }
    
    public double getWingspan() {
        return wingspan;
    }
    
    public boolean isTalkingCapable() {
        return talkingCapable;
    }

    // Mutator Methods
    public void setSpecies(String species) {
        this.species = species;
    }
    
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
    
    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }
    
    public void setTalkingCapable(boolean talkingCapable) {
        this.talkingCapable = talkingCapable;
    }
    
    // Validate species
    public static boolean isValidSpecies(String species) {
        return VALID_SPECIES.contains(species) || "Unknown".equalsIgnoreCase(species);
    }
    
    // Get all valid species
    public static List<String> getValidSpecies() {
        return new ArrayList<>(VALID_SPECIES);
    }
    
    // Get species suitable for therapy
    public static List<String> getTherapySpecies() {
        return Arrays.asList("Parrot", "Cockatiel", "Canary", "Finch", "Lovebird", "Budgerigar");
    }
    
    // Get species suitable for service work
    public static List<String> getServiceSpecies() {
        return Arrays.asList("African Grey", "Macaw", "Cockatoo", "Amazon");
    }
    
    // Match bird to criteria
    @Override
    public boolean matchesCriteria(String criteria, String value) {
        // First check base criteria
        if (super.matchesCriteria(criteria, value)) {
            return true;
        }
        
        // Then check bird-specific criteria
        switch (criteria) {
            case "species": return species.equalsIgnoreCase(value);
            case "canFly": return canFly == Boolean.parseBoolean(value);
            case "talkingCapable": return talkingCapable == Boolean.parseBoolean(value);
            case "wingspan": 
                try {
                    double requestedWingspan = Double.parseDouble(value);
                    return wingspan >= requestedWingspan;
                } catch (NumberFormatException e) {
                    return false;
                }
            default: return false;
        }
    }
    
    // toString method
    @Override
    public String toString() {
        return super.toString() + 
               ", Species: " + species + 
               ", Can Fly: " + (canFly ? "Yes" : "No") +
               ", Wingspan: " + wingspan + " inches" +
               ", Talking Capable: " + (talkingCapable ? "Yes" : "No");
    }
}
