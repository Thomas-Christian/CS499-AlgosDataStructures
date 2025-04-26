
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    // Instance variables (if needed)
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    private static boolean isRunning = true;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        initializeDogList();
        initializeMonkeyList();

        String userInput = null;

        // LOOP
        while (isRunning) {

            displayMenu();
            userInput = scanner.nextLine();
            // CHECK TO SEE IF USER INPUT IS VALID

            switch (userInput) {
                case "1":
                    intakeNewDog(scanner);
                    break;

                case "2":
                    intakeNewMonkey(scanner);
                    break;

                case "3":
                    reserveAnimal(scanner);
                    break;

                case "4":

                case "5":

                case "6":
                    printAnimals(scanner, userInput);
                    break;

                case "q":
                    System.out.println("Goodbye");
                    isRunning = false;
                    break;

                default:
                    System.out.println("That's not a valid option!");

                    break;
            }

        }

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
        // For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods
        // Hint: Menu options 4, 5, and 6 should all connect to the printAnimals()
        // method.

    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake",
                false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false,
                "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true,
                "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Adds monkeys to a list for testing
    // Optional for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Meep", "male", "1", "15.2", "05-12-2019", "United States", "in service", false,
                "United States", "12.1", "18.2", "17.0", "Tamarin");

        monkeyList.add(monkey1);
    }

    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {

        String printLineQuestion = ("What is the dog's name?");
        String name = "";
        // PASS 0 FOR STRING
        name = intakeLoop(printLineQuestion, name, 0, scanner);
        
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; // returns to menu
            }
        }

        printLineQuestion = ("What is the dog's breed?");
        String breed = "";
        breed = intakeLoop(printLineQuestion, name, 0, scanner);

        printLineQuestion = ("What is the dog's gender?");
        String gender = "";
        gender = intakeLoop(printLineQuestion, gender, 0, scanner);

        printLineQuestion = ("What is the dog's age?");
        String age = "";
        age = intakeLoop(printLineQuestion, age, 1, scanner);

        printLineQuestion = ("What is the dog's weight?");
        String weight = "";
        weight = intakeLoop(printLineQuestion, weight, 1, scanner);

        printLineQuestion = ("When was the dog aquired? Please enter: (MM/DD/YYYY)");
        String acquisitionDate = "";
        // SPECIAL CASE DATE PASS 2
        acquisitionDate = intakeLoop(printLineQuestion, acquisitionDate, 2, scanner);

        printLineQuestion = ("Where was the dog aquired?");
        String acquisitionLocation = "";
        acquisitionLocation = intakeLoop(printLineQuestion, acquisitionLocation, 0, scanner);

        printLineQuestion = ("What is the dog's training status?");
        String trainingStatus = "";
        trainingStatus = intakeLoop(printLineQuestion, trainingStatus, 0, scanner);

        printLineQuestion = ("Is the dog reserved?");
        String isReserved = "";
        isReserved = intakeLoop(printLineQuestion, isReserved, 0, scanner);

        boolean reserved = false;

        if (isReserved != "") {
            switch (isReserved.toLowerCase()) {
                case "yes":
                    reserved = true;
                    break;
            }
        }

        printLineQuestion = ("What is the dog's service country?");
        String serviceCountry = "";
        serviceCountry = intakeLoop(printLineQuestion, serviceCountry, 0, scanner);

        // Add the code to instantiate a new dog and add it to the appropriate list
        Dog userDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionLocation, trainingStatus,
                reserved, serviceCountry);
        dogList.add(userDog);

        System.out.println("Dog added!");
    }

    // Complete intakeNewMonkey
    // Instantiate and add the new monkey to the appropriate list
    // For the project submission you must also validate the input
    // to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {

        //System.out.println("What is the monkey's name?");
        String printLineQuestion = ("What is the monkey's name?");
        String name = "";
        // PASS 0 FOR STRING
        name = intakeLoop(printLineQuestion, name, 0, scanner);

        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; // returns to menu
            }
        }

        printLineQuestion = ("What is the monkey's gender?");
        String gender = "";
        // PASS 0 FOR STRING
        gender = intakeLoop(printLineQuestion, gender, 0, scanner);

        printLineQuestion = ("What is the monkey's age?");
        String age = "";
        // PASS 1 FOR INT
        age = intakeLoop(printLineQuestion, age, 1, scanner);


        printLineQuestion = ("What is the monkey's weight?");
        String weight = "";
        // PASS 1 FOR INT
        weight = intakeLoop(printLineQuestion, weight, 1, scanner);


        printLineQuestion = ("When was the monkey aquired? Please enter: (MM/DD/YYYY)");
        String acquisitionDate = "";
        // PASS 2 FOR SPECIAL CASE INT LIKE DATE
       acquisitionDate = intakeLoop(printLineQuestion, acquisitionDate, 2, scanner);


        printLineQuestion = ("Where was the monkey aquired?");
        String acquisitionLocation = "";
        // PASS 0 FOR STRING
        acquisitionLocation = intakeLoop(printLineQuestion, acquisitionLocation, 0, scanner);


        printLineQuestion = ("What is the monkey's training status?");
        String trainingStatus = "";
        trainingStatus = intakeLoop(printLineQuestion, trainingStatus, 0, scanner);


        printLineQuestion = ("Is the monkey reserved?");
        String isReserved = "";
        isReserved = intakeLoop(printLineQuestion, isReserved, 0, scanner);

        boolean reserved = false;

        if (isReserved != "") {
            switch (isReserved.toLowerCase()) {
                case "yes":
                    reserved = true;
                    break;
            }
        }


        printLineQuestion = ("What is the monkey's service country?");
        String serviceCountry = "";
        serviceCountry = intakeLoop(printLineQuestion, serviceCountry, 0, scanner);


        printLineQuestion = ("What is the monkey's tail length?");
        String tailLength = "";
        tailLength = intakeLoop(printLineQuestion, tailLength, 1, scanner);



        printLineQuestion = ("What is the monkey's height (in inches)? ");
        String height = "";
        height = intakeLoop(printLineQuestion, height, 1, scanner);



        printLineQuestion = ("What is the monkey's body length (in inches)?");
        String bodyLength = "";
        bodyLength = intakeLoop(printLineQuestion, bodyLength, 1, scanner);



        printLineQuestion = ("What is the monkey's species?");
        String species = "";
        species = intakeLoop(printLineQuestion, species, 0, scanner);


        while (!Monkey.returnSpecies().contains(species)) {
            System.out.println("That is not an accepeted species, sorry!");
            species = intakeLoop(printLineQuestion, species, 0, scanner);
        }

        // Add the code to instantiate a new dog and add it to the appropriate list
        Monkey userMonkey = new Monkey(name, gender, age, weight, acquisitionDate, acquisitionLocation, trainingStatus,
                reserved, serviceCountry, tailLength, height, bodyLength, species);
        monkeyList.add(userMonkey);

        System.out.println("Monkey added!");
    }

    // Complete reserveAnimal
    // You will need to find the animal by animal type and in service country
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("What kind of animal are you trying to reserve?");
        String userType = scanner.next();

        switch (userType.toLowerCase()) {

            case "monkey":

                reservationListCheck(monkeyList, userType, scanner);

                break;

            case "dog":
                reservationListCheck(dogList, userType, scanner);
                break;

            default:
                System.out.println("We dont have that type of animal!");
                reserveAnimal(scanner);
                break;
        }

    }

    public static void reservationListCheck(ArrayList<?> animalTypeList, String userType, Scanner scanner) {

        ArrayList<RescueAnimal> availableAnimals = new ArrayList<RescueAnimal>();

        scanner.nextLine();

        System.out.println("What is the service country of the animal you are trying to reserve");
        String userCountry = scanner.nextLine();

        for (Object animal : animalTypeList) {
            if (((RescueAnimal) animal).getInServiceLocation().equalsIgnoreCase(userCountry)) {

                availableAnimals.add((RescueAnimal) animal);

            }
        }

        System.out.println("Available " + userType + "s: ");

        for (RescueAnimal currentAnimal : availableAnimals) {

            System.out.println(currentAnimal.getName());

        }

        System.out.println("Which " + userType + " would you like to reserve?");

        String userChoice = scanner.nextLine();

        for (RescueAnimal chosenAnimal : availableAnimals) {

            if (((RescueAnimal) chosenAnimal).getName().equalsIgnoreCase(userChoice)
                    && !((RescueAnimal) chosenAnimal).getReserved()) {

                chosenAnimal.setReserved(true);
                System.out.println(chosenAnimal.getName() + " has been " + "reserved");

                return;
            }
        }
    }

    // Complete printAnimals
    // Include the animal name, status, acquisition country and if the animal is
    // reserved.
    // Remember that this method connects to three different menu items.
    // The printAnimals() method has three different outputs
    // based on the listType parameter
    // dog - prints the list of dogs
    // monkey - prints the list of monkeys
    // available - prints a combined list of all animals that are
    // fully trained ("in service") but not reserved
    // Remember that you only have to fully implement ONE of these lists.
    // The other lists can have a print statement saying "This option needs to be
    // implemented".
    // To score "exemplary" you must correctly implement the "available" list.
    public static void printAnimals(Scanner scanner, String userChoice) {

        switch (userChoice) {

            case "4":

                for (Dog dog : dogList) {

                    System.out.println(dog.getName());
                }
                break;

            case "5":

                for (Monkey monkey : monkeyList) {

                    System.out.println(monkey.getName());
                }
                break;

            case "6":

                ArrayList<Object> allAnimals = new ArrayList<>();

                allAnimals.addAll(monkeyList);
                allAnimals.addAll(dogList);

                String acceptedTrainingLevel = "in service";
                int acceptable = 0;

                System.out.println("Unreserved Animals: ");

                for (Object chosenAnimal : allAnimals) {

                    if (((RescueAnimal) chosenAnimal).getReserved() == false && ((RescueAnimal) chosenAnimal)
                            .getTrainingStatus().equalsIgnoreCase(acceptedTrainingLevel)) {

                        System.out.println(((RescueAnimal) chosenAnimal).getName());
                        acceptable++;

                    }

                }

                if (acceptable == 0) {
                    System.out.println("Sorry no available animals at this time");
                }

                break;

        }

    }

    public static boolean isValidInput(String userInput, int numOrString) {

        switch (numOrString) {

            case 0:
                // CHECKING A STRING
                boolean hasDigit = (userInput.matches(".*\\d.*"));

                if (hasDigit) {
                    System.out.println("Please enter a valid string with no numbers!");
                    System.out.println();
                    return false;
                }

                break;

            case 1:
                 // CHECKING AN INT

                boolean hasLetters = userInput.matches("[a-zA-Z]+");
            
                //System.out.println(userInput + "   " + hasLetters);

                if (hasLetters) {

                    System.out.println("Please enter a number or a number greater than 0!");
                    return false;
                }

                break;
            
            //SPECIAL CASES LIKE DATE
            case 2:  
                hasLetters = userInput.matches("[a-zA-Z]+");
            
                if (hasLetters) {

                System.out.println("Please enter a number or a number greater than 0!");
                return false;
                }
                break;
        }

        return true;

    }

    public static String intakeLoop(String printLineQuestion, String currentItem, int numOrString, Scanner scanner) {

        System.out.println(printLineQuestion);
        currentItem = scanner.nextLine();

        while (!isValidInput(currentItem, numOrString)) {
            System.out.println(printLineQuestion);
            currentItem = scanner.nextLine();
        }

        return currentItem;

    }
}
