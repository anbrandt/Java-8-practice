package firstTask;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by andrzej on 30.08.17.
 */
public class UserServiceTest {

	private UserService userService;


	@Before
	public void setUp() {
		userService = new UserService();

	}

	@Test
	public void shouldCreateProperNumberOfUsers() {

		List<User> randomUsers = userService.createRandomUsers(30);
		assertEquals(30, randomUsers.size());
	}


	@Test
	public void shouldReturnNamesOnly() {

		//given
		List<User> randomUsers = userService.createRandomUsers(30);

		//when
		List<Name> allNames = userService.getAllNames(randomUsers);
		Name[] values = Name.values();

		List<Name> names = Arrays.asList(values);

		//then
//		assertTrue(allNames.containsAll(names));

	}

}