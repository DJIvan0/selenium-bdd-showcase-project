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
import pageObjects.HeroHoodieProductPage;
import pageObjects.HomePage;
import resources.Driver;

public class AddingItemToShoppingCartStepDefinition {

	public WebDriver driver;
	HomePage homePage;
	HeroHoodieProductPage heroHoodieProductPage;

	@Before
	public void setUp(Scenario scenario) throws IOException {
		driver = Driver.initializeDriver();
		driver.get(Driver.properties.getProperty("url"));
		homePage = new HomePage(driver);
		heroHoodieProductPage = new HeroHoodieProductPage(driver);
	}

	@Given("User clicks on a certain product from the home page")
	public void user_clicks_on_a_certain_product_from_the_home_page() {
		homePage.clickOnHeroHoodieLink();
	}

	@When("User selects the size for the chosen product")
	public void user_selects_the_size_for_the_chosen_product() {
		heroHoodieProductPage.clickOnSizeLOption();
	}

	@And("Selects the color for the chosen product")
	public void selects_the_color_for_the_chosen_product() {
		heroHoodieProductPage.clickOnColorBlackOption();
	}

	@And("Clicks on the add to cart button")
	public void clicks_on_the_add_to_cart_button() {
		heroHoodieProductPage.clickOnAddToCartButton();
	}

	@Then("User is notified that the item is added")
	public void user_is_notified_that_the_item_is_added() {
		heroHoodieProductPage.assertConfirmationMessagePresent();
	}
	
	@After
	public void tearDown(Scenario scenario) {
		driver.close();
	}

}
