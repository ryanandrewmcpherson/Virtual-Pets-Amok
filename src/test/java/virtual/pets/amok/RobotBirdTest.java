package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class RobotBirdTest {
	
	RobotPet rota = new RobotBird("Rota");
	@Test
	public void shouldReturnRobotBirdWhenPetTypeRequested() {
		assertThat(rota.getPetType(), is("Robot Bird"));
	}

	@Test
	public void shouldFlyAroundRapidlyWhenExcited() {
		assertThat(rota.actExcited(), is("Rota is flying around rapidly!"));
	}

	@Test
	public void shouldBeAbleToSetAndRetrieveBoredom() {
		rota.setBoredom(5);
		assertThat(rota.getBoredom(), is(5));
	}


	@Test
	public void forPlayBoredomMinus5HungerPlus3ThirstPlus2WhenBoredomMoreEqual5HungerLessEqual7ThirstLessEqual8() {
		rota.setBoredom(6);
		rota.play();
		Map<String, Integer> attributesTest = new TreeMap<String, Integer>();
		attributesTest.put("Boredom", 1);
		attributesTest.put("Hunger", 9);
		attributesTest.put("Thirst", 8);
		attributesTest.put("^Oil Level", 5);
		assertThat(rota.getAttributes(), is(attributesTest));
	}

	@Test
	public void forPlayBoredom0Hunger10Thirst10WhenBoredomLess5HungerGreater7ThirstGreater8() {
		rota.setBoredom(3);
		rota.play();
		Map<String, Integer> attributesTest = new TreeMap<String, Integer>();
		attributesTest.put("Boredom", 0);
		attributesTest.put("^Oil Level", 5);
		assertThat(rota.getAttributes(), is(attributesTest));
	}


	@Test
	public void shouldHaveOilLevel() {
		rota.setOilLevel(5);
		rota.setBoredom(5);
		Map<String, Integer> attributesTest = new TreeMap<String, Integer>();
		attributesTest.put("Boredom", 5);
		attributesTest.put("^Oil Level", 5);
		assertThat(rota.getAttributes(), is(attributesTest));
	}

	@Test
	public void shouldUpdateOilLevelWhenAttributesUpdated() {
		rota.setOilLevel(7);
		rota.setBoredom(7);
		rota.updateAttributes();
		Map<String, Integer> attributesTest = new TreeMap<String, Integer>();
		attributesTest.put("Boredom", 7);
		attributesTest.put("^Oil Level", 7);
		assertThat(rota.getAttributes(), is(attributesTest));
	}

	@Test
	public void shouldBeARobot() {
		assertThat(rota.isRobot(), is(true));
	}
	

}
