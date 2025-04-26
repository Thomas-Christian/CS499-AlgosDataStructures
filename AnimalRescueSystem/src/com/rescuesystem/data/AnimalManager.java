package com.rescuesystem.data;

import java.util.*;

import com.rescuesystem.model.Bird;
import com.rescuesystem.model.Cat;
import com.rescuesystem.model.Dog;
import com.rescuesystem.model.Monkey;
import com.rescuesystem.model.RescueAnimal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Animal Manager - New class for managing animal collections using efficient data structures
 * Implements advanced search algorithms and indexing for O(1) lookups
 */
public class AnimalManager {
    // Primary collection - HashMap for O(1) lookup by name
    private Map<String, RescueAnimal> animalsByName;
    
    // Indexed collections for efficient filtering
    private Map<String, List<RescueAnimal>> animalsByType;
    private Map<String, List<RescueAnimal>> animalsByCountry;
    private Map<String, List<RescueAnimal>> animalsByTrainingStatus;
    
    // New type-specific indexes
    private Map<String, List<RescueAnimal>> dogsByBreed;
    private Map<String, List<RescueAnimal>> catsByBreed;
    private Map<String, List<RescueAnimal>> monkeysBySpecies;
    private Map<String, List<RescueAnimal>> birdsBySpecies;
    
    // Standard date format
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    
    // Constructor
    public AnimalManager() {
        animalsByName = new HashMap<>();
        animalsByType = new HashMap<>();
        animalsByCountry = new HashMap<>();
        animalsByTrainingStatus = new HashMap<>();
        
        // Initialize type-specific indexes
        dogsByBreed = new HashMap<>();
        catsByBreed = new HashMap<>();
        monkeysBySpecies = new HashMap<>();
        birdsBySpecies = new HashMap<>();
    }
    
    /**
     * Add an animal to all collections and indexes
     * O(1) operation for adding to maps
     */
    public void addAnimal(RescueAnimal animal) {
        // Add to primary collection
        animalsByName.put(animal.getName().toLowerCase(), animal);
        
        // Add to type index
        String type = animal.getAnimalType();
        if (!animalsByType.containsKey(type)) {
            animalsByType.put(type, new ArrayList<>());
        }
        animalsByType.get(type).add(animal);
        
        // Add to country index
        String country = animal.getInServiceLocation();
        if (!animalsByCountry.containsKey(country)) {
            animalsByCountry.put(country, new ArrayList<>());
        }
        animalsByCountry.get(country).add(animal);
        
        // Add to training status index
        String status = animal.getTrainingStatus();
        if (!animalsByTrainingStatus.containsKey(status)) {
            animalsByTrainingStatus.put(status, new ArrayList<>());
        }
        animalsByTrainingStatus.get(status).add(animal);
        
        // Add to type-specific indexes
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            String breed = dog.getBreed();
            
            if (!dogsByBreed.containsKey(breed)) {
                dogsByBreed.put(breed, new ArrayList<>());
            }
            dogsByBreed.get(breed).add(animal);
        } 
        else if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            String breed = cat.getBreed();
            
