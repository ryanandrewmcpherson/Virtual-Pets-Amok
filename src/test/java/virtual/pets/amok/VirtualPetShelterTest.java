package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mockito.internal.util.collections.ListUtil.Converter;


public class VirtualPetShelterTest {

	VirtualPetShelter shelter = new VirtualPetShelter();

	@Test
	public void shouldReturnSize0WhenThereAreNoPets() {
		assertThat(shelter.getNumPets(), is(0));
	}

	@Test
	public void shouldReturnSize1WhenThereIs1Pet() {
		shelter.admitPet(new Bird("tweety"));
		assertThat(shelter.getNumPets(), is(1));
	}

	@Test
	public void shouldReturnSize0WhenPetIsAdopted() {
		Pet tweety = new Bird("Tweety");
	    shelter.admitPet(tweety);
		shelter.adoptPet(tweety);
		assertThat(shelter.getNumPets(), is(0));

	}
	@Test
	public void shouldListPetsInShelterAndTheirTypes()
	{
		Pet tweety = new Bird("Tweety");
		shelter.admitPet(tweety);
		Pet fido = new Dog("Fido");
		shelter.admitPet(fido);
		Pet sylvester = new Cat("Sylvester");
		shelter.admitPet(sylvester);	
		Map<String,String> petsListMap = new HashMap<String,String>();
		petsListMap.put("Tweety",tweety.getPetType());
		petsListMap.put("Sylvester",sylvester.getPetType());
		petsListMap.put("Fido",fido.getPetType());
		Class.for
		
		assertThat(shelter.listPets(),is(petsListMap));
	}
  
}
