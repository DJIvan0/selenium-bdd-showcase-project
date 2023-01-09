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
import pageObjects.FusionBackpackProductPage;
import pageObjects.HomePage;
import pageObjects.PushItMessengerBagProductPage;
import resources.Driver;

public class ProductComparisonStepDefinition {

	public WebDriver driver;
	HomePage homePage;
	FusionBackpackProductPage fusionBackpackProductPage;
	PushItMessengerBagProductPage pushItMessengerBagProductPage;

	@Before
	public void setUp(Scenario scenario) throws IOException {
		driver = Driver.initializeDriver();
		driver.get(Driver.properties.getProperty("url"));
		homePage = new HomePage(driver);
		fusionBackpackProductPage=new FusionBackpackProductPage(driver);
		pushItMessengerBagProductPage=new PushItMessengerBagProductPage(driver);
	}

	@Given("User selects the first product from the home page")
	public void user_selects_the_first_product_from_the_home_page() throws InterruptedException {
		homePage.clickOnFusionBackpackLink();
		Thread.sleep(2000);
	}

	@When("User adds the first product to the comparing list")
	public void user_adds_the_first_product_to_the_comparing_list() {
		fusionBackpackProductPage.clickOnAddToCompareLink();
	}

	@And("User goes back to the home page")
	public void user_goes_back_to_the_home_page() {
		fusionBackpackProductPage.clickOnHomePageLink();
	}

	@And("User selects the second product from the home page")
	public void user_selects_the_second_product_from_the_home_page() throws InterruptedException {
		homePage.clickOnPushItMessengerBagLink();
		Thread.sleep(2000);
	}

	@And("User adds the second product to the comparing list")
	public void user_adds_the_second_product_to_the_comparing_list() {
		pushItMessengerBagProductPage.clickOnAddToCompareLink();
	}

	@Then("User clicks on the comparing list and views two added products inside")
	public void user_clicks_on_the_comparing_list_and_views_two_added_products_inside() throws InterruptedException {
		pushItMessengerBagProductPage.clickOnHomePageLink();
		Thread.sleep(2000);
		homePage.clickOnCompareProductsPageLink();
	}

	@After
	public void tearDown(Scenario scenario) {
		driver.close();
	}

}
