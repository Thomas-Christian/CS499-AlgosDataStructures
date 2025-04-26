package com.rescuesystem.model;

/**
 * Cat class for rescue cats
 */
public class Cat extends RescueAnimal {

    // Instance variables
    private String breed;
    private boolean houseTrained;
    private boolean declawed;
    
    // Constants for breeds
    public static final String[] CAT_BREEDS = {
        "Unknown", "Ragdoll", "Maine Coon", "Persian", "Birman",
        "Scottish Fold", "Siamese", "British Shorthair", "Bengal",
        "Sphynx", "American Shorthair", "Exotic Shorthair", "Devon Rex",
        "Abyssinian", "Oriental", "Russian Blue", "Norwegian Forest Cat",
        "Domestic Shorthair", "Domestic Longhair", "Himalayan"
    };
    
    private static final String[] THERAPY_BREEDS = {
        "Ragdoll", "Maine Coon", "Persian", "Birman",
        "Scottish Fold", "Siamese", "British Shorthair"
    };

    // Constructor
    public Cat(String name, String breed, String gender, String age,
            String weight, String acquisitionDate, String acquisitionCountry,
            String trainingStatus, boolean reserved, String inServiceCountry,
            boolean houseTrained, boolean declawed) {
        
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
        setHouseTrained(houseTrained);
        setDeclawed(declawed);
        setAnimalType("Cat");
    }

    // Accessor Methods
    public String getBreed() {
        return breed;
    }

    public boolean isHouseTrained() {
        return houseTrained;
    }
    
    public boolean isDeclawed() {
        return declawed;
    }

    // Mutator Methods
    public void setBreed(String catBreed) {
        breed = catBreed;
    }
    
    public void setHouseTrained(boolean houseTrained) {
        this.houseTrained = houseTrained;
    }
    
    public void setDeclawed(boolean declawed) {
        this.declawed = declawed;
    }
    
    // Check if the cat is suitable for therapy
    public boolean isTherapyCandidate() {
        for (String therapyBreed : THERAPY_BREEDS) {
            if (therapyBreed.equalsIgnoreCase(breed)) {
                return true;
            }
        }
        return false;
    }
    
    // Get all available cat breeds
    public static String[] getBreeds() {
        return CAT_BREEDS;
    }
    
    // Check if a breed is valid
    public static boolean isValidBreed(String breed) {
        for (String validBreed : CAT_BREEDS) {
            if (validBreed.equalsIgnoreCase(breed)) {
                return true;
            }
        }
        return true; // Accept any breed, even if not in predefined list
    }
    
    // Match cat to criteria
    @Override
    public boolean matchesCriteria(String criteria, String value) {
        // First check base criteria
        if (super.matchesCriteria(criteria, value)) {
            return true;
        }
        
        // Then check cat-specific criteria
        switch (criteria) {
            case "breed": return breed.equalsIgnoreCase(value);
            case "houseTrained": return houseTrained == Boolean.parseBoolean(value);
            case "declawed": return declawed == Boolean.parseBoolean(value);
            default: return false;
        }
    }
    
    // toString method
    @Override
    public String toString() {
        return super.toString() + 
               ", Breed: " + breed + 
               ", House Trained: " + (houseTrained ? "Yes" : "No") +
               ", Declawed: " + (declawed ? "Yes" : "No");
    }
}
