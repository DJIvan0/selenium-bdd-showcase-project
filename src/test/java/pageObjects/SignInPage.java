package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	private WebElement emailAddressField;

	@FindBy(how = How.XPATH, using = "//fieldset[@class='fieldset login']//input[@id='pass']")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	private WebElement signInButton;

	public void enterEmailAddress(String email) {
		emailAddressField.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnSignInButton() {
		signInButton.click();
	}

}
