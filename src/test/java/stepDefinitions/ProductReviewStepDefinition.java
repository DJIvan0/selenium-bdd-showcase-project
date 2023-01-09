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
import pageObjects.ArgusAllWeatherTankProductPage;
import pageObjects.HomePage;
import resources.Driver;

public class ProductReviewStepDefinition {

	public WebDriver driver;
	HomePage homePage;
	ArgusAllWeatherTankProductPage argusAllWeatherTankProductPage;

	@Before
	public void setUp(Scenario scenario) throws IOException {
		driver = Driver.initializeDriver();
		driver.get(Driver.properties.getProperty("url"));
		homePage = new HomePage(driver);
		argusAllWeatherTankProductPage = new ArgusAllWeatherTankProductPage(driver);
	}

	@Given("User selects a certain product from the home page")
	public void user_selects_a_certain_product_from_the_home_page() {
		homePage.clickOnArgusAllWeatherTankLink();
	}

	@When("User goes to the review section on the product page")
	public void user_goes_to_the_review_section_on_the_product_page() {
		argusAllWeatherTankProductPage.clickOnReviewTabLink();
	}

	@And("Enters a nickname for the review")
	public void enters_a_nickname_for_the_review() {
		argusAllWeatherTankProductPage.enterNickname(Driver.properties.getProperty("nickname"));
	}

	@And("Enters a summary for the review")
	public void enters_a_summary_for_the_review() {
		argusAllWeatherTankProductPage.enterReviewSummary(Driver.properties.getProperty("reviewSummary"));
	}

	@And("Enters the text for the review itself")
	public void enters_the_text_for_the_review_itself() {
		argusAllWeatherTankProductPage.enterReviewText(Driver.properties.getProperty("reviewText"));
	}

	@And("Leaves a star rating for the review")
	public void leaves_a_star_rating_for_the_review() {
		argusAllWeatherTankProductPage.clickOnFiveStars();
	}

	@And("User submits the review")
	public void user_submits_the_review() {
		argusAllWeatherTankProductPage.clickOnSubmitReviewButton();
	}

	@Then("The user is notified that the review is submitted")
	public void the_user_is_notified_that_the_review_is_submitted() {
		argusAllWeatherTankProductPage.assertConfirmationMessagePresent();
	}

	@After
	public void tearDown(Scenario scenario) {
		driver.close();
	}

}
