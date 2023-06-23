package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import resources.ProductColor;
import resources.ProductSize;

public class HeroHoodieProductPage extends BasePage {

	public HeroHoodieProductPage(WebDriver driver) {
		super(driver);
	}

	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	@FindBy(how = How.ID, using = "option-label-color-93-item-49")
	private WebElement blackColorOption;

	@FindBy(how = How.ID, using = "option-label-color-93-item-52")
	private WebElement greyColorOption;

	@FindBy(how = How.ID, using = "option-label-color-93-item-53")
	private WebElement greenColorOption;

	@FindBy(how = How.ID, using = "option-label-size-143-item-166")
	private WebElement xsSizeOption;

	@FindBy(how = How.ID, using = "option-label-size-143-item-167")
	private WebElement sSizeOption;

	@FindBy(how = How.ID, using = "option-label-size-143-item-168")
	private WebElement mSizeOption;

	@FindBy(how = How.ID, using = "option-label-size-143-item-169")
	private WebElement lSizeOption;

	@FindBy(how = How.ID, using = "option-label-size-143-item-170")
	private WebElement xlSizeOption;

	@FindBy(how = How.ID, using = "qty")
	private WebElement quantityInputField;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Add to Cart']")
	private WebElement addToCartButton;

	@FindBy(how = How.XPATH, using = "//div[@role='alert']")
	private WebElement confirmationMessage;

	@FindBy(how = How.ID, using = "super_attribute[143]-error")
	private WebElement sizeErrorMessageText;

	@FindBy(how = How.ID, using = "super_attribute[93]-error")
	private WebElement colorErrorMessageText;

	@FindBy(how = How.ID, using = "qty-error")
	private WebElement quantityErrorMessageText;

	@FindBy(how = How.XPATH, using = "//a[text()='shopping cart']")
	private WebElement shoppingCartPageConfirmationMessageLink;

	@FindBy(how = How.XPATH, using = "//a[@class='action showcart']")
	private WebElement showCartLink;

	public void clickOnAddToCart(boolean fields) {
		if (fields) {
			addToCartButton.click();
		} else {
			quantityInputField.click();
			quantityInputField.sendKeys(Keys.BACK_SPACE);
			addToCartButton.click();
		}
	}

	public void fillOutFieldsForShoppingCart(ProductSize productSize, ProductColor productColor, int quantity) {
		switch (productSize) {
		case XS:
			xsSizeOption.click();
			break;
		case S:
			sSizeOption.click();
			break;
		case M:
			mSizeOption.click();
			break;
		case L:
			lSizeOption.click();
			break;
		case XL:
			xlSizeOption.click();
			break;
		}

		switch (productColor) {
		case BLACK:
			blackColorOption.click();
			break;
		case GREY:
			greyColorOption.click();
			break;
		case GREEN:
			greenColorOption.click();
			break;
		}

		quantityInputField.clear();
		quantityInputField.sendKeys(String.valueOf(quantity));
	}
	
	public void clickOnShoppingCartLink() {
		wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
		shoppingCartPageConfirmationMessageLink.click();
	}

	public void assertAllMandatoryFields() {
		String actualMessage = "This is a required field.";
		Assert.assertEquals(sizeErrorMessageText.getText(), actualMessage);
		Assert.assertEquals(colorErrorMessageText.getText(), actualMessage);
		Assert.assertEquals(colorErrorMessageText.getText(), actualMessage);
	}
}
