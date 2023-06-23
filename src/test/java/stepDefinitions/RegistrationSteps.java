package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import resources.Driver;
import resources.PasswordLength;
import resources.PasswordStrength;
import resources.User;
import resources.UserFactory;

public class RegistrationSteps{
	
	private HomePage homePage = new HomePage(Driver.getDriver());
	private RegistrationPage registrationPage = new RegistrationPage(Driver.getDriver());
	private AccountPage accountPage = new AccountPage(Driver.getDriver());
	private User user;

	@Given("User is on registration page")
	public void user_is_on_registration_page() throws InterruptedException {
		homePage.clickOnRegistrationLink();
		Thread.sleep(1000);
	}

	@When("User clicks on Create an account button without filling out required fields")
	public void user_clicks_on_Create_an_account_button_without_filling_out_required_fields() {
	    registrationPage.clickOnCreateAnAccountButton();
	}

	@Then("Message about required field not being filled should appear for every mandatory field")
	public void message_about_required_field_not_being_filled_should_appear_for_every_mandatory_field() {
	    registrationPage.assertAllMandatoryFields();
	}

	@When("User fills out mandatory fields")
	public void user_fills_out_mandatory_fields() {
		user = UserFactory.createUser();
		
		registrationPage.fillOutAllMandatoryFields(user);
	}

	@When("User clicks on Create an account button")
	public void user_clicks_on_Create_an_account_button() {
	    registrationPage.clickOnCreateAnAccountButton();
	}

	@Then("User should be taken to Account page")
	public void user_should_be_taken_to_account_page() {
	    accountPage.assertHeadingnPresent();
	}

	@When("User checks they want to sign up for newsletter")
	public void user_checks_they_want_to_sign_up_for_newsletter() {
	    registrationPage.checkSubscriptionBox();
	}

	@When("User inputs email of invalid format into email field")
	public void user_inputs_email_of_invalid_format_into_email_field() {
		user = UserFactory.createUser();
		
	    registrationPage.inputEmail(user, false);
	}

	@Then("Message about changing the input to a valid format should appear")
	public void message_about_changing_the_input_to_a_valid_format_should_appear() {
	    registrationPage.validateEmailField(false);
	}

	@When("User inputs email of valid format into email field")
	public void user_inputs_email_of_valid_format_into_email_field() {
		user = UserFactory.createUser();
		
	    registrationPage.inputEmail(user, true);
	}

	@Then("Message about changing the input to a valid format should not appear")
	public void message_about_changing_the_input_to_a_valid_format_should_not_appear() {
	    registrationPage.validateEmailField(true);
	}

	@When("User inputs password with smaller than minimal required length into password field")
	public void user_inputs_password_with_smaller_than_minimal_required_length_into_password_field() {
		user = UserFactory.createUser();
		
	    registrationPage.inputPasswordWithCertainLength(user, PasswordLength.LESS_THAN_EIGHT);
	}

	@Then("Message about required password length should appear")
	public void message_about_required_password_length_should_appear() {
	    registrationPage.validatePasswordLength(PasswordLength.LESS_THAN_EIGHT);
	}

	@When("User inputs password of minimal required length into password field")
	public void user_inputs_password_of_minimal_required_length_into_password_field() {
		user = UserFactory.createUser();
		
	    registrationPage.inputPasswordWithCertainLength(user, PasswordLength.EIGHT);
	}

	@Then("Message about required password length should not appear")
	public void message_about_required_password_length_should_not_appear() {
		registrationPage.validatePasswordLength(PasswordLength.EIGHT_OR_MORE);
	}

	@When("User inputs password with greater than minimal required length into password field")
	public void user_inputs_password_with_greater_than_minimal_required_length_into_password_field() {
		user = UserFactory.createUser();
		
	    registrationPage.inputPasswordWithCertainLength(user, PasswordLength.MORE_THAN_EIGHT);
	}

	@When("User inputs matching values into password and confirm password fields")
	public void user_inputs_matching_values_into_password_and_confirm_password_fields() {
		user = UserFactory.createUser();
		
		registrationPage.inputMatchingPasswords(user, true);
	}

	@Then("Message about passwords not matching should not appear")
	public void message_about_passwords_not_matching_should_not_appear() {
	    registrationPage.validateMatchingPasswords(true);
	}

	@When("User inputs different values into password and confirm password fields")
	public void user_inputs_different_values_into_password_and_confirm_password_fields() {
		user = UserFactory.createUser();
		
		registrationPage.inputMatchingPasswords(user, false);
	}

	@Then("Message about passwords not matching should appear")
	public void message_about_passwords_not_matching_should_appear() {
	    registrationPage.validateMatchingPasswords(false);
	}

	@When("User inputs weak password")
	public void user_inputs_weak_password() {
		user = UserFactory.createUser();
		
		registrationPage.inputPasswordWithCertainStrength(user, PasswordStrength.WEAK);
	}

	@Then("Strength meter should display that password is weak")
	public void strength_meter_should_display_that_password_is_weak() {
	    registrationPage.validatePasswordStrengthMeterIsWorking(PasswordStrength.WEAK);
	}

	@When("User inputs strong password")
	public void user_inputs_strong_password() {
		user = UserFactory.createUser();
		
		registrationPage.inputPasswordWithCertainStrength(user, PasswordStrength.STRONG);
	}

	@Then("Strength meter should display that password is strong")
	public void strength_meter_should_display_that_password_is_strong() {
		registrationPage.validatePasswordStrengthMeterIsWorking(PasswordStrength.STRONG);
	}

	@When("User inputs very strong password")
	public void user_inputs_very_strong_password() {
		user = UserFactory.createUser();
		
		registrationPage.inputPasswordWithCertainStrength(user, PasswordStrength.VERY_STRONG);
	}

	@Then("Strength meter should display that password is very strong")
	public void strength_meter_should_display_that_password_is_very_strong() {
		registrationPage.validatePasswordStrengthMeterIsWorking(PasswordStrength.VERY_STRONG);
	}
}
