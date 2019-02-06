package virtual.pets.amok;

public class Bird extends RealPet {

	public Bird(String petName) {
		super(petName);
		getFavoriteFoods().add("seeds");
		getFavoriteFoods().add("worms");
		getFavoriteFoods().add("bugs");
		getFavoriteFoods().add("pellets");
		setPlaying("hopping around tweeting!");
		setPlayWith("flattering " + petName + "!");
		setExcited("flying around rapidly!");
		setType("Bird");
		setPoopSize(1);
		setPeeAmount(0);
	}
	


}
