package virtual.pets.amok;

public class RobotDog extends RobotPet implements walkable{

	public RobotDog(String petName) {
		super(petName);
	    setPlaying("retrieving the smart bone!");
	    setPlayWith("throwing the smart bone for " + petName + " and telling him to go get it!");
	    setExcited("barking, wagging his/her tail and jumping around!");
	    setType("Robot Dog");
	}

	@Override
	public void walk() {
		if(getBatteryLevel()>=1) {
			setBatteryLevel(getBatteryLevel() - 1);
		}
		if(getOilLevel()>=1) {
			setOilLevel(getOilLevel()-1);
		}
		if(getHappiness()>5) {
			setHappiness(10);
		}
		else if(getHappiness()<=5) {
		    setHappiness(getHappiness()+5);
		}
		updateAttributes();
		
	}
}
