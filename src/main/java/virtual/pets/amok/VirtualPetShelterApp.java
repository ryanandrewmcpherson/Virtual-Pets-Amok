package virtual.pets.amok;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelterApp {

	private static Scanner input = new Scanner(System.in);
	private static Owner user;
	private static String userName;
	private static String careTakerName;
	private static Caretaker careTaker;
	private static VirtualPetShelter shelter = new VirtualPetShelter();
	private static long lastTime;

	public static void main(String[] args) {

		welcomeMessage();
		initializeOwner();
		initializeCaretaker();
		menuLoop();
	}

	private static void welcomeMessage() {
		System.out.println("Welcome to Virtual Pet Shelter!");
		System.out.println("This app will simulate running a virtual pet shelter!");
		System.out.println("If you wish to quit just type quit at any time!");
	}

	private static void initializeCaretaker() {
		System.out.println("\n" + userName + ", what is the caretakers name?");
		careTakerName = quitFilter(input.nextLine());
		careTakerName = titleCase(careTakerName);
		careTaker = new Caretaker(careTakerName);
	}

	private static void initializeOwner() {
		System.out.println("Please enter your name:");
		userName = quitFilter(input.nextLine());
		userName = titleCase(userName);
		user = new Owner(userName);
	}

	private static void menuLoop() {

		do {
			if (shelter.getNumPets() == 0) {
				admitPetLoop();
				initializeLastTimeForTick();
			}

			switch (printMenu()) {
			case "1": {
				shelter = careTaker.feedRealPets(shelter);
				break;
			}
			case "2": {
				shelter = careTaker.waterPets(shelter);
				break;
			}
			case "3": {
				shelter = careTaker.oilRobots(shelter);
				break;
			}
			case "4": {
				shelter = careTaker.rechargeRobots(shelter);
				break;
			}
			case "5": {
				shelter = careTaker.walkDogs(shelter);
				break;

			}
			case "6": {
				shelter = careTaker.cleanAllCages(shelter);
				break;
			}
			case "7": {
				shelter = careTaker.cleanLitterBoxes(shelter);
				break;
			}
			case "8": {
				int cageNumber = cageNumber();
				System.out.println(user.getName() + ", please enter the name of the pet you would like to get out!");
				String petName = quitFilter(input.nextLine());
				petName = titleCase(petName);
				try {
					petInteractionLoop(careTaker.getPetOut(shelter, petName, cageNumber));
				} catch (Exception NullPointerException) {
					System.out.println("Pet Not Found!");
					System.out.println("Pets available to interact with:");
					shelter.listPets();
				}
				break;
			}
			case "9": {
				int size = shelter.getNumPets();
				while (size == shelter.getNumPets()) {
					System.out.print("What kind of pet do you have?");
					String petToAdmit = lowerCaseRemoveSpacesInput();
				
					admitPetSwitch(petToAdmit);
				}
				break;
			}
			case "10": {
				int size = shelter.getNumPets();
				while (size == shelter.getNumPets()) {
					int cageNumber = cageNumber();
					System.out.print("Which pet would you like to adopt?");
					String petToAdopt = quitFilter(input.nextLine());
					petToAdopt = titleCase(petToAdopt);
					try {
						shelter.adoptPet(careTaker.getPetOut(shelter, petToAdopt, cageNumber));
					} catch (Exception NullPointerException) {
						System.out.println("Pet Not Found!");
						System.out.println("Pets available to adopt:");
						shelter.listPets();
					}
				}
				break;
			}
			default: {
				System.out.print("Invalid Selection!");
			}
			}
			tick();
		} while (true);
	}

	private static int cageNumber() {
		boolean incorrectFormat = false;
		int cageNumber = 0;
		do {
			try {
				System.out.println(user.getName() + ", please enter the number of the cage your pet is in!");
				String cageNumberEntered = quitFilter(input.nextLine());
				cageNumber = Integer.parseInt(cageNumberEntered);
			} catch (Exception NumberFormatException) {
				System.out.println("Cage number must be an integer!");
				incorrectFormat = true;
			}
		} while (incorrectFormat);
		return cageNumber;
	}

	private static void initializeLastTimeForTick() {
		System.out.printf("The current time is %tr", new Date());
		lastTime = Calendar.getInstance().getTimeInMillis();
	}

	private static String printMenu() {
		System.out.println("\n" + careTaker.caretakerName + " has checked on the pets!");
		System.out.println("This is their status:\n");
		careTaker.checkPets(shelter);
		System.out.println("\nWhat would you like to have him do next?");
		System.out.println("1. Feed All The Pets");
		System.out.println("2. Water All The Pets");
		System.out.println("3. Oil the Robots");
		System.out.println("4. Charge the Robots");
		System.out.println("5. Walk the dogs");
		System.out.println("6. Clean the cages");
		System.out.println("7. Clean the litter boxes");
		System.out.println("8. Get a pet out to interact with");
		System.out.println("9. Admit a pet");
		System.out.println("10.Process a pet for adoption");

		return input.nextLine();
	}

	private static String quitFilter(String input) {
		if (input.equalsIgnoreCase("Quit")) {
			System.exit(0);
		}
		return input;
	}

	private static void admitPetLoop() {

		boolean done;

		do {
			done = true;
			System.out.println("There are currently " + shelter.getNumPets() + " pet(s) in the shelter!");
			shelter.listPets();
			System.out.println("To admit a pet, type the pet type. Type done when finished admitting pets.");
			String petToAdmit = lowerCaseRemoveSpacesInput();
			switch (petToAdmit) {
			case "done": {
				if (shelter.getNumPets() == 0) {
					System.out.println("Please admit at least one pet! Type add to continue or quit to quit!");
					petToAdmit = lowerCaseRemoveSpacesInput();
					continue;
				}
				break;
			}
			default: {
				done = admitPetSwitch(petToAdmit);
				break;
			}
			}

		} while (!done);

		System.out.println("Press Enter to continue or type quit to quit");
		quitFilter(input.nextLine());
	}

	private static String lowerCaseRemoveSpacesInput() {
		return quitFilter(input.nextLine()).replace(" ", "").toLowerCase();
	}

	private static boolean admitPetSwitch(String petToAdmit) {

		boolean shelterFull = false;

		switch (petToAdmit) {
		case "bird": {
			shelterFull = shelter.admitPet(new Bird(namePet("bird")));
			break;
		}
		case "robotbird": {
			shelterFull = shelter.admitPet(new Bird(namePet("robot bird")));
			break;
		}
		case "cat": {
			shelterFull = shelter.admitPet(new Cat(namePet("cat")));
			break;
		}
		case "robotcat": {
			shelterFull = shelter.admitPet(new RobotCat(namePet("robot cat")));
			break;
		}
		case "dog": {
			shelterFull = shelter.admitPet(new Dog(namePet("dog")));
			break;
		}
		case "robotdog": {
			shelterFull = shelter.admitPet(new RobotDog(namePet("robot dog")));
			break;
		}
		default: {

		}
		}
		return shelterFull;
	}

	private static String namePet(String petType) {
		System.out.print("Please name the " + petType + "!");
		System.out.println(titleCase(petType) + "'s name:");
		String petName = quitFilter(input.nextLine());
		petName = titleCase(petName);
		return petName;
	}

	private static VirtualPetShelter petInteractionLoop(Pet pet) {
		boolean interact = true;
		do {
			System.out.println(user.getName() + ", this is " + pet.getPetName() + "'s status:");
			System.out.printf("%-15.15s", "\n" + pet.getPetName());
			for (Map.Entry<String, Integer> attribute : pet.getAttributes().entrySet()) {
				System.out.printf("%-15.18s", attribute.toString().replace("=", ":"));
			}
			System.out.println("\nWhat would you like to do " + user.getName() + " ?");
			if (pet.isReal()) {
				System.out.println("1. Feed " + pet.getPetName());
				System.out.println("2. Water " + pet.getPetName());
			} else if (pet.isRobot()) {
				System.out.println("1. Oil " + pet.getPetName());
				System.out.println("2. Charge " + pet.getPetName());
			}
			System.out.println("3. Play with " + pet.getPetName());
			System.out.println("4. Return to main menu ");
			String menuOption = quitFilter(input.nextLine());

			switch (menuOption) {
			case "1": {
				if (pet.isRobot()) {
					user.oilRobot((RobotPet) pet);
					break;
				} else if (pet.isReal()) {
					System.out.println("What would you like to feed " + pet.getPetName() + "?");
					user.feedRealPet((RealPet) pet, quitFilter(input.nextLine()));
					break;
				}

			}
			case "2": {
				if (pet.isRobot()) {
					user.chargeRobot((RobotPet) pet);
					break;
				} else if (pet.isReal()) {
					user.waterRealPet((RealPet) pet);
					break;
				}
			}
			case "3": {
				user.playWith(pet);
				break;
			}
			case "4": {
				interact = false;
			}
			default: {
				System.out.println("Invalid selection!");
				break;
			}

			}
			tick();
		} while (interact);

		return shelter;
	}

	private static String titleCase(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
	}

	private static VirtualPetShelter tick() {
		System.out.printf("The current time is %tr", new Date());
		long time = Calendar.getInstance().getTimeInMillis();
		int incrementAmount = (int) (time - lastTime) / 5000;
		for (Cage cage : shelter.getCages().values()) {
			for (Pet pet : cage.getPetsInCage().values()) {
				for (Map.Entry<String, Integer> attributeEntry : pet.getAttributes().entrySet()) {
					String attributeName = attributeEntry.getKey();
					int attributeValue = attributeEntry.getValue();
					if (attributeName.equals("^Oil Level") || attributeName.equals("^Battery Level")
							|| attributeName.equals("Happiness")) {
						if (attributeValue - incrementAmount >= 0) {
							attributeValue -= incrementAmount;
						}
					} else if (attributeValue + incrementAmount <= 10) {
						attributeValue += incrementAmount;
					}
				}
			}
		}
		careTaker.updatePetsHealth(shelter);
		lastTime = time;
		return shelter;

	}

}
