package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArgusAllWeatherTankProductPage;
import pageObjects.HomePage;
import resources.Driver;

public class ProductReviewSteps {
	
	Driver driver = new Driver();
	private HomePage homePage = new HomePage(Driver.getDriver());
	private ArgusAllWeatherTankProductPage argusAllWeatherTankProductPage = new ArgusAllWeatherTankProductPage(Driver.getDriver());

	@Given("User is on desired product page for review")
	public void user_is_on_desired_product_page_for_review() throws InterruptedException {
	    homePage.clickOnArgusAllWeatherTankLink();
	    Thread.sleep(1000);
	}
	
	@When("User clicks on review tab")
	public void user_clicks_on_review_tab() {
	    argusAllWeatherTankProductPage.clickOnReviewTab();
	}

	@When("User fills out all mandatory fields for review")
	public void user_fills_out_all_mandatory_fields_for_review() throws IOException {
	    argusAllWeatherTankProductPage.fillOutMandatoryFieldsForReview(driver.getProperties("nickname"), driver.getProperties("reviewSummary"), driver.getProperties("reviewText"));
	}

	@When("User clicks to submit the review")
	public void user_clicks_to_submit_the_review() {
	    argusAllWeatherTankProductPage.clickOnSubmitReview();
	}

	@Then("User should be notified that the review is submitted")
	public void user_should_be_notified_that_the_review_is_submitted() {
	    argusAllWeatherTankProductPage.verifyConfirmationMessageDisplayed();
	}

	@When("User clicks to submit an empty review")
	public void user_clicks_to_submit_an_empty_review() {
	    argusAllWeatherTankProductPage.clickOnSubmitReview();
	}

	@Then("Message about required field not being filled should appear for mandatory fields")
	public void message_about_required_field_not_being_filled_should_appear_for_mandatory_fields() {
	    argusAllWeatherTankProductPage.assertAllMandatoryFields();
	}
}
