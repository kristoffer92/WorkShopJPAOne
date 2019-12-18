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

	}

	@Test
	public void makeToStringTest(){
		String result = user.toString();
		assertTrue(result.contains("1"));
		assertTrue(result.contains(user.getFirstName()));
		assertTrue(result.contains(user.getLastName()));
		assertTrue(result.contains(user.getEmail()));
	}


}
