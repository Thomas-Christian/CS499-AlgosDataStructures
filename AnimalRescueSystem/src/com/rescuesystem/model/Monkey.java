package com.rescuesystem.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Monkey class representing rescue monkeys
 */
public class Monkey extends RescueAnimal {
    
	// Instance variables
    private String tailLength;
    private String height;
    private String bodyLength;
    private String monkeySpecies;
    
    // Using a HashSet for O(1) lookups instead of a List for species validation
    private static final Set<String> SPECIES = new HashSet<>(Arrays.asList(
        "Unknown",
        "Capuchin",
        "Guenon",
        "Macaque",
        "Marmoset",
        "Squirrel monkey",
        "Tamarin" 
    ));
    
    // Getters + Setters
    public String getTailLength() {
        return tailLength;
    }
    
    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }
    
    public String getHeight() {
        return height;
    }
    
    public void setHeight(String height) {
        this.height = height;
    }
    
    public String getBodyLength() {
        return bodyLength;
    }
    
    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }
    
    public void setSpecies(String userSpecies) {
        this.monkeySpecies = userSpecies;
    }
    
    public String getSpecies() {
        return this.monkeySpecies;
    }
    
    // Efficient O(1) species validation using HashSet
    public static boolean isValidSpecies(String species) {
        return SPECIES.contains(species) || "Unknown".equalsIgnoreCase(species);
    }
    
    public static List<String> returnSpecies() {
        return Arrays.asList(SPECIES.toArray(new String[0]));
    }
    
    // Additional search method for physical characteristics
    public boolean matchesPhysicalCriteria(double minHeight, double maxHeight, 
                                           double minTailLength, double maxTailLength) {
        try {
            double heightVal = Double.parseDouble(height);
            double tailVal = Double.parseDouble(tailLength);
            
            return (heightVal >= minHeight && heightVal <= maxHeight &&
                    tailVal >= minTailLength && tailVal <= maxTailLength);
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // Constructor
    public Monkey(String name, String gender, String age,
        String weight, String acquisitionDate, String acquisitionCountry,
        String trainingStatus, boolean reserved, String inServiceCountry,
        String tailLength, String height, String bodyLength, String userSpecies) {
        
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(userSpecies);
        setAnimalType("Monkey");
    }
    
    // toString method
    @Override
    public String toString() {
        return super.toString() + 
               ", Species: " + monkeySpecies + 
               ", Height: " + height + 
               ", Tail Length: " + tailLength;
    }
}
