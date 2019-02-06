package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class DogTest {
	RealPet fido = new Dog("Dog");

	@Test
	public void shouldReturnDogWhenPetTypeRequested() {
		assertThat(fido.getPetType(), is("Dog"));
	}

	@Test
	public void shouldBarkWagTailAndJumpAroundWhenActingExcited() {
		assertThat(fido.actExcited(), is("Dog is barking, wagging his/her tail and jumping around!"));
	}
	@Test
	public void shouldBeAbleToSetAndRetrieveBoredom() {
		fido.setBoredom(5);
		assertThat(fido.getBoredom(), is(5));
	}

	@Test
	public void shouldBeAbleToSetAndRetrieveHunger() {
		fido.setHunger(5);
		assertThat(fido.getHunger(), is(5));
	}

	@Test
	public void shouldBeAbleToSetAndRetrieveThirst() {
		fido.setThirst(5);
		assertThat(fido.getThirst(), is(5));
	}

	@Test
	public void forPlayBoredomMinus5HungerPlus3ThirstPlus2WhenBoredomMoreEqual5HungerLessEqual7ThirstLessEqual8() {
		fido.setBoredom(6);
		fido.setHunger(6);
		fido.setThirst(6);
		fido.play();
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 1);
		attributesTest.put("Hunger", 9);
		attributesTest.put("Thirst", 8);
		assertThat(fido.getAttributes(), is(attributesTest));
	}

	@Test
	public void forPlayBoredom0Hunger10Thirst10WhenBoredomLess5HungerGreater7ThirstGreater8() {
		fido.setBoredom(3);
		fido.setHunger(8);
		fido.setThirst(9); 
		fido.play();
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 0);
		attributesTest.put("Hunger", 10);
		attributesTest.put("Thirst", 10);
		assertThat(fido.getAttributes(), is(attributesTest));
	}

	@Test
	public void forEatFavFoodBoredomMinus2HungerMinus7ThirstPlus3WhenBoredomGreaterEqual2HungerGreaterEqual7ThirstLessEqual7() {
		fido.setBoredom(3);
		fido.setHunger(8);
		fido.setThirst(6);
		fido.eat("dog food");
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 1);
		attributesTest.put("Hunger", 1);
		attributesTest.put("Thirst", 9);
		assertThat(fido.getAttributes(), is(attributesTest));
	}

	@Test
	public void forEatFavFoodBoredom0Hunger0Thirst10WhenBoredomLess2HungerLess7ThirstGreater7() {
		fido.setBoredom(1);
		fido.setHunger(6);
		fido.setThirst(8);
		fido.eat("dog food");
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 0);
		attributesTest.put("Hunger", 0);
		attributesTest.put("Thirst", 10);
		assertThat(fido.getAttributes(), is(attributesTest));
	}

	@Test
	public void forNotEatFavFoodBoredomUnchHungerUnchThirstPlus1ifless10() {
		fido.setBoredom(5);
		fido.setHunger(5);
		fido.setThirst(5);
		fido.eat("french fries");
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 5);
		attributesTest.put("Hunger", 5);
		attributesTest.put("Thirst", 6);
		assertThat(fido.getAttributes(), is(attributesTest));
	}

	@Test
	public void forDrinkThirstShouldDecreaseBy7IfGreaterEqual7() {
		fido.setBoredom(5);
		fido.setHunger(5);
		fido.setThirst(8);
		fido.drink();
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 5);
		attributesTest.put("Hunger", 5);
		attributesTest.put("Thirst", 1);
		assertThat(fido.getAttributes(), is(attributesTest));
	}

	@Test
	public void forDringThirstShouldDecreaseTo0IfLess7() {
		fido.setBoredom(5);
		fido.setHunger(5);
		fido.setThirst(6);
		fido.drink();
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 5);
		attributesTest.put("Hunger", 5);
		attributesTest.put("Thirst", 0);
		assertThat(fido.getAttributes(), is(attributesTest));
	}
}

//	@Test
//	public void shouldReturnYuckWhenDogDoesNotLikeFood() {
//		assertThat(fido.eat("apple"), is("Yuck!"));
//	}
//
//	@Test
//	public void shouldReturnYumWhenDogDoesLikeFood() {
//		assertThat(fido.eat("bone"), is("Yum!"));
//	}
//
//	@Test
//	public void fidoShouldHopAroundAndTweetWhenPlaying() {
//		assertThat(fido.play(), is("Dog is retrieving the frisbee!"));
//	}
//
//	@Test
//	public void hungerShouldGoDownTo0WhenDogEatsFoodHeLikesifHungerLessOrEqual7() {
//		fido.eat("dog food");
//		assertThat(fido.getHunger(), is(0));
//	}
//
//	@Test
//	public void hungerShouldDecreaseBy7WhenDogEatsFoodHeLikesifHungerGreaterThan7() {
//		fido.setHunger(9);
//		fido.eat("dog food");
//		assertThat(fido.getHunger(), is(2));
//	}
//
//	@Test
//	public void hungerShouldNotChangeWhenDogSamplesFoodHeDoesNotLike() {
//		fido.eat("french fries");
//		assertThat(fido.getHunger(), is(5));
//	}
//
//	@Test
//	public void thirstShouldIncreaseBy3WhenDogEatsFoodHeLikes() {
//		fido.eat("dog food");
//		assertThat(fido.getThirst(), is(8));
//	}
//
//	@Test
//	public void thirstShouldIncreaseto10WhenDogEatsFoodHeLikesIfThirstIsGreaterThan7() {
//		fido.setThirst(8);
//		fido.eat("dog food");
//		assertThat(fido.getThirst(), is(10));
//	}
//
//	@Test
//	public void thirstShouldIncreaseby1WhenDogSamplesFoodHeDoesNotLike() {
//		fido.eat("garlic");
//		assertThat(fido.getThirst(), is(6));
//	}
//
//	@Test
//	public void thirstShouldNotIncreaseWhenDogSamplesFoodHeDoesNotLikeIfAlreadyMaximum() {
//		fido.setThirst(10);
//		fido.eat("garlic");
//		assertThat(fido.getThirst(), is(10));
//	}
//	@Test
//	public void thirstShouldDecreaseBy7WhenDogDrinksIfThirstIsGreaterThanorEqualTo7() {
//		fido.setThirst(10);
//		fido.drink();
//		assertThat(fido.getThirst(), is(3));
//	}
//	@Test
//	public void thirstShouldDecreaseTo0WhenDogDrinksIfThirstIsLessThan7() {
//		fido.setThirst(5);
//		fido.drink();
//		assertThat(fido.getThirst(),is(0));
//	}
//
//	@Test
//	public void shouldWagTailWhenActingHappy() {
//		assertThat(fido.actHappy(), is("Dog is wagging his/her tail!"));
//	}

//	@Test
//	public void shouldBarkLoudlyAndGrowlWhenActingmad() {
//		assertThat(fido.actMad(), is("Dog is barking loudly and growling!"));
//	}
//
//	@Test
//	public void shouldPeeInTheYardWhenPeeMethodCalled() {
//		assertThat(fido.pee(), is("Dog peed in the yard!"));
//	}
//
//	@Test
//	public void shouldPoopInTheYardWhenPoopMethodCalled() {
//		assertThat(fido.poop(), is("Dog pooped in the yard!"));
//	}
//
//	@Test
//	public void shouldBarkWhenMakingNoise() {
//		assertThat(fido.makeNoise(), is("Dog is barking!"));
//	}
//
//	@Test
//	public void fidoShouldBiteYouWhenBiting() {
//		assertThat(fido.bite(), is("Dog bit you!"));
//	}
//

