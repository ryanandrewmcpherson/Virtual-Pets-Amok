package virtual.pets.amok;

public class CatCage extends Cage {
	
	private int litterBoxLevel;

	public CatCage(int cageNumber) {
		super(cageNumber);
		setCageType("Cat Cage");
	    getCompatiblePets().add("Cat");
	    getCompatiblePets().add("Robot Cat");
	    setLitterBoxLevel(0);
		this.setCageCapacity(3);
	}

	public int getLitterBoxLevel() {
		for (Pet pet : getPetsInCage().values()) {
			if (pet.isReal()) {
				if (((RealPet) pet).isPoopInCage()) {
					if (litterBoxLevel + ((RealPet) pet).getPoopSize() >= 10) {
						litterBoxLevel = 10;
					} else {
						litterBoxLevel += ((RealPet) pet).getPoopSize();
					}
				}
				if (((RealPet) pet).isPeeInCage()) {
					if (litterBoxLevel + ((RealPet) pet).getPeeAmount() >= 10) {
						litterBoxLevel = 10;
					} else {
						litterBoxLevel += ((RealPet) pet).getPeeAmount();
					}
				}

			}
		}
		System.out.println("The litter box level is:" + litterBoxLevel + "!");
		return litterBoxLevel;
	}

	public void setLitterBoxLevel(int litterBoxLevel) {
		this.litterBoxLevel = litterBoxLevel;
	}
	
	@Override
	public int getSoilLevel() {
		if(getLitterBoxLevel()==10) {
			return super.getSoilLevel();
		}else {
			return 0;
		}
	}

}
