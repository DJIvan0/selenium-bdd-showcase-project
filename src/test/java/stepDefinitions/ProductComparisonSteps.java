package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FusionBackpackProductPage;
import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import resources.Driver;

public class ProductComparisonSteps {

	private HomePage homePage = new HomePage(Driver.getDriver());
	private FusionBackpackProductPage fusionBackpackProductPage = new FusionBackpackProductPage(Driver.getDriver());
	private ProductComparePage productComparePage = new ProductComparePage(Driver.getDriver());


	@Given("User is on desired product page")
	public void user_is_on_desired_product_page() throws InterruptedException {
	    homePage.clickOnFusionBackpackLink();
	    Thread.sleep(1000);
	}

	@When("User clicks on add to compare button")
	public void user_clicks_on_add_to_compare_button() {
	    fusionBackpackProductPage.clickAddToCompareLink();
	}

	@When("User clicks on confirmation message link")
	public void user_clicks_on_confirmation_message_link() {
	    fusionBackpackProductPage.proceedToProductComparisonPage(false);
	}

	@Then("User should be taken to compare products page and see added product displayed")
	public void user_should_be_taken_to_compare_products_page_and_see_added_product_displayed() {
	    productComparePage.verifyaddToCartButtonPresent();
	}

	@When("User clicks on header link")
	public void user_clicks_on_header_link() {
		fusionBackpackProductPage.proceedToProductComparisonPage(true);
	}

	@Given("User is on compare products page")
	public void user_is_on_compare_products_page() throws InterruptedException {
		homePage.clickOnFusionBackpackLink();
	    Thread.sleep(1000);
	    fusionBackpackProductPage.clickAddToCompareLink();
	    fusionBackpackProductPage.proceedToProductComparisonPage(false);
	}

	@When("User clicks to remove desired product")
	public void user_clicks_to_remove_desired_product() {
	    productComparePage.clickToRemoveProduct();
	}

	@When("User confirms their decision within popup")
	public void user_confirms_their_decision_within_popup() {
	    productComparePage.confirmChoiceToRemoveProduct();
	}

	@Then("User should be notified that removal was successful")
	public void user_should_be_notified_that_removal_was_successful() {
	    productComparePage.verifyRemovalConfirmationMessagePresent();
	}
}
