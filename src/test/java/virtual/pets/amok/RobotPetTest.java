package virtual.pets.amok;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class RobotPetTest {
	
	@Test
	public void shouldHaveBatteryLevel()
	{
	 RobotPet roby = new RobotDog("Roby");
	 roby.setBatteryLevel(5);
	 assertThat(roby.getBatteryLevel(),is(5));
	}
	@Test
	public void shouldHaveDefaultBatterLevel5()
	{
	 RobotPet roca = new RobotCat("Roca");
	 assertThat(roca.getBatteryLevel(),is(5));
	}
	@Test
	public void batteryLevelCopyInsideAttributesShouldBeUpDatedWhenBatteryLevelIsUpdated()
	{
	 RobotPet rota = new RobotBird("Rota");
	 rota.setBatteryLevel(10);
	 assertThat(rota.getAttributes().get("^Battery Level"), is(10));
	}
	

}
