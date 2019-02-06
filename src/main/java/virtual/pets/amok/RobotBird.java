package virtual.pets.amok;

public class RobotBird extends RobotPet {

	public RobotBird(String petName) {
		super(petName);
		setPlaying("hopping around tweeting!");
		setPlayWith("flattering " + petName + "!");
		setExcited("flying around rapidly!");
		setType("Robot Bird");
	}

}
