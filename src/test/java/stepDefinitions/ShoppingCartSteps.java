package stepDefinitions;

import java.util.Random;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HeroHoodieProductPage;
import pageObjects.HomePage;
import pageObjects.ShoppingCartPage;
import resources.Driver;
import resources.ProductColor;
import resources.ProductSize;

public class ShoppingCartSteps {

	private HomePage homePage = new HomePage(Driver.getDriver());
	private HeroHoodieProductPage heroHoodieProductPage = new HeroHoodieProductPage(Driver.getDriver());
	private ShoppingCartPage shoppingCartPage = new ShoppingCartPage(Driver.getDriver());


	@Given("User is on desired product page for shopping cart")
	public void user_is_on_desired_product_page_for_shopping_cart() throws InterruptedException {
	    homePage.clickOnHeroHoodieLink();
	    Thread.sleep(1000);
	}

	@When("User clicks on add to cart button")
	public void user_clicks_on_add_to_cart_button() {
	    heroHoodieProductPage.clickOnAddToCart(true);
	}
	
	@When("User clicks on add to cart button without any fields filled")
	public void user_clicks_on_add_to_cart_button_without_any_fields_filled() {
	    heroHoodieProductPage.clickOnAddToCart(false);
	}
	
	@When("User fills out all mandatory fields for shopping cart")
	public void user_fills_out_all_mandatory_fields_for_shopping_cart() {
		heroHoodieProductPage.fillOutFieldsForShoppingCart(ProductSize.L, ProductColor.BLACK, new Random().nextInt(10) + 1);
	}
	
	@When("User clicks on shopping cart page link")
	public void user_clicks_on_shopping_cart_page_link() {
		heroHoodieProductPage.clickOnShoppingCartLink();
	}

	@Then("User should be taken to shopping cart page and see added product displayed")
	public void user_should_be_taken_to_shopping_cart_page_and_see_added_product_displayed() {
		shoppingCartPage.verifyProceedToCheckoutButtonPresent();
	}

	@Then("Message about required fields not being filled should appear")
	public void message_about_required_fields_not_being_filled_should_appear() {
	    heroHoodieProductPage.assertAllMandatoryFields();
	}
}
