package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//button[@data-role='proceed-to-checkout']")
	private WebElement proceedToCheckoutButton;
	
	public void verifyProceedToCheckoutButtonPresent() {
		Assert.assertTrue(proceedToCheckoutButton.isDisplayed());
	}
}
