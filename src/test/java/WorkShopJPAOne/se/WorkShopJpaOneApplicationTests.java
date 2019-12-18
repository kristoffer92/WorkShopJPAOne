package WorkShopJPAOne.se;

import WorkShopJPAOne.se.entity.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class WorkShopJpaOneApplicationTests {

	AppUser user = new AppUser(1, "Test", "Testaren", "test@hotmail.com");

	@Test
	public void makeGettersTest(){
		assertEquals(1, user.getId());
		assertEquals("Test", user.getFirstName());
		assertEquals("Testaren", user.getLastName());
		assertEquals("test@hotmail.com" , user.getEmail());
	}

	@Test
	public void makeSettersTest(){
		String firstName = "Test";
		user.setFirstName(user.getFirstName());
		String testFirst = user.getFirstName();
		assertEquals(firstName, testFirst);

		String lastName = "Testaren";
		user.setLastName(user.getLastName());
		String testLast = user.getLastName();
		assertEquals(lastName, testLast);

		String email = "test@hotmail.com";
		user.setEmail(user.getEmail());
		String testEmail = user.getEmail();
		assertEquals(email, testEmail);
	}

	@Test
	public void makeToStringTest(){
		String result = user.toString();
		assertTrue(result.contains("1"));
		assertTrue(result.contains(user.getFirstName()));
		assertTrue(result.contains(user.getLastName()));
		assertTrue(result.contains(user.getEmail()));
	}

	@Test
	public void makeEqualsHashCodeTest(){
		AppUser appUserTwo = new AppUser(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail());
		assertEquals(appUserTwo, user);
		assertEquals(appUserTwo.hashCode(), user.hashCode());
	}


}
