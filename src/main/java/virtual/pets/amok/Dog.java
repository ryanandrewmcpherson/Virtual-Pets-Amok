package virtual.pets.amok;

public class Dog extends RealPet implements walkable {

	public Dog(String petName) {
		super(petName);
		getFavoriteFoods().add("dog food");
		getFavoriteFoods().add("bone");
		getFavoriteFoods().add("squirrel");
		getFavoriteFoods().add("table scraps");
	    setPlaying("retrieving the frisbee!");
	    setPlayWith("throwing the frisbee for " + petName + " ");
	    setExcited("barking, wagging his/her tail and jumping around!");
	    setType("Dog");
	    setPoopSize(5);
	    setPeeAmount(3);
	}

	@Override
	public void walk() {
	     setBowelLevel(0);
	     setBladderLevel(0);
	     if(getHappiness()>5) {
	       setHappiness(10);
	     }else{
	       setHappiness(getHappiness() + 5);
	     }
		if(getHealth()<10)
		{
		 setHealth(getHealth() + 1);
		}
		if(getHunger()<=7)
		{
	     setHunger(getHunger() + 3);
		}
		else {
	     setHunger(10);
		}
		if(getThirst()<=7) {
		 setThirst(getThirst() + 3);
		}
		else {
		 setThirst(10);
		}
		updateAttributes();
	}
}