            if (!catsByBreed.containsKey(breed)) {
                catsByBreed.put(breed, new ArrayList<>());
            }
            catsByBreed.get(breed).add(animal);
        }
        else if (animal instanceof Monkey) {
            Monkey monkey = (Monkey) animal;
            String species = monkey.getSpecies();
            
            if (!monkeysBySpecies.containsKey(species)) {
                monkeysBySpecies.put(species, new ArrayList<>());
            }
            monkeysBySpecies.get(species).add(animal);
        }
        else if (animal instanceof Bird) {
            Bird bird = (Bird) animal;
            String species = bird.getSpecies();
            
            if (!birdsBySpecies.containsKey(species)) {
                birdsBySpecies.put(species, new ArrayList<>());
            }
            birdsBySpecies.get(species).add(animal);
        }
    }
    
    /**
     * Get animal by name - O(1) operation
     */
    public RescueAnimal getAnimal(String name) {
        return animalsByName.get(name.toLowerCase());
    }
    
    /**
     * Get all animals of a specific type - O(1) operation
     */
    public List<RescueAnimal> getAnimalsByType(String type) {
        return animalsByType.getOrDefault(type, new ArrayList<>());
    }
    
    /**
     * Get all animals in a specific country - O(1) operation
     */
    public List<RescueAnimal> getAnimalsByCountry(String country) {
        return animalsByCountry.getOrDefault(country, new ArrayList<>());
    }
    
    /**
     * Get all animals with a specific training status - O(1) operation
     */
    public List<RescueAnimal> getAnimalsByStatus(String status) {
        return animalsByTrainingStatus.getOrDefault(status, new ArrayList<>());
    }
    
    /**
     * Get all available animals (in service but not reserved)
     * O(n) operation but uses indexed collection for better performance
     */
    public List<RescueAnimal> getAvailableAnimals() {
        List<RescueAnimal> result = new ArrayList<>();
        List<RescueAnimal> inServiceAnimals = animalsByTrainingStatus.getOrDefault("in service", new ArrayList<>());
        
        for (RescueAnimal animal : inServiceAnimals) {
            if (!animal.getReserved()) {
                result.add(animal);
            }
        }
        
        return result;
    }
    
    /**
     * Get dogs by breed
     */
    public List<RescueAnimal> getDogsByBreed(String breed) {
        return dogsByBreed.getOrDefault(breed, new ArrayList<>());
    }
    
    /**
     * Get cats by breed
     */
    public List<RescueAnimal> getCatsByBreed(String breed) {
        return catsByBreed.getOrDefault(breed, new ArrayList<>());
    }
    
    /**
     * Get monkeys by species
     */
    public List<RescueAnimal> getMonkeysBySpecies(String species) {
        return monkeysBySpecies.getOrDefault(species, new ArrayList<>());
    }
    
    /**
     * Get birds by species
     */
    public List<RescueAnimal> getBirdsBySpecies(String species) {
        return birdsBySpecies.getOrDefault(species, new ArrayList<>());
    }
    
    /**
     * Get all therapy animals across all suitable types
     */
    public List<RescueAnimal> getTherapyAnimals() {
        List<RescueAnimal> result = new ArrayList<>();
        
        // Get therapy dogs
        for (RescueAnimal animal : animalsByType.getOrDefault("Dog", new ArrayList<>())) {
            if (animal instanceof Dog && ((Dog) animal).isTherapyBreed()) {
                result.add(animal);
            }
        }
        
        // Get therapy cats
        for (RescueAnimal animal : animalsByType.getOrDefault("Cat", new ArrayList<>())) {
            if (animal instanceof Cat && ((Cat) animal).isTherapyCandidate()) {
                result.add(animal);
            }
        }
        
        // Get therapy birds
        List<String> therapySpecies = Bird.getTherapySpecies();
        for (String species : therapySpecies) {
            result.addAll(birdsBySpecies.getOrDefault(species, new ArrayList<>()));
        }
        
        return result;
    }
    
    /**
     * Reserve an animal by name and country
     * O(1) operation for lookup
     */
    public boolean reserveAnimal(String name, String country) {
        RescueAnimal animal = animalsByName.get(name.toLowerCase());
        
        if (animal != null && 
            animal.getInServiceLocation().equalsIgnoreCase(country) && 
            !animal.getReserved()) {
            
            animal.setReserved(true);
            return true;
        }
        
        return false;
    }
    
    /**
     * Update animal training status
     * O(1) for lookup, requires reindexing
     */
    public boolean updateTrainingStatus(String name, String newStatus) {
        RescueAnimal animal = animalsByName.get(name.toLowerCase());
        
        if (animal != null) {
            String oldStatus = animal.getTrainingStatus();
            
            // Update status
            animal.setTrainingStatus(newStatus);
            
            // Update training status index
            if (animalsByTrainingStatus.containsKey(oldStatus)) {
                animalsByTrainingStatus.get(oldStatus).remove(animal);
            }
            
            if (!animalsByTrainingStatus.containsKey(newStatus)) {
                animalsByTrainingStatus.put(newStatus, new ArrayList<>());
            }
            animalsByTrainingStatus.get(newStatus).add(animal);
            
            return true;
        }
        
        return false;
    }
    
    /**
     * Find animals acquired in a specific date range
     * Uses binary search for O(log n) operations if animals are sorted
     */
    public List<RescueAnimal> findAnimalsByDateRange(String startDateStr, String endDateStr) {
        try {
            LocalDate startDate = LocalDate.parse(startDateStr, DATE_FORMAT);
            LocalDate endDate = LocalDate.parse(endDateStr, DATE_FORMAT);
            
            List<RescueAnimal> allAnimals = new ArrayList<>(animalsByName.values());
            Collections.sort(allAnimals); // Sort by acquisition date
            
            List<RescueAnimal> result = new ArrayList<>();
            
            // Binary search for start index
            int startIdx = Collections.binarySearch(allAnimals, new RescueAnimal() {
                { setAcquisitionDate(startDateStr); }
            });
            
            if (startIdx < 0) {
                startIdx = -startIdx - 1;
            }
            
            // Linear scan from start index (more practical than second binary search)
            for (int i = startIdx; i < allAnimals.size(); i++) {
                RescueAnimal animal = allAnimals.get(i);
                try {
                    LocalDate animalDate = LocalDate.parse(animal.getAcquisitionDate(), DATE_FORMAT);
                    
                    if (animalDate.isAfter(endDate)) {
                        break;
                    }
                    
                    if (!animalDate.isBefore(startDate) && !animalDate.isAfter(endDate)) {
                        result.add(animal);
                    }
                } catch (Exception e) {
                    // Skip this animal if date parsing fails
                }
            }
            
            return result;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    
    /**
     * Find animals using fuzzy name search
     * Uses Levenshtein distance algorithm
     */
    public List<RescueAnimal> fuzzyNameSearch(String nameFragment) {
        List<RescueAnimal> result = new ArrayList<>();
        
        for (RescueAnimal animal : animalsByName.values()) {
            if (calculateLevenshteinDistance(animal.getName().toLowerCase(), nameFragment.toLowerCase()) <= 2) {
                result.add(animal);
            }
        }
        
        return result;
    }
    
    /**
     * Calculate Levenshtein distance for fuzzy name matching
     */
    private int calculateLevenshteinDistance(String s1, String s2) {
        int[][] distance = new int[s1.length() + 1][s2.length() + 1];
        
        for (int i = 0; i <= s1.length(); i++) {
            distance[i][0] = i;
        }
        
        for (int j = 0; j <= s2.length(); j++) {
            distance[0][j] = j;
        }
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                distance[i][j] = Math.min(
                    Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1),
                    distance[i - 1][j - 1] + cost
                );
            }
        }
        
        return distance[s1.length()][s2.length()];
    }
    
    /**
     * Find animals using multi-criteria search
     */
    public List<RescueAnimal> multiCriteriaSearch(Map<String, String> criteria) {
        List<RescueAnimal> candidates;
        
        // Start with most restrictive index if applicable
        if (criteria.containsKey("type") && animalsByType.containsKey(criteria.get("type"))) {
            candidates = new ArrayList<>(animalsByType.get(criteria.get("type")));
        } else if (criteria.containsKey("trainingStatus") && 
                   animalsByTrainingStatus.containsKey(criteria.get("trainingStatus"))) {
            candidates = new ArrayList<>(animalsByTrainingStatus.get(criteria.get("trainingStatus")));
        } else if (criteria.containsKey("inServiceCountry") && 
                   animalsByCountry.containsKey(criteria.get("inServiceCountry"))) {
            candidates = new ArrayList<>(animalsByCountry.get(criteria.get("inServiceCountry")));
        } else {
            candidates = new ArrayList<>(animalsByName.values());
        }
        
        // Apply remaining filters
        Iterator<RescueAnimal> iterator = candidates.iterator();
        while (iterator.hasNext()) {
            RescueAnimal animal = iterator.next();
            boolean matches = true;
            
            for (Map.Entry<String, String> criterion : criteria.entrySet()) {
                if (!animal.matchesCriteria(criterion.getKey(), criterion.getValue())) {
                    matches = false;
                    break;
                }
            }
            
            if (!matches) {
                iterator.remove();
            }
        }
        
        return candidates;
    }
    
    /**
     * Get all animals (for debugging or reporting)
     */
    public List<RescueAnimal> getAllAnimals() {
        return new ArrayList<>(animalsByName.values());
    }
    
    /**
     * Get all dog breeds in the system
     */
    public Set<String> getAllDogBreeds() {
        return dogsByBreed.keySet();
    }
    
    /**
     * Get all cat breeds in the system
     */
    public Set<String> getAllCatBreeds() {
        return catsByBreed.keySet();
    }
    
    /**
     * Get all monkey species in the system
     */
    public Set<String> getAllMonkeySpecies() {
        return monkeysBySpecies.keySet();
    }
    
    /**
     * Get all bird species in the system
     */
    public Set<String> getAllBirdSpecies() {
        return birdsBySpecies.keySet();
    }
    
    /**
     * Find animals that share characteristics (same breed for dogs/cats, same species for monkeys/birds)
     */
    public List<RescueAnimal> findSimilarAnimals(RescueAnimal animal) {
        List<RescueAnimal> result = new ArrayList<>();
        
        if (animal instanceof Dog) {
            String breed = ((Dog) animal).getBreed();
            for (RescueAnimal otherAnimal : dogsByBreed.getOrDefault(breed, new ArrayList<>())) {
                if (!otherAnimal.equals(animal)) {
                    result.add(otherAnimal);
                }
            }
        } 
        else if (animal instanceof Cat) {
            String breed = ((Cat) animal).getBreed();
            for (RescueAnimal otherAnimal : catsByBreed.getOrDefault(breed, new ArrayList<>())) {
                if (!otherAnimal.equals(animal)) {
                    result.add(otherAnimal);
                }
            }
        }
        else if (animal instanceof Monkey) {
            String species = ((Monkey) animal).getSpecies();
            for (RescueAnimal otherAnimal : monkeysBySpecies.getOrDefault(species, new ArrayList<>())) {
                if (!otherAnimal.equals(animal)) {
                    result.add(otherAnimal);
                }
            }
        }
        else if (animal instanceof Bird) {
            String species = ((Bird) animal).getSpecies();
            for (RescueAnimal otherAnimal : birdsBySpecies.getOrDefault(species, new ArrayList<>())) {
                if (!otherAnimal.equals(animal)) {
                    result.add(otherAnimal);
                }
            }
        }
        
        return result;
    }
}