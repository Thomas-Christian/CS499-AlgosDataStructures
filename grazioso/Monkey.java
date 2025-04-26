import java.util.Arrays;
import java.util.List;

public class Monkey extends RescueAnimal {
	
	// VARIABLES
	private String tailLength;
	private String height;
	private String bodyLength;
	private String monkeySpecies;
	private static List<String> Species = Arrays.asList(
		"Capuchin",
		"Guenon",
		"Macaque",
		"Marmoset",
		"Squirrel monkey",
		"Tamarin" 
	);
	
	// GETTERS & SETTERS
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
	public static List<String> returnSpecies() {
		return Species;
	}
	
	
	// CONSTRUCTOR
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

	
}
