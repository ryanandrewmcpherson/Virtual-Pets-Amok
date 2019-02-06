package virtual.pets.amok;

public class BirdCage extends Cage{

	public BirdCage(int cageNumber) {
		super(cageNumber);
		setCageType("Bird Cage");
		getCompatiblePets().add("Bird");
	    getCompatiblePets().add("Robot Bird");
		this.setCageCapacity(5);
	}
	

}
