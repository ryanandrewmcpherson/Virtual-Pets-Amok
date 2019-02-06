package virtual.pets.amok;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public abstract class Pet {

	private String petName;
	private String excited;
	private String type;
	private int boredom;
	private Map<String, Integer> attributes = new TreeMap<String, Integer>();
	private String playWith;
	private boolean isRobot;
	private boolean isReal;
	private String playing;
	private int happiness;
	private int health;

	public Pet(String petName) {
		this.setPetName(petName);
		boredom = 5;
		happiness = 5;
		health = 5;
		updateAttributes();

	}

	public boolean isRobot() {
		return isRobot;
	}

	public void setRobot(boolean isRobot) {
		this.isRobot = isRobot;
	}

	public String getPlaying() {
		return playing;
	}

	public void setPlaying(String playing) {
		this.playing = playing;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getBoredom() {
		return boredom;
	}

	public void setBoredom(int boredom) {
		this.boredom = boredom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExcited() {
		return excited;
	}

	public void setExcited(String excited) {
		this.excited = excited;
	}

	public String getPlayWith() {
		return playWith;
	}

	public void setPlayWith(String playWith) {
		this.playWith = playWith;
	}

	public Map<String, Integer> getAttributes() {
		return attributes;
	}

	public void updateAttributes() {
		attributes.put("Boredom", boredom);
		attributes.put("Happiness", happiness);
		attributes.put("Health", health);
	}

	public String getPetType() {
		return getType();
	}

	public void updateHealth(int soilLevel) {
		if (boredom == 10) {
			setHealth(getHealth() - 1);
		} else if (boredom == 0) {
			setHealth(getHealth() + 1);
		}
		if (happiness == 10) {
			setHealth(getHealth() + 1);
		} else if (happiness == 0) {
			setHealth(getHealth() + 1);
		}

	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public boolean isReal() {
		return isReal;
	}

	public void setReal(boolean isReal) {
		this.isReal = isReal;
	}

	public void play() {
		System.out.println("You are " + getPlayWith());
		System.out.println(getPetName() + " is " + playing);
		if (boredom >= 5) {
			boredom -= 5;
		} else {
			boredom = 0;
		}
		updateAttributes();
	}

	public String actExcited() {
		System.out.println(getPetName() + " is " + getExcited());
		return getPetName() + " is " + getExcited();
	}

	@Override
	public boolean equals(Object object) {
		try {
			Pet pet = (Pet) object;
			String thatPetType = pet.getPetType();
			String thatPetName = pet.getPetName();
			Map<String, Integer> thatPetsAttributes = pet.getAttributes();
			boolean typesAreEqual = thatPetType.equals(this.getPetType());
			boolean namesAreEqual = thatPetName.equals(this.getPetName());
			boolean attributesAreEqual = thatPetsAttributes.equals(this.getAttributes());
			boolean hashesAreEqual = pet.hashCode() == this.hashCode();
			if (typesAreEqual && namesAreEqual && attributesAreEqual && hashesAreEqual) {
				return true;
			} else {
				return false;
			}
		} catch (Exception Exception) {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getPetType(), this.getPetName(), this.getAttributes());
	}
}
