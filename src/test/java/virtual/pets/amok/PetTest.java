package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class PetTest {
	
	@Test
	public void petShouldHaveHappiness(){
		Pet fido = new Dog("Fido");
		fido.setHappiness(5); 
		assertThat(fido.getHappiness(),is(5));
	}
	@Test
	public void petShouldHaveDefaultHappiness5() {
		Pet fido = new Dog("Fido");
		assertThat(fido.getHappiness(),is(5));
	}
	@Test
	public void whenHappinessIsUpdatedCopyInsideOfAttributesShouldUpdate()
	{
		Pet fido = new Dog ("Fido");
		assertThat(fido.getAttributes().get("Happiness"),is(5));
	}

}
