package firstTask;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;

/**
 * Created by andrzej on 30.08.17.
 */
public class Demo {


	public static void main(String[] args) {

		UserService userService = new UserService();

		List<User> randomUsers1 = userService.createRandomUsers(25);

//		randomUsers1.forEach(c -> System.out.println(c));


		/*List<Name> allNames = userService.getAllNames(randomUsers1);
		allNames.forEach(c -> System.out.println(c));
//*/
//		Set<Name> uniqueNames = userService.getUniqueNames(randomUsers1);
//		uniqueNames.forEach(c -> System.out.println(c));

/*		OptionalDouble averageAge = userService.getAverageAge(randomUsers1);

		double asDouble = averageAge.getAsDouble();
		System.out.println(asDouble);*/

		/*Integer maximumAge = userService.getMaximumAge(randomUsers1);
		System.out.println("max ages is " + maximumAge);

		Integer minAge = userService.getMinimumAge(randomUsers1);
		System.out.println("min ages is " + minAge);
*/
		/*List allSkills = userService.getAllSkills(randomUsers1);
		String s = allSkills.get(0).toString();
		allSkills.forEach(c -> System.out.println(c));*/

		Set<Skills> allUniqueSkills = userService.getAllUniqueSkills(randomUsers1);
		allUniqueSkills.forEach(s -> System.out.println(s));


//		Set<String> uniqueNames = userService.getUniqueNames(randomUsers);
//		uniqueNames.forEach(c -> System.out.println(c));
	}
}
