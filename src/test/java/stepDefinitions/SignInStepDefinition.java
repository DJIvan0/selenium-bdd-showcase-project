package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import resources.Driver;

public class SignInStepDefinition {

	public WebDriver driver;
	HomePage homePage;
	SignInPage signInPage;

	@Before
	public void setUp(Scenario scenario) throws IOException {
		driver = Driver.initializeDriver();
		driver.get(Driver.properties.getProperty("url"));
		homePage = new HomePage(driver);
		signInPage = new SignInPage(driver);
	}

	@Given("User clicks on the sign in link on the home page")
	public void user_clicks_on_the_sign_in_link_on_the_home_page() {
		homePage.clickOnSignInLink();
	}

	@When("User enters required username")
	public void user_enters_required_username() {
		signInPage.enterEmailAddress(Driver.properties.getProperty("email"));
	}

	@And("User enters required password")
	public void user_enters_required_password() {
		signInPage.enterPassword(Driver.properties.getProperty("password"));
	}

	@And("User clicks on the sign in button")
	public void user_clicks_on_the_sign_in_button() {
		signInPage.clickOnSignInButton();
	}

	@Then("User signs in and gets returned to the home page")
	public void user_signs_in_and_gets_returned_to_the_home_page() {
		homePage.assertWelcomeMessagePresent();
	}

	@After
	public void tearDown(Scenario scenario) {
		driver.close();
	} 

}
