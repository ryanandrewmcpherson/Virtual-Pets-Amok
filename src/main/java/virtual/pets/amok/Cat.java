package virtual.pets.amok;

public class Cat extends RealPet {

	public Cat(String petName) {
		super(petName);
		getFavoriteFoods().add("cat food");
		getFavoriteFoods().add("fish");
		getFavoriteFoods().add("rodent");
		getFavoriteFoods().add("bird");
        setPlaying("chasing the toy mouse!");
        setPlayWith("pulling a toy mouse on the end of a string!");  
        setExcited("purring, meowing and weaving around legs!");
        setType("Cat");
        setPoopSize(3);
        setPeeAmount(2);
	}	
	
}
