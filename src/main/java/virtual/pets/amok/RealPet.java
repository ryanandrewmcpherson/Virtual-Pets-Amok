package virtual.pets.amok;

import java.util.ArrayList;
import java.util.List;

public abstract class RealPet extends Pet {

	private int bowelLevel;
	private int bladderLevel;
	private int hunger;
	private int thirst;
	private boolean isPoopInCage;
	private boolean isPeeInCage;
	private int poopSize;
	private int peeAmount;
	private List<String> favoriteFoods = new ArrayList<String>();

	public RealPet(String petName) {
		super(petName);
		this.setHunger(5);
		this.setThirst(5);
		this.setBladderLevel(5);
		this.setBowelLevel(5);
		this.updateAttributes();
		this.setRobot(false);
		this.setReal(true);
		this.setPoopInCage(false);
		this.setPeeInCage(false);

	}

	public List<String> getFavoriteFoods() {
		return favoriteFoods;
	}

	public void setFavoriteFoods(List<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public void setThirst(int thirst) {
		this.thirst = thirst;
	}

	public int getBowelLevel() {
		return bowelLevel;
	}

	public void setBowelLevel(int bowelLevel) {
		this.bowelLevel = bowelLevel;
		updateAttributes();
	}

	public int getBladderLevel() {
		return bladderLevel;
	}

	public void setBladderLevel(int bladderLevel) {
		this.bladderLevel = bladderLevel;
		updateAttributes();
	}

	@Override
	public void updateAttributes() {
		super.updateAttributes();
		getAttributes().put("~Hunger", hunger);
		getAttributes().put("~Thirst", thirst);
		getAttributes().put("~Bowel Lvl", bowelLevel);
		getAttributes().put("~Bladder Lvl", bladderLevel);
	}

	@Override
	public void play() {
		if (hunger <= 7) {
			hunger += 3;
		} else {
			hunger = 10;
		}
		if (thirst <= 8) {
			thirst += 2;
		} else {
			thirst = 10;
		}
		super.play();
	}

	@Override
	public void updateHealth(int soilLevel) {
		super.updateHealth(soilLevel);
		if (soilLevel == 10) {
			decrementHealth();
		} else if (soilLevel == 0) {
		incrementHealth();
		}
		if (getHunger() == 10) {
			decrementHealth();
		} else if (getHunger() == 0) {
			incrementHealth();
		}
		if (getThirst() == 10) {
			decrementHealth();
		} else if (getThirst() == 0) {
		incrementHealth();
		}
		updateAttributes();
	}

	public String eat(String food) {
		for (String favoriteFood : getFavoriteFoods()) {
			if (food.equalsIgnoreCase(favoriteFood)) {
				System.out.println(getPetName() + " ate some " + food + "! Yum!");
				if (hunger >= 7) {
					hunger -= 7;
				} else {
					hunger = 0;
				}
				if (thirst <= 7) {
					thirst += 3;
				} else {
					thirst = 10;
				}
				if (getBoredom() >= 2) {
					setBoredom(getBoredom() - 2);
				} else {
					setBoredom(0);
				}
				if (bowelLevel <= 5) {
					bowelLevel += 5;
				}
				if (bowelLevel > 5) {
					bowelLevel = 10;
				}
				updateAttributes();
				return "Yum!";
			}

		}
		if (getThirst() <= 9) {
			setThirst(getThirst() + 1);
		}
		System.out.println(getPetName() + " did not like " + food + "! Yuck!");
		updateAttributes();
		return "Yuck!";
	}

	public void drink() {
		if (thirst >= 7) {
			thirst -= 7;
		} else {
			thirst = 0;
		}
		if (bladderLevel <= 5) {
			bladderLevel += 5;
		} else if (bladderLevel > 5) {
			bladderLevel = 10;
		}
		System.out.println(getPetName() + " lapped up the water!");
		updateAttributes();
	}

	public boolean isPoopInCage() {
		if(bowelLevel == 10) {
			isPoopInCage = true;
			bowelLevel = 0;
			return isPoopInCage;
		}else {
			isPoopInCage = false;
			return isPoopInCage;
		}
		
	}

	public void setPoopInCage(boolean isPoopInCage) {
		this.isPoopInCage = isPoopInCage;
	}

	public boolean isPeeInCage() {
		if(bladderLevel == 10) {
			isPeeInCage = true;
			bladderLevel = 0;
			return isPeeInCage;
		}else {
			isPeeInCage = false;
			return isPeeInCage;
		}
	
	}

	public void setPeeInCage(boolean isPeeInCage) {
		this.isPeeInCage = isPeeInCage;
	}

	public int getPoopSize() {
		return poopSize;
	}

	public void setPoopSize(int poopSize) {
		this.poopSize = poopSize;
	}

	public int getPeeAmount() {
		return peeAmount;
	}

	public void setPeeAmount(int peeAmount) {
		this.peeAmount = peeAmount;
	}


}
