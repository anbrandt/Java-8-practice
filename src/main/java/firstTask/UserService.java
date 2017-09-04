package firstTask;

import javax.jws.soap.SOAPBinding;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by andrzej on 30.08.17.
 */
public class UserService implements UserGenerator {
	//generate random users

	private Random random;
	private List<User> usersList;

	public UserService() {
		random = new Random();
		usersList = new ArrayList<>();
	}

	@Override
	public List<User> createRandomUsers(int n) {

		for (int i = 0; i < n; i++) {
			List<Skills> skills = new ArrayList<>();
			for (Skills skills1 : Skills.values()) {
				skills.add(skills1);
			}
			usersList.add(new User(i, getRandomName(), random.nextInt(30) + 10, getRandomSkills()));
		}
		return usersList;

	}

	public List<Name> getAllNames(List<User> listOfUsers) {


		return listOfUsers.stream()
				.map(User::getName)
				.collect(Collectors.toList());

	}

	public Set<Name> getUniqueNames(List<User> usersList) {

		return usersList.stream()
				.map(User::getName)
				.distinct()
				.collect(Collectors.toSet());
	}


	public OptionalDouble getAverageAge(List<User> usersList) {

		return usersList.stream()
				.mapToDouble(User::getAge)
				.average();
	}

	public Integer getMaximumAge(List<User> usersList) {
		return usersList.stream()
				.map(User::getAge)
				.max(Integer::compare)
				.get();
	}

	public Integer getMinimumAge(List<User> usersList) {
		return usersList.stream()
				.map(User::getAge)
				.min(Integer::compare)
				.get();
	}

	public Map<Integer, User> groupById(List<User> usersList) {

		return usersList.stream()
				.collect(Collectors.toMap(User::getId, Function.identity()));
	}

	public String joinNamesUsingDelimiter(List<User> usersList, String delimiter) {

		return usersList.stream()
				.map(User::getName)
				.map(Name::toString)
				.collect(Collectors.joining(delimiter));
	}

	public List<Skills> getAllSkills(List<User> usersList) {

		return usersList.stream()
				.map(User::getSkillsList)
				.flatMap(List::stream)
				.collect(Collectors.toList());
	}


	public Set<Skills> getAllUniqueSkills(List<User> usersList) {

		return usersList.stream()
				.map(User::getSkillsList)
				.flatMap(List::stream)
				.collect(Collectors.toSet());
	}


	private Name getRandomName() {
		Random random = new Random();

		int i = random.nextInt(Name.values().length);
		Name name = Name.values()[i];

		return name;

	}

	private List<Skills> getRandomSkills() {
		Random random = new Random();
		List<Skills> skills = new ArrayList<>();


		int i = random.nextInt(Skills.values().length);
		for (int j = 0; j < i; j++) {
			skills.add(Skills.values()[j]);
		}

		return skills;

	}

}
