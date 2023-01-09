package pageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeroHoodieProductPage {

	WebDriver driver;

	public HeroHoodieProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='option-label-size-143-item-169']")
	private WebElement sizeLOption;

	@FindBy(how = How.XPATH, using = "//div[@id='option-label-color-93-item-49']")
	private WebElement colorBlackOption;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Add to Cart']")
	private WebElement addToCartButton;

	@FindBy(how = How.XPATH, using = "//a[@class='action showcart']")
	private WebElement showCartLink;

	@FindBy(how = How.XPATH, using = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement confirmationMessage;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='shopping cart']")
	private WebElement shoppingCartLink;

	public void clickOnSizeLOption() {
		sizeLOption.click();
	}

	public void clickOnColorBlackOption() {
		colorBlackOption.click();
	}

	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}

	public void clickOnShowCartLink() {
		showCartLink.click();
	}

	public void assertConfirmationMessagePresent() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(confirmationMessage));
		Assert.assertTrue(confirmationMessage.isDisplayed());
		Assert.assertTrue(shoppingCartLink.isDisplayed());
	}
}
