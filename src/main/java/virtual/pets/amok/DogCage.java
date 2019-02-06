package virtual.pets.amok;

public class DogCage extends Cage {

	public DogCage(int cageNumber) {
		super(cageNumber);
		setCageType("Dog Cage");
		getCompatiblePets().add("Dog");
		getCompatiblePets().add("Robot Dog");
		this.setCageCapacity(1);
	}

	public Pet getWalkableInCage() {
		for (Pet pet : this.getPetsInCage().values()) {
			return pet;
		}
		return null;
	}
}
