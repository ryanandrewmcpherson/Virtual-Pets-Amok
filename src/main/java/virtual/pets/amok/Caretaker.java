package virtual.pets.amok;

import java.util.Map;
import java.util.Map.Entry;

public class Caretaker {

	final String caretakerName;

	public Caretaker(String caretakerName) {
		this.caretakerName = caretakerName;
	}

	public VirtualPetShelter feedRealPets(VirtualPetShelter shelter) {
		for (Cage cage : shelter.getCages().values()) {
			for (Pet pet : cage.getPetsInCage().values()) {
				if (pet.isReal()) {
					RealPet realPet = (RealPet) pet;
					String favoriteFood = realPet.getFavoriteFoods().get(0);
					System.out.print(caretakerName + " is pouring " + pet.getPetName() + "'s" + favoriteFood + "!");
					System.out.println(pet.getPetName() + " is excited to eat!");
					realPet.actExcited();
					System.out.print(caretakerName + " set down " + pet.getPetName() + "'s " + favoriteFood + "!");
					realPet.eat(favoriteFood);
				}
			}
		}
		return shelter;

	}

	public VirtualPetShelter waterPets(VirtualPetShelter shelter) {
		for (Cage cage : shelter.getCages().values()) {

			for (Pet pet : cage.getPetsInCage().values()) {
				if (pet.isReal()) {
					((RealPet) pet).drink();
				}
			}
		}
		return shelter;
	}

	public VirtualPetShelter checkPets(VirtualPetShelter shelter) {
		for (Entry<Integer, Cage> cageEntry : shelter.getCages().entrySet()) {
			System.out.println("\nCage" + cageEntry.getKey() + ":");
			System.out.println("Cage soil level:" + cageEntry.getValue().getSoilLevel());
			System.out.println("Pets in cage:");
			Cage cage = cageEntry.getValue();
			for (Entry<String, Pet> petEntry : cage.getPetsInCage().entrySet()) {
				System.out.printf("%-15.15s", "\n" + petEntry.getKey());
				for (Map.Entry<String, Integer> attribute : petEntry.getValue().getAttributes().entrySet()) {
					System.out.printf("%-15.18s", attribute.toString().replace("=", ":"));
				}
			}
		}
		System.out.println("\n~ Indicates applies to real pets only.");
		System.out.println("^ Indicates applies to robot pets only.");
		return shelter;
	}

	public Pet getPetOut(VirtualPetShelter shelter, String petName, int CageNumber) throws NullPointerException {
		Pet toInteractWith = shelter.getCages().get(CageNumber).getPetsInCage().get(petName);
		return toInteractWith;
	}

	public VirtualPetShelter oilRobots(VirtualPetShelter shelter) {
		for (Cage cage : shelter.getCages().values()) {
			for (Pet pet : cage.getPetsInCage().values()) {
				if (pet.isRobot()) {
					RobotPet robotPet = (RobotPet) pet;
					robotPet.setOilLevel(10);
					System.out.println(robotPet.getPetName() + " has been oiled!");
				}
			}
		}
		System.out.println("All the robot pets have been oiled!");
		return shelter;
	}

	public VirtualPetShelter rechargeRobots(VirtualPetShelter shelter) {
		for (Cage cage : shelter.getCages().values()) {
			for (Pet pet : cage.getPetsInCage().values()) {
				if (pet.isRobot()) {
					RobotPet robotPet = (RobotPet) pet;
					robotPet.setBatteryLevel(10);
					System.out.println(robotPet.getPetName() + " has been charged!");
				}
			}
		}
		System.out.println("All the robot pets have been charged!");
		return shelter;
	}

	public VirtualPetShelter walkDogs(VirtualPetShelter shelter) {
		for(Cage cage: shelter.getCages().values()){
		  if(cage.getCageType().equals("Dog Cage") && !cage.hasRoom()) {
			walkable dog = (walkable)((DogCage) cage).getWalkableInCage();
			dog.walk();
		  }
		}
		return shelter;
	}

	public VirtualPetShelter cleanAllCages(VirtualPetShelter shelter) {
		for(Cage cage: shelter.getCages().values()) {
			   cage.setSoilLevel(0);
		}
		return shelter;
	}

	public VirtualPetShelter cleanLitterBoxes(VirtualPetShelter shelter) {
		for(Cage cage: shelter.getCages().values()) {
			if(cage.getCageType().equals("Cat Cage")) {
				((CatCage) cage).setLitterBoxLevel(0);
			}
		}
		return shelter;
	}
	public VirtualPetShelter updatePetsHealth(VirtualPetShelter shelter) {
		for(Cage cage: shelter.getCages().values()) {
			for(Pet pet: cage.getPetsInCage().values())
			{
			 pet.updateHealth(cage.getSoilLevel());
			}
			
		}
		return shelter;
	}

}
