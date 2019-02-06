package virtual.pets.amok;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class Cage {

	private int cageNumber;
	private int cageCapacity;
	private int soilLevel;
	private boolean hasRoom = true;
	private Map<String, Pet> petsInCage = new TreeMap<String, Pet>();
	private List<String> compatiblePets = new ArrayList<String>();
	private String cageType;

	public Cage(int cageNumber) {
		setSoilLevel(0);
		setCageNumber(cageNumber);
	}

	public Pet cagePet(Pet petToCage) {
		this.getPetsInCage().put(petToCage.getPetName(), petToCage);
		return petToCage;
	}

	public int getCageNumber() {
		return cageNumber;
	}

	public void setCageNumber(int cageNumber) {
		this.cageNumber = cageNumber;
	}

	public int getCageCapacity() {
		return cageCapacity;
	}

	public void setCageCapacity(int cageCapacity) {
		this.cageCapacity = cageCapacity;
	}

	public Map<String, Pet> getPetsInCage() {
		return petsInCage;
	}

	public void setPetsInCage(Map<String, Pet> petsInCage) {
		this.petsInCage = petsInCage;
	}

	public boolean hasRoom() {
		if (petsInCage.size() < cageCapacity) {
			return hasRoom;
		} else {
			hasRoom = false;
			return hasRoom;
		}
	}

	public int getSoilLevel() {
		for (Pet pet : getPetsInCage().values()) {
			if (pet.isReal()) {
				if (((RealPet) pet).isPoopInCage()) {
					if (soilLevel + ((RealPet) pet).getPoopSize() >= 10) {
						soilLevel = 10;
					} else {
						soilLevel += ((RealPet) pet).getPoopSize();
					}
				}
				if (((RealPet) pet).isPeeInCage()) {
					if (soilLevel + ((RealPet) pet).getPeeAmount() >= 10) {
						soilLevel = 10;
					} else {
						soilLevel += ((RealPet) pet).getPeeAmount();
					}
				}

			}
		}
		return soilLevel;

	}

	public void setSoilLevel(int soilLevel) {
		this.soilLevel = soilLevel;
	}

	public String getCageType() {
		return cageType;
	}

	public void setCageType(String cageType) {
		this.cageType = cageType;
	}

	public List<String> getCompatiblePets() {
		return compatiblePets;
	}

	public void setCompatiblePets(List<String> compatiblePets) {
		this.compatiblePets = compatiblePets;
	}

	public boolean accepts(String petType) {
		if (getCompatiblePets().contains(petType)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasPet(Pet pet) {

		for (Pet petInCage : petsInCage.values()) {
			if (pet.equals(petInCage)) {
				return true;
			}
		}
		return false;
	}

	public void removePet(Pet pet) {
		petsInCage.remove(pet.getPetName(), pet);
	}

}
