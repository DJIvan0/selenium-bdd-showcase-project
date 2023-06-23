package resources;

import com.github.javafaker.Faker;

public class UserFactory {

	private static final Faker faker;

	static {
		faker = new Faker();
	}

	public static User createUser() {
		User user = new User();
		user.setFirstName(faker.name().firstName());
		user.setLastName(faker.name().lastName());
		user.setEmail(faker.internet().safeEmailAddress());
		user.setPassword(faker.internet().password());
		user.setConfirmPassword(user.getPassword());

		return user;
	}
}
