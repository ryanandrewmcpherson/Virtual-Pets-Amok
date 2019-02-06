package virtual.pets.amok;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class OwnerTest {
	
	RealPet tweety = new Bird("Tweety");
	Caretaker Jack = new Caretaker("Jack");
	Owner user = new Owner("userName");
	
	@Test
	public void forfeedFavFoodhungerShouldDecreaseByUpTo7ThirstShouldIncreaseByUpTo3BoredomShouldDecreaseByUpTo2()
	{
		tweety.setBoredom(2);
		tweety.setHunger(7);
		tweety.setThirst(7);
		user.feedRealPet(tweety,"seeds");
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 0);
		attributesTest.put("Hunger", 0);
		attributesTest.put("Thirst", 10);
		assertThat(tweety.getAttributes(), is(attributesTest));	
	}
	@Test
	public void forfeedNotFavFoodHungerShouldNotChangeBoredomShouldNotChangeThirstShouldIncreaseByUpTo1()
	{
		tweety.setBoredom(5);
		tweety.setHunger(5);
		tweety.setThirst(9);
		user.feedRealPet(tweety,"french fries");
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 5);
		attributesTest.put("Hunger", 5);
		attributesTest.put("Thirst", 10);
		assertThat(tweety.getAttributes(), is(attributesTest));	
	}
	@Test
	public void forWaterThirstUpto7() {
		tweety.setBoredom(5);
		tweety.setHunger(5);
		tweety.setThirst(7);
		user.waterRealPet(tweety);
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 5);
		attributesTest.put("Hunger", 5);
		attributesTest.put("Thirst", 1);
		assertThat(tweety.getAttributes(), is(attributesTest));
	}
	@Test
	public void forPlayWithBoredomShouldDecreaseUpTo5HungerShouldIncreaseUpTo3ThirstShouldIncreaseUpTo2() {
		tweety.setBoredom(5);
		tweety.setHunger(5);
		tweety.setThirst(5);
		user.playWith(tweety);
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 0);
		attributesTest.put("Hunger", 8);
		attributesTest.put("Thirst", 7);
		assertThat(tweety.getAttributes(), is(attributesTest));
	}

}
