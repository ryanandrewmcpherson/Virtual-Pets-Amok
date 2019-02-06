package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;



public class CatTest {
	

		
		RealPet sylvester = new Cat("Sylvester");
		 
		@Test
		public void shouldReturnCatWhenPetTypeRequested()
		{
	     assertThat(sylvester.getPetType(),is("Cat"));
		}
		@Test
		public void shouldPurrMeowAndWeaveAroundLegsWhenExcited()
		{
		 assertThat(sylvester.actExcited(),is("Sylvester is purring, meowing and weaving around his legs!"));
		}
		@Test
		public void shouldBeAbleToSetAndRetrieveBoredom() {
			sylvester.setBoredom(5);
			assertThat(sylvester.getBoredom(), is(5));
		}

		@Test
		public void shouldBeAbleToSetAndRetrieveHunger() {
			sylvester.setHunger(5);
			assertThat(sylvester.getHunger(), is(5));
		}

		@Test
		public void shouldBeAbleToSetAndRetrieveThirst() {
			sylvester.setThirst(5);
			assertThat(sylvester.getThirst(), is(5));
		}

		@Test
		public void forPlayBoredomMinus5HungerPlus3ThirstPlus2WhenBoredomMoreEqual5HungerLessEqual7ThirstLessEqual8() {
			sylvester.setBoredom(6);
			sylvester.setHunger(6);
			sylvester.setThirst(6);
			sylvester.play();
			Map<String, Integer> attributesTest = new HashMap<String, Integer>();
			attributesTest.put("Boredom", 1);
			attributesTest.put("Hunger", 9);
			attributesTest.put("Thirst", 8);
			assertThat(sylvester.getAttributes(), is(attributesTest));
		}

		@Test
		public void forPlayBoredom0Hunger10Thirst10WhenBoredomLess5HungerGreater7ThirstGreater8() {
			sylvester.setBoredom(3);
			sylvester.setHunger(8);
			sylvester.setThirst(9);
			sylvester.play();
			Map<String, Integer> attributesTest = new HashMap<String, Integer>();
			attributesTest.put("Boredom", 0);
			attributesTest.put("Hunger", 10);
			attributesTest.put("Thirst", 10);
			assertThat(sylvester.getAttributes(), is(attributesTest));
		}

		@Test
		public void forEatFavFoodBoredomMinus2HungerMinus7ThirstPlus3WhenBoredomGreaterEqual2HungerGreaterEqual7ThirstLessEqual7() {
			sylvester.setBoredom(3);
			sylvester.setHunger(8);
			sylvester.setThirst(6);
			sylvester.eat("cat food");
			Map<String, Integer> attributesTest = new HashMap<String, Integer>();
			attributesTest.put("Boredom", 1);
			attributesTest.put("Hunger", 1);
			attributesTest.put("Thirst", 9);
			assertThat(sylvester.getAttributes(), is(attributesTest));
		}

		@Test
		public void forEatFavFoodBoredom0Hunger0Thirst10WhenBoredomLess2HungerLess7ThirstGreater7() {
			sylvester.setBoredom(1);
			sylvester.setHunger(6);
			sylvester.setThirst(8);
			sylvester.eat("cat food");
			Map<String, Integer> attributesTest = new HashMap<String, Integer>();
			attributesTest.put("Boredom", 0);
			attributesTest.put("Hunger", 0);
			attributesTest.put("Thirst", 10);
			assertThat(sylvester.getAttributes(), is(attributesTest));
		}

		@Test
		public void forNotEatFavFoodBoredomUnchHungerUnchThirstPlus1ifless10() {
			sylvester.setBoredom(5);
			sylvester.setHunger(5);
			sylvester.setThirst(5);
			sylvester.eat("french fries");
			Map<String, Integer> attributesTest = new HashMap<String, Integer>();
			attributesTest.put("Boredom", 5);
			attributesTest.put("Hunger", 5);
			attributesTest.put("Thirst", 6);
			assertThat(sylvester.getAttributes(), is(attributesTest));
		}

		@Test
		public void forDrinkThirstShouldDecreaseBy7IfGreaterEqual7() {
			sylvester.setBoredom(5);
			sylvester.setHunger(5);
			sylvester.setThirst(8);
			sylvester.drink();
			Map<String, Integer> attributesTest = new HashMap<String, Integer>();
			attributesTest.put("Boredom", 5);
			attributesTest.put("Hunger", 5);
			attributesTest.put("Thirst", 1);
			assertThat(sylvester.getAttributes(), is(attributesTest));
		}

