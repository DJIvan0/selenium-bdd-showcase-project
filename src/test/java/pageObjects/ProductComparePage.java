package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductComparePage extends BasePage {
	
	public ProductComparePage(WebDriver driver) {
		super(driver);
	}
	
	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	@FindBy(how = How.XPATH, using = "//a[@title='Remove Product']")
	private WebElement removeProductLink;
	
	@FindBy(how = How.XPATH, using = "//div[@class='modal-inner-wrap']//span[text()='OK']")
	private WebElement okButton;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Add to Cart']")
	private WebElement addToCartButton;
	
	@FindBy(how = How.XPATH, using = "//div[@role='alert']")
	private WebElement confirmationMessage;
	
	@FindBy(how = How.XPATH, using = "//div[text()='You have no items to compare.']")
	private WebElement noItemsForComparisonMessage;
	
	public void verifyaddToCartButtonPresent() {
		Assert.assertTrue(addToCartButton.isDisplayed());
	}
	
	public void clickToRemoveProduct() {
		wait.until(ExpectedConditions.elementToBeClickable(removeProductLink));
		removeProductLink.click();
	}
	
	public void confirmChoiceToRemoveProduct() {
		okButton.click();
	}
	public void verifyRemovalConfirmationMessagePresent() {
		wait.until(ExpectedConditions.visibilityOf(noItemsForComparisonMessage));
		Assert.assertTrue(noItemsForComparisonMessage.isDisplayed());
	}

}
