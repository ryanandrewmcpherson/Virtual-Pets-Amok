package virtual.pets.amok;

public abstract class RobotPet extends Pet {

	private int oilLvl;
	private int batteryLvl;

	public RobotPet(String petName) {
		super(petName);
		this.setOilLevel(5);
		this.setBatteryLevel(5);
		updateAttributes();
		setRobot(true);
		setReal(false);
	}

	public int getOilLevel() {
		return oilLvl;
	}

	public void setOilLevel(int oilLevel) {
		this.oilLvl = oilLevel;
		this.updateAttributes();
	}

	public int getBatteryLevel() {
		return batteryLvl;
	}

	public void setBatteryLevel(int batteryLevel) {
		this.batteryLvl = batteryLevel;
		this.updateAttributes();
	}

	@Override
	public void updateAttributes() {
		super.updateAttributes();
		getAttributes().put("^Oil Lvl", oilLvl);
		getAttributes().put("^Battery Lvl", batteryLvl);
	}

	@Override
	public void updateHealth(int soilLevel) {
		super.updateHealth(soilLevel);
		if (getOilLevel() == 10) {
			incrementHealth();
		} else if (getOilLevel() == 0) {
			decrementHealth();
		}

		if (getBatteryLevel() == 10) {
			incrementHealth();
		} else if (getBatteryLevel() == 0) {
			decrementHealth();
		}

		updateAttributes();
	}

}