		@Test
		public void forDringThirstShouldDecreaseTo0IfLess7() {
			sylvester.setBoredom(5);
			sylvester.setHunger(5);
			sylvester.setThirst(6);
			sylvester.drink();
			Map<String, Integer> attributesTest = new HashMap<String, Integer>();
			attributesTest.put("Boredom", 5);
			attributesTest.put("Hunger", 5);
			attributesTest.put("Thirst", 0);
			assertThat(sylvester.getAttributes(), is(attributesTest));
		}
	}
//		@Test
//		public void shouldStoreCorrectPetNameWhenTypeConstructedWithPetName()
//		{
//		 assertThat(sylvester.getPetName(),is("Sylvester"));
//		}
//		@Test
//		public void shouldReturnYuckWhenCatDoesNotLikeFood()
//		{
//		 assertThat(sylvester.eat("apple"),is("Yuck!"));	
//		}
//		@Test
//		public void shouldReturnYumWhenCatDoesLikeFood()
//		{
//		 assertThat(sylvester.eat("fish"),is("Yum!"));	
//		}
//		@Test
//        public void hungerShouldGoDownTo0WhenSylvesterEatsFoodHeLikesIfHungerLessOrEqual7()
//        {
//        	sylvester.eat("cat food");
//        	assertThat(sylvester.getHunger(), is(0));
//        }
//        @Test
//		public void hungerShouldDecreaseBy7WhenCatEatsFoodHeLikesIfHungerGreaterThan7()
//		{
//           sylvester.setHunger(9);
//           sylvester.eat("cat food");
//           assertThat(sylvester.getHunger(),is(2));	
//		}
//		@Test
//        public void hungerShouldNotChangeWhenCatSamplesFoodHeDoesNotLike()
//        {
//        	sylvester.eat("french fries");
//        	assertThat(sylvester.getHunger(), is(5));
//        }
//		@Test
//		public void thirstShouldIncreaseBy3WhenCatEatsFoodHeLikes() {
//			sylvester.eat("cat food");
//			assertThat(sylvester.getThirst(), is(8));
//		}
//
//		@Test
//		public void thirstShouldIncreaseto10WhenCatEatsFoodHeLikesIfThirstIsGreaterThan7() {
//			sylvester.setThirst(8);
//			sylvester.eat("cat food");
//			assertThat(sylvester.getThirst(), is(10));
//		}
//
//		@Test
//		public void thirstShouldIncreaseby1WhenCatSamplesFoodHeDoesNotLike() {
//			sylvester.eat("garlic");
//			assertThat(sylvester.getThirst(), is(6));
//		}
//		@Test
//		public void thirstShouldNotIncreaseWhenCatSamplesFoodHeDoesNotLikeIfAlreadyMaximum() {
//			sylvester.setThirst(10);
//			sylvester.eat("garlic");
//			assertThat(sylvester.getThirst(), is(10));
//		}
//		@Test
//		public void thirstShouldDecreaseBy7WhenCatDrinksIfThirstIsGreaterThanorEqualTo7() {
//			sylvester.setThirst(10);
//			sylvester.drink();
//			assertThat(sylvester.getThirst(), is(3));
//		}
//		@Test
//		public void thirstShouldDecreaseTo0WhenCatDrinksIfThirstIsLessThan7() {
//			sylvester.setThirst(5);
//			sylvester.drink();
//			assertThat(sylvester.getThirst(),is(0));
//		}
//		@Test
//		public void shouldHissAndGrowlWhenActingMad()
//		{
//		 assertThat(sylvester.actMad(),is("Sylvester is hissing and growling!"));
//		}
//		@Test
//		public void shouldPeeInLiterBoxAndBuryItWhenPeeing()
//		{
//		 assertThat(sylvester.pee(),is("Sylvester peed in his/her litter box and buried it!"));
//		}
//		@Test
//		public void shouldPoopInLiterBoxAndBuryItWhenPooping()
//		{
//		 assertThat(sylvester.poop(),is("Sylvester pooped in his/her litter box and buried it!"));
//		}
//		@Test
//		public void shouldBeMeowingWhenMakingNoise()
//		{
//		 assertThat(sylvester.makeNoise(),is("Sylvester is meowing!"));
//		}
//		@Test
//		public void SylvesterShouldBiteYouWhenBiting()
//		{
//			assertThat(sylvester.bite(), is("Sylvester bit you!"));
//		}
//		@Test
//		public void shouldPurrWhenActingHappy()
//		{
//		 assertThat(sylvester.actHappy(),is("Sylvester is purring!"));
//		}



