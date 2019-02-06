package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class RobotCatTest {


		RobotPet roca = new RobotCat("Roca");

		@Test
		public void shouldReturnRobotCatWhenPetTypeRequested() {
			assertThat(roca.getPetType(), is("Robot Cat"));
		}

		@Test
		public void shouldBarkWagTailAndJumpAroundWhenActingExcited() {
			assertThat(roca.actExcited(), is("Roca is purring, meowing and weaving around his legs!"));
		}

		@Test
		public void shouldBeAbleToSetAndRetrieveBoredom() {
			roca.setBoredom(5);
			assertThat(roca.getBoredom(), is(5));
		}


		@Test
		public void forPlayBoredomMinus5HungerPlus3ThirstPlus2WhenBoredomMoreEqual5HungerLessEqual7ThirstLessEqual8() {
			roca.setBoredom(6);	
			roca.play();
			Map<String, Integer> attributesTest = new TreeMap<String, Integer>();
			attributesTest.put("Boredom", 1);
			attributesTest.put("^Oil Level", 5);
			assertThat(roca.getAttributes(), is(attributesTest));
		}

		@Test
		public void forPlayBoredom0Hunger10Thirst10WhenBoredomLess5HungerGreater7ThirstGreater8() {
			roca.setBoredom(3);
			roca.play();
			Map<String, Integer> attributesTest = new TreeMap<String, Integer>();
			attributesTest.put("Boredom", 0);
			attributesTest.put("^Oil Level", 5);
			assertThat(roca.getAttributes(), is(attributesTest));
		}


		@Test
		public void shouldHaveOilLevel() {
			roca.setOilLevel(5);
			roca.setBoredom(5);
			Map<String, Integer> attributesTest = new TreeMap<String, Integer>();
			attributesTest.put("Boredom", 5);
			attributesTest.put("^Oil Level", 5);
			assertThat(roca.getAttributes(), is(attributesTest));
		}

		@Test
		public void shouldUpdateOilLevelWhenAttributesUpdated() {
			roca.setOilLevel(7);
			roca.setBoredom(7);
			roca.updateAttributes();
			Map<String, Integer> attributesTest = new TreeMap<String, Integer>();
			attributesTest.put("Boredom", 7);
			attributesTest.put("^Oil Level", 7);
			assertThat(roca.getAttributes(), is(attributesTest));
		}

		@Test
		public void shouldBeARobot() {
			assertThat(roca.isRobot(), is(true));
		}
}
