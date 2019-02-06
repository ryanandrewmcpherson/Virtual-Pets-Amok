package virtual.pets.amok;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class VirtualPetShelter {

	private Map<Integer, Cage> cages = new TreeMap<Integer, Cage>();
	private static int cageNumber = 1;
	private boolean isFull = false;

	public int getNumPets() {
		int numPets = 0;
		for(Cage cage:cages.values()) {
			numPets+=cage.getPetsInCage().size();
		}
		return numPets;	
	}

	public boolean admitPet(Pet pet) {

		String petType = pet.getPetType();
		boolean petCaged = false;

		if (thereAreNoCagesYet()) {
			createCorrectCage(pet, petType);
			petCaged = true;
		} else if (cagesHaveRoom()) {
			for (Cage cage : cages.values()) {
				if (cage.hasRoom() && cage.accepts(pet.getType())) {
					cage.cagePet(pet);
					petCaged = true;
				}
			}

		} else if (cageLimitReached()) {
			setFull(true);
			return isFull();
		} 
		if (moreRoomForCages() && !petCaged) {
			createCorrectCage(pet,petType);
		}
		return isFull();
	}

	private boolean moreRoomForCages() {
		return !cageLimitReached();
	}

	private boolean cageLimitReached() {
		if (cages.size() == 20) {
			return true;
		}
		return false;
	}

	private boolean thereAreNoCagesYet() {
		return cages.size() == 0;
	}

	private boolean cagesHaveRoom() {
		for (Cage cage : cages.values()) {
			if (cage.hasRoom()) {
				return cage.hasRoom();
			}
		}
		return false;
	}

	private void createCorrectCage(Pet pet, String petType) {
		if (petType.contains("Dog")) {
			cages.put(cageNumber, new DogCage(cageNumber));
			cages.get(cageNumber).cagePet(pet);
		} else if (petType.contains("Cat")) {
			cages.put(cageNumber, new CatCage(cageNumber));
			cages.get(cageNumber).cagePet(pet);
		} else if (petType.contains("Bird")) {
			cages.put(cageNumber, new BirdCage(cageNumber));
			cages.get(cageNumber).cagePet(pet);
		}
		cageNumber++;
	}

	public void adoptPet(Pet pet) throws NullPointerException {
		for (Cage cage : cages.values()) {
			if (cage.hasPet(pet)) {
				cage.removePet(pet);
			}
		}
	}

	public Pet interactWithPet(String petName, int cageNumber) {
		Pet toInteractWith = getCages().get(1).getPetsInCage().get(petName);
		return toInteractWith;
	}

	public Map<String, String> listPets() {
		Map<String, String> petsListMap = new TreeMap<String, String>();
		for (Entry<Integer, Cage> cageEntry : cages.entrySet()) {
			System.out.println("Cage:" + (cageEntry.getKey()));
			Cage cage = cageEntry.getValue();
			for (Entry<String, Pet> pet : cage.getPetsInCage().entrySet()) {
				System.out.printf("%-15.15s Type:" + pet.getValue().getPetType() + "\r", pet.getKey());
				petsListMap.put(pet.getKey(), pet.getValue().getPetType());
			}
		}
		return petsListMap;
	}

	

	public Map<Integer, Cage> getCages() {
		return cages;
	}

	public void setCages(Map<Integer, Cage> cages) {
		this.cages = cages;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

}
