package virtual.pets.amok;

public class Owner {

	private String userName;

	public Owner(String userName) {

		this.userName = userName;

	}

	public Pet feedRealPet(RealPet realPet, String food) {

		realPet.eat(food);
		
		if(realPet.getFavoriteFoods().contains(food))
		{
		 return realPet;
		}
		else
		{
	     String favoriteFoodsString = realPet.getFavoriteFoods().toString().substring(1,realPet.getFavoriteFoods().toString().length() -1);
		 System.out.println(realPet.getPetName() + " likes " + favoriteFoodsString);	
		 return realPet;
		}
	}

	public void waterRealPet(RealPet realPet) {
		System.out.println("You watered " + realPet.getPetName() + "!");
		realPet.drink();
	}

	public void playWith(Pet pet) {
		
        pet.play();
		
	}

	public String getName() {
		
		return userName;
	}

	public void oilRobot(RobotPet pet) {
		pet.setOilLevel(10);	
	}

	public void chargeRobot(RobotPet pet) {
		pet.setBatteryLevel(10);	
	}

}
