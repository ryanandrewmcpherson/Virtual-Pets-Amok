package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class CaretakerTest {

	Caretaker jack = new Caretaker("Jack");
	VirtualPetShelter shelter = new VirtualPetShelter();
	RealPet tweety = new Bird("Tweety");
	RealPet fido = new Dog("Fido");
	RealPet Roby = new Dog("Roby");

	@Test
	public void hungerShouldDecreaseByUpTo7ThirstShouldIncreaseByUpTo3BoredomShouldDecreaseByUpTo2WhenPetsFed() {
		tweety.setBoredom(2);
		tweety.setHunger(7);
		tweety.setThirst(7);
		jack.feedRealPets(shelter);
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 0);
		attributesTest.put("Hunger", 0);
		attributesTest.put("Thirst", 10);
		assertThat(tweety.getAttributes(), is(attributesTest));
	}

	@Test
	public void thirstShouldDecreaseByUpTo7WhenAllPetsAreWatered() {
		tweety.setBoredom(2);
		tweety.setHunger(7);
		tweety.setThirst(7);
		jack.waterPets(shelter);
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 2);
		attributesTest.put("Hunger", 7);
		attributesTest.put("Thirst", 0);
		assertThat(tweety.getAttributes(), is(attributesTest));
	}

	@Test
	public void shouldBeAbleToCheckAllPetsWithoutChangingAttributes() {
		assertThat(jack.checkPets(shelter), is(shelter));
	}

	@Test
	public void shouldBeAbleToGetPetOutToInteractWith() {
		assertThat(jack.getPetOut(shelter, "Fido"), is(fido));
	}
	
	@Test
	public void shouldBeAbleToOilAllRobotPets() {
		jack.oilRobots(shelter);
		assertThat(((RobotDog) roby).getOilLevel(),is(10));
	}


}
