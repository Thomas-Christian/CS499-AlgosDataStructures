package com.rescuesystem.model;

import java.lang.String;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Base class for all rescue animals
 * Enhanced with additional fields and methods for efficient processing
 */
public class RescueAnimal implements Comparable<RescueAnimal> {

    // Instance variables
    private String name;
    private String animalType;
    private String gender;
    private String age;
    private String weight;
    private String acquisitionDate;
    private String acquisitionCountry;
    private String trainingStatus;
    private boolean reserved;
    private String inServiceCountry;
    private String uniqueId;

    // Standard date format for comparing dates
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    // Constructor
    public RescueAnimal() {
        // Generate a unique ID for each animal
        this.uniqueId = java.util.UUID.randomUUID().toString();
    }

    // Equality and hashCode methods for HashMap usage
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RescueAnimal that = (RescueAnimal) o;
        return Objects.equals(uniqueId, that.uniqueId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueId);
    }

    // Comparable implementation for sorting
    @Override
    public int compareTo(RescueAnimal other) {
        try {
            LocalDate thisDate = LocalDate.parse(this.acquisitionDate, DATE_FORMAT);
            LocalDate otherDate = LocalDate.parse(other.acquisitionDate, DATE_FORMAT);
            return thisDate.compareTo(otherDate);
        } catch (Exception e) {
            // Fall back to name comparison if date parsing fails
            return this.name.compareTo(other.name);
        }
    }

    // Check if animal matches search criteria
    public boolean matchesCriteria(String criteria, String value) {
        switch (criteria) {
            case "name": return name.toLowerCase().contains(value.toLowerCase());
            case "type": return animalType.equalsIgnoreCase(value);
            case "gender": return gender.equalsIgnoreCase(value);
            case "age": return age.equals(value);
            case "acquisitionCountry": return acquisitionCountry.equalsIgnoreCase(value);
            case "trainingStatus": return trainingStatus.equalsIgnoreCase(value);
            case "reserved": return Boolean.parseBoolean(value) == reserved;
            case "inServiceCountry": return inServiceCountry.equalsIgnoreCase(value);
            default: return false;
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getAcquisitionLocation() {
        return acquisitionCountry;
    }

    public void setAcquisitionLocation(String acquisitionCountry) {
        this.acquisitionCountry = acquisitionCountry;
    }

    public boolean getReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getInServiceLocation() {
        return inServiceCountry;
    }

    public void setInServiceCountry(String inServiceCountry) {
        this.inServiceCountry = inServiceCountry;
    }

    public String getTrainingStatus() {
        return trainingStatus;
    }

    public void setTrainingStatus(String trainingStatus) {
        this.trainingStatus = trainingStatus;
    }
    
    public String getUniqueId() {
        return uniqueId;
    }
    
    // Standard toString method to display animal information
    @Override
    public String toString() {
        return "Name: " + name + 
               ", Type: " + animalType + 
               ", Status: " + trainingStatus + 
               ", Reserved: " + (reserved ? "Yes" : "No") + 
               ", Location: " + inServiceCountry;
    }
}
