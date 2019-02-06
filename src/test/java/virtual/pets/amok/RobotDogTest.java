package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.TreeMap;
import java.util.Map;

import org.junit.Test;

public class RobotDogTest {

	RobotDog roby = new RobotDog("Roby");

	@Test
	public void shouldReturnRobotDogWhenPetTypeRequested() {
		assertThat(roby.getPetType(), is("Robot Dog"));
	}

	@Test
	public void shouldBarkWagTailAndJumpAroundWhenActingExcited() {
		assertThat(roby.actExcited(), is("Roby is barking, wagging his/her tail and jumping around!"));
	}

	@Test
	public void shouldBeAbleToSetAndRetrieveBoredom() {
		roby.setBoredom(5);
		assertThat(roby.getBoredom(), is(5));
	}

	@Test
	public void forPlayBoredomMinus5HungerPlus3ThirstPlus2WhenBoredomMoreEqual5HungerLessEqual7ThirstLessEqual8() {
		roby.setBoredom(6);
		roby.play();
		roby.updateAttributes();
		Map<String, Integer> attributesTest = new TreeMap<String, Integer>();
		attributesTest.put("Boredom", 1);
		attributesTest.put("Hunger", 9);
		attributesTest.put("Thirst", 8);
		attributesTest.put("^Oil Level", 5);
		assertThat(roby.getAttributes(), is(attributesTest));
	}

	@Test
	public void forPlayBoredom0Hunger10Thirst10WhenBoredomLess5HungerGreater7ThirstGreater8() {
		roby.setBoredom(3);
		roby.play();
		roby.updateAttributes();
		Map<String, Integer> attributesTest = new TreeMap<String, Integer>();
		attributesTest.put("Boredom", 0);
		attributesTest.put("Hunger", 10);
		attributesTest.put("Thirst", 10);
		attributesTest.put("^Oil Level", 5);
		assertThat(roby.getAttributes(), is(attributesTest));
	}

	@Test
	public void shouldHaveOilLevel() {
		roby.setOilLevel(5);
		roby.setBoredom(5);
		roby.updateAttributes();
		Map<String, Integer> attributesTest = new TreeMap<String, Integer>();
		attributesTest.put("Boredom", 5);
		attributesTest.put("^Oil Level", 5);
		assertThat(roby.getAttributes(), is(attributesTest));
	}

	@Test
	public void shouldUpdateOilLevelWhenAttributesUpdated() {
		roby.setOilLevel(7);
		roby.setBoredom(7);
		roby.updateAttributes();
		Map<String, Integer> attributesTest = new TreeMap<String, Integer>();
		attributesTest.put("Boredom", 7);
		attributesTest.put("^Oil Level", 7);
		assertThat(roby.getAttributes(), is(attributesTest));
	}

	@Test
	public void shouldBeARobot() {
		assertThat(roby.isRobot(), is(true));
	}

}
