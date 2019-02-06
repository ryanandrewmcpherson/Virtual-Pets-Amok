package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class RealPetTest {

	
	@Test
	public void organicPetShouldHavebowelLevel()
	{
     RealPet fido = new Dog("Fido");
     fido.setBowelLevel(5);
     assertThat(fido.getBowelLevel(),is(5));
	}
	@Test
	public void organicPetShouldHavebladderLevel()
	{
	 RealPet roca = new Cat("Roca");
	 roca.setBladderLevel(5);
	 assertThat(roca.getBladderLevel(),is(5));
	}
	@Test
	public void organicPetShouldHaveDefaultBoweLevelof5() {
	 RealPet tweety = new Bird("Tweety");
	 assertThat(tweety.getBowelLevel(),is(5));
	}
	@Test
	public void organicPetShouldHaveDefaultBladderLevelof5() {
	 RealPet tweety = new Bird("Tweety");
	 assertThat(tweety.getBladderLevel(),is(5));
	}
	@Test
	public void bowelLevelCopyInsideAttributesShouldBeUpDatedWhenBowelLevelIsUpdated()
	{
	 RealPet fido = new Dog("Fido");;
	 fido.setBowelLevel(10);
	 assertThat(fido.getAttributes().get("~Bowel Level"), is(10));
	}
	@Test
	public void bladderLevelCopyInsideAttributesShouldBeUpDatedWhenBladderLevelIsUpdated()
	{
	 RealPet tweety = new Bird("Tweety");
	 tweety.setBladderLevel(10);
	 assertThat(tweety.getAttributes().get("~Bladder Level"), is(10));
	}
}